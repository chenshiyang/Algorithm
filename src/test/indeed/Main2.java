package test.indeed;

import java.util.Scanner;

/**
 * 
 * Description: 
 */
public class Main2 {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			int N = reader.nextInt();
			int M = reader.nextInt();
			int K = reader.nextInt();
			int[][] A = new int[N][M];
			int[][] B = new int[M][K];
			
			for(int i = 0; i < N; i ++) {
				for(int j = 0; j < M; j ++) {
					A[i][j] = reader.nextInt();
				}
			}
			
			for(int i = 0; i < M; i ++) {
				for(int j = 0; j < K; j ++) {
					B[i][j] = reader.nextInt();
				}
			}
			int[][] result = new int[N][K];
			for(int i = 0; i < N; i ++) {
				for(int j = 0; j < K; j ++) {
					int val = 0;
					for(int k = 0; k < M; k ++) {
						val += A[i][k] * B[k][j];
					}
					result[i][j] = val;
				}
			}
			
			//print result
			for(int i = 0; i < N; i ++) {
				for(int j = 0; j < K; j ++) {
					System.out.print(result[i][j] + " ");
				}
				System.out.println();
			}
		}
		reader.close();
	}
	
	public static void main(String[] args) {
		Main2.solve();
	}
}
