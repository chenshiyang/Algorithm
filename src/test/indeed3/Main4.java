package test.indeed3;

import java.util.Scanner;

/**
 * 
 * Description: Indeed round 3, test4.
 * Given N, indicates we have numbers which range from 1 to N.
 * We need to find a permutation of 1 to N. So that it satisfies these conditions:
 * We are given M condition.
 * Each condition is expressed in two numbers like this 
 * i, j
 * which shows that the ith number of this sequence can not be j.
 * 
 * We only need to find a satisfied solution, there is not need to find all.
 * 
 * Example:
 * 2    //N is 2
 * 1    // M is 1, one condition
 * 1 1  // the 1st number can not be 1.
 * 
 * output:
 * 2
 * 1
 * 
 * 
 * Solution:  use backtrack.
 */
public class Main4 {
	static boolean good = false;
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			int N = reader.nextInt();
			int M = reader.nextInt();
			int[][] array = new int[N][N];
			while(M > 0) {
				M --;
				int i = reader.nextInt() - 1;
				int j = reader.nextInt() - 1;
				array[i][j] = -1;
			}
//			for(int i = 0; i < array.length; i ++) {
//				for(int j = 0; j < array[0].length; j ++) {
//					System.out.print(array[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			int[] row = new int[N];
			for(int i = 0; i < row.length; i ++) {
				row[i] = - 1;
			}
			int[] col = new int[N];
			for(int i = 0; i < col.length; i ++) {
				col[i] = - 1;
			}
			backtrack(row, col, 0, array);
		}
		reader.close();
	}
	
	/**
	* Description:
	* @param array
	* @param row
	* @param col
	* @param index , the number of current row
	* @param matrix
	*/
	public static void backtrack(int[] row, int[] col, int index, int[][] matrix) {
		//if a satisfied solution has been found, then return.
		if(good) {
			return;
		}
		//now get the first solution.
		if(index == row.length) {
			for(int i = 0; i < row.length; i ++) {
				System.out.println(row[i] + 1);
			}
			good = true;// suggests that a solution is found.
			return;
		}
		
		for(int i = 0; i < col.length; i ++) {
			//check if a solution is found.
			if(good) {
				return;
			}
			if(col[i] == -1 && matrix[index][i] != -1) {
				row[index] = i;//for row[index], we choose i.
				col[i] = 1;// the ith column is occupied.
				backtrack(row, col, index + 1, matrix);
				//recover
				row[index] = -1;
				col[i] = -1;
			}
		}
	}
	
	public static void main(String[] args) {
		Main4.solve();
	}
}