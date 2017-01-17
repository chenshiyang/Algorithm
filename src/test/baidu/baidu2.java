package test.baidu;

import java.util.*;

public class baidu2 {
	static int[][] cache;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[][] table = new int[n][m];
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					table[j][k] = sc.nextInt();
				}
			}
			
			cache = new int[n][m];
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					if(j == 0) {
						cache[j][k] = table[j][k]; 
					} else {
						cache[j][k] = cache[j-1][k] + table[j][k];
					}
				}
			}
			System.out.println(maxSubMatrix(table));
		}
		sc.close();
	}

	public static int[] onedimension(int[] a) {
		// result[0] == maxSum, result[1] == start, result[2] == end;
		int[] result = new int[] { Integer.MIN_VALUE, 0, -1 };
		int csum = 0;
		int lstart = 0;

		for (int i = 0; i < a.length; i++) {
			csum += a[i];
			if (csum < 0) {
				csum = 0;
				lstart = i + 1;
			} else if (csum > result[0]) {
				result[0] = csum;
				result[1] = lstart;
				result[2] = i;
			}
		}

		// all numbers in a are negative
		if (result[2] == -1) {
			result[0] = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] > result[0]) {
					result[0] = a[i];
					result[1] = i;
					result[2] = i;
				}
			}
		}

		return result;
	}
	
	public static int maxSubArray(int[] A) {
		int max = A[0];
		int maxEndingHere = A[0];
		for(int i = 1; i < A.length; i++) {
			if(maxEndingHere < 0) maxEndingHere = A[i];
			else maxEndingHere = maxEndingHere + A[i];
			if(max < maxEndingHere) max = maxEndingHere;
		}
		return max;
	}
	
	
	public static long maxSubMatrix(int[][] table) {
		long maxSum = Long.MIN_VALUE;
		for(int i = 0; i < table.length; i++) {
			for(int j = i; j < table.length; j++) {
				int[] t = new int[table[0].length];
				for(int p = 0; p < t.length; p++) {
					if(i == 0) {
						t[p] = cache[j][p];
					} else {
						t[p] = cache[j][p] - cache[i-1][p];
					}
				}
				maxSum = Math.max(maxSum, maxSubArray(t));
			}
		}
		
		return maxSum;
	}

	public static long findMaxSubMatrix(int[][] a) {
		int cols = a[0].length;
		int rows = a.length;
		int[] currentResult;
		long maxSum = Long.MIN_VALUE;

		for (int lc = 0; lc < cols; lc++) {
			int[] tmp = new int[rows];

			for (int rc = lc; rc < cols; rc++) {

				for (int i = 0; i < rows; i++) {
					tmp[i] += a[i][rc];
				}
				currentResult = onedimension(tmp);
				if (currentResult[0] > maxSum) {
					maxSum = currentResult[0];
				}
			}
		}
		return maxSum;
	}
}
