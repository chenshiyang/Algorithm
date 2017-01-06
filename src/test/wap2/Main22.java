package test.wap2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * Description: 
 */
public class Main22 {
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
			solution.add(i);
		}
		results[1][1].solutions.add(solution);
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

			if(results[1][j - 1].score == maxScore) {
				results[1][j].solutions.addAll(results[1][j - 1].solutions);
			}
			if(score == maxScore) {
				HashSet<Integer> so = new HashSet<>();
				so.add(j);
				for(Integer room : rooms[j].neighbors) {
					so.add(rooms[room].id);
				}
				results[1][j].solutions.add(so);
			}
		}
		
		//start dp
		for(int i = 2; i < M + 1; i ++) {
			for(int j = 2; j < N + 1; j ++) {
				//results[i][j] = max {A[i - 1][j], A[i - 1][j - 1] + room[j].currentScore}
				int maxScore = results[i][j - 1].score;
				List<Integer> scores = new ArrayList<>();//to remember the score of each solution.
				for(Set<Integer> so : results[i - 1][j - 1].solutions) {
					int score = results[i - 1][j - 1].score;
					if(!so.contains(j)) {// if room[j] not in results[i - 1][j - 1].solution
						score += rooms[j].val;
					}
					for(Integer id : rooms[j].neighbors) {
						if(!so.contains(id)) {
							score += rooms[id].val;
						}
					}
					scores.add(score);
					maxScore = Math.max(maxScore, score);
				}
				
				//second time iterate through results[i][j - 1].solutions and results[i - 1][j - 1].solutions
				results[i][j] = new Result();
				results[i][j].score = maxScore;
				if(results[i][j - 1].score == maxScore) {
					results[i][j].solutions.addAll(results[i][j - 1].solutions);
				}
				for(int k = 0; k < scores.size(); k ++) {
					if(scores.get(k) == maxScore) {
						HashSet<Integer> so = new HashSet<>();
						so.addAll(results[i - 1][j - 1].solutions.get(k));//results[i][j - 1]'s kth solution
						so.add(j);//plus rooms[j]
						//plus rooms[j]'s neighbors
						for(Integer id : rooms[j].neighbors) {
							so.add(id);
						}
						results[i][j].solutions.add(so);
					}
				}
			}
		}
//		System.out.println(results[1][1].score);
		System.out.println(results[M][N].score);
		System.out.println(results[M][N].solutions);
//		for(Integer i : results[M][N].solution) {
//			System.out.print(i + "\t");
//		}
//		System.out.println();
//		for(Integer i : results[M][N].solution) {
//			System.out.print(rooms[i].val + "\t");
//		}
//		System.out.println();
//		Set<Integer> set = new HashSet<Integer>();
//		for(Integer i : results[M][N].solution) {
//			if(!set.contains(i)) {
//				set.add(i);
//			}
//			for(Integer j : rooms[i].neighbors) {
//				if(!set.contains(j)) {
//					set.add(j);
//				}
//			}
//		}
//		int total = 0;
//		for(Integer i : set) {
//			System.out.print(i + ": " + rooms[i].val + ", ");
//			total += rooms[i].val;
//		}
//		System.out.println();
//		System.out.println(total);
//		for(int i = 0; i < M + 1; i ++) {
//			for(int j = 0; j < N + 1; j ++) {
//				if(null == results[i][j]) {
//					System.out.print("null" + "\t");
//				} else {
//					System.out.print(results[i][j].score + "\t");
//				}
//			}
//			System.out.println();
//		}
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
		Main22.solve();
	}
}

class Room {
	Set<Integer> neighbors = new HashSet<>();
	int id;
	int val;
	boolean accessible = false;
	
	public Room() {}
	
	public Room(int val, int id) {
		this.val = val;
		this.id = id;
	}
}

class Result {
	int score;
	List<HashSet<Integer>> solutions;
	
	public Result() {
		score = 0;
		solutions = new ArrayList<HashSet<Integer>>();//Integer: index of room in array rooms
	}
}