package test.wap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * Description: May have some problems.e2478707-1709-4a77-87e5-5726b7c1ddec
 */
public class Main2 {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			int N = reader.nextInt();
			int M = reader.nextInt();
			Room[] rooms = new Room[N + 1];
			rooms[0] = new Room();//useless.
			for(int i = 1; i < N + 1; i ++) {
				rooms[i] = new Room(reader.nextInt(), i);
			}
			for(int i = 0; i < N - 1; i ++) {
				int left = reader.nextInt();
				int right = reader.nextInt();
				rooms[left].neighbors.add(right);
				rooms[right].neighbors.add(left);
			}
			deal(rooms, N, M);
		}
		reader.close();
	}
	
	public static void deal(Room[] rooms, int N, int M) {
		Result[][] results = new Result[M + 1][N + 1];
		
		//fill result[0][j], j from 0 to N
		for(int j = 0; j < N + 1; j ++) {
			results[0][j] = new Result();
		}
		
		//fill result[1][1]
		results[1][1] = new Result();
		HashSet<Integer> solution = new HashSet<Integer>();
		solution.add(1);
		int score1 = rooms[1].val;

		for(Integer i : rooms[1].neighbors) {
			score1 += rooms[i].val;
		}
		results[1][1].solution = solution;
		results[1][1].score = score1;
		
		//fill result[i][1], i from 2 to M
		for(int i = 2; i < M +1; i ++) {
			results[i][1] = results[1][1];
		}
		
		//fill result[1][j], j from 2 to N
		for(int j = 2; j < N + 1; j ++) {
			results[1][j] = new Result();
			int maxScore = results[1][j - 1].score;
			int score = rooms[j].val;
			for(Integer i : rooms[j].neighbors) {
				score += rooms[i].val;
			}
			maxScore = Math.max(score, maxScore);
			results[1][j].score = maxScore;

			if(score == maxScore) {
				results[1][j].solution.add(j);
			} else {
				results[1][j].solution.addAll(results[1][j - 1].solution);
			}
		}
		
		//start dp
		for(int i = 2; i < M + 1; i ++) {
			for(int j = 2; j < N + 1; j ++) {
				//results[i][j] = max {A[i][j - 1], A[i - 1][k] + room[j].currentScore}
				int maxScore = results[i][j - 1].score;
				List<Integer> scores = new ArrayList<Integer>();
				for(int m = i - 1; m < j; m ++) {
					HashSet<Integer> so = results[i - 1][m].solution;
					int score = results[i - 1][m].score;
					if(!contains(rooms, so, j)) {
						score += rooms[j].val;
					}
					for(Integer neighbor : rooms[j].neighbors) {
						if(!contains(rooms, so, neighbor)) {
							score += rooms[neighbor].val;
						}
					}
					maxScore = Math.max(maxScore, score);
					scores.add(score);
				}
				
				//second time iterate through results[i][j - 1].solutions and results[i - 1][j - 1].solution
				results[i][j] = new Result();
				results[i][j].score = maxScore;

				boolean exists = false;
				for(int m = 0; m < scores.size(); m ++) {
					int score = scores.get(m);
					if(score == maxScore) {
						exists = true;
						HashSet<Integer> so = new HashSet<>();
						so.addAll(results[i - 1][m + i - 1].solution);
						so.add(j);
						results[i][j].solution = so;
						break;
					}
				}
				if(!exists) {
					results[i][j].solution.addAll(results[i][j - 1].solution);
				}
			}
		}
		System.out.println(results[M][N].score);
	}
	
	private static boolean contains(Room[] rooms, HashSet<Integer> solution, int id) {
		for(Integer i : solution) {
			if(rooms[i].neighbors.contains(id)) {
				return true;
			}
			if(i == id) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Main2.solve();
	}
}

class Room {
	Set<Integer> neighbors = new HashSet<>();
	int id;
	int val;
	
	public Room() {}
	
	public Room(int val, int id) {
		this.val = val;
		this.id = id;
	}
}

class Result {
	int score;
	HashSet<Integer> solution;
	
	public Result() {
		score = 0;
		solution = new HashSet<Integer>();//Integer: index of room in array rooms
	}
}