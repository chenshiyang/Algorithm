package csy.dp;

import java.util.Random;

/**
 * solve: find a rectangle from a two dimension array, such that the sum of the rectangle is maximum.
 * solve1: Time complexity is O(N*M) + O(N^2*M*2) = O(N^2*M*2).
 * 
 * solve2: Time complexity is O(N^2 * M), space complexity is O(N * M)
 * 
 * reference: The Beauty of Coding.
 * 
 * @author shiyangc
 *
 */
public class TwoDimensionMaximumSubarray {
	public int solve(int[][] A) {
		if(null == A || A.length < 1) {
			return 0;
		}
		
		int N = A.length;
		int M = A[0].length;
		int[][] ps = new int[N + 1][M + 1];//ps: partial sum, note here the index we start from 1, not 0.
		
		//initialize
		for(int i = 0; i < ps.length; i ++) {
			ps[i][0] = 0;
		}
		for(int j = 0; j < ps[0].length; j ++) {
			ps[0][j] = 0;
		}
		//get partial sum
		//i, j is the right bottom coordinates of the square
		for(int i = 1; i < ps.length; i ++) {
			for(int j = 1; j < ps[0].length; j ++) {
				ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + A[i - 1][j - 1];
			}
		}
		
		//get max sum
		int a = 0, b = 0, c = 1, d = 1;//the index of max square
		int max = A[0][0];
		for(int i = 0; i <= N; i ++) {
			for(int j = i + 1; j <= N; j ++) {
				for(int m = 0; m <= M; m ++) {
					for(int n = m + 1; n <= M; n ++) {
						int square = ps[j][n] - ps[j][m] - ps[i][n] + ps[i][m];
						if(square > max) {
							max = square;
							a = i;
							b = j;
							c = m;
							d = n;
						}
					}
				}
			}
		}
		
		System.out.println("the maximum is " + a + "," + b + "," + c + "," + d + ", square is " + max);
		display(A, a, b, c, d);
		return max;
	}
	
	public void display(int[][] A) {
		for(int i = 0; i < A.length; i ++) {
			for(int j = 0; j < A[0].length; j ++) {
				System.out.print(A[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void display(int[][] A, int a, int b, int c, int d) {
		for(int i = a; i < b; i ++) {
			for(int j = c; j < d; j ++) {
				System.out.print(A[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	* Description: Compact the two dimension array to a one dimension array.
	* @param A
	* @return
	*/
	public int solve2(int[][] A) {
		if(null == A || A.length == 0) {
			return 0;
		}
		
		int N = A.length;
		int M = A[0].length;
		int max = Integer.MIN_VALUE;
		//time complexity is O(N^2 * M)
		for(int i = 0; i < N; i ++) {
			int[] partialSum = new int[M]; //space complexity is O(N * M)
			for(int j = i; j < N; j ++) {
				//fill this line
				for(int k = 0; k < M; k ++) {
					partialSum[k] += A[j][k];
				}
				//compute the maximum sum of this "one dimension array"
				max = Math.max(max, getMaxSumOfOneDimension(partialSum));
			}
		}
		return max;
	}
	
	public int getMaxSumOfOneDimension(int[] A) {
		int nEnd = A[0];
		int nAll = A[0];
		for(int i = 1; i < A.length; i ++) {
			nEnd = Math.max(A[i], A[i] + nEnd);
			nAll = Math.max(nEnd, nAll);
		}
		return nAll;
	}
	
	public static void main(String[] args) {
		TwoDimensionMaximumSubarray so = new TwoDimensionMaximumSubarray();
		Random rand = new Random();
		int num_test = 5;
		for(int i = 0; i < num_test; i ++) {
			int[][] array = new int[4][5];
			for(int j = 0; j < array.length; j ++) {
				for(int k = 0; k < array[0].length; k ++) {
					array[j][k] = rand.nextInt(10) - 5;
				}
			}
			so.display(array);
			so.solve(array);
//			System.out.println(so.solve(array) == so.solve2(array));
//			System.out.println(so.solve(array));
//			System.out.println(so.solve2(array));
		}
//		int[][] test1 = {
//				{1, -3, 4},
//				{2, 6, -5},
//				{-2, -5, 2}
//		};
//		so.display(test1);
//		so.solve(test1);
	}
}