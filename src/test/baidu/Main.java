package test.baidu;

import java.util.Scanner;

/**
 * 
 * Description: 
 */
public class Main {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			int N = Integer.parseInt(reader.nextLine());
			while(N > 0) {
				N --;
				//get data
				String s = reader.nextLine();
				String[] sarry = s.split(" ");
				int n = Integer.parseInt(sarry[0]);
				int m = Integer.parseInt(sarry[1]);
				int[][] A = new int[n][m];
				for(int i = 0; i < n; i ++) {
					s = reader.nextLine();
					sarry = s.split(" ");
					for(int j = 0; j < m; j ++) {
						A[i][j] = Integer.parseInt(sarry[j]);
					}
				}
				
				//compute.
				int res = deal(A);
				System.out.println(res);
			}
		}
		reader.close();
	}
	
	public static int deal(int[][] A) {
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
	
	public static int getMaxSumOfOneDimension(int[] A) {
		int nEnd = A[0];
		int nAll = A[0];
		for(int i = 1; i < A.length; i ++) {
			nEnd = Math.max(A[i], A[i] + nEnd);
			nAll = Math.max(nEnd, nAll);
		}
		return nAll;
	}
	
	public static void main(String[] args) {
		Main.solve();
	}
}
