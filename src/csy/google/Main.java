package csy.google;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * Description: 
 */
public class Main {
	
	public static void sovle() throws NumberFormatException, IOException {
		String file = "Desktop\\A-small-attempt0 (1)";
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String String = null;
		int T = Integer.parseInt(reader.readLine());
		PrintWriter writer = new PrintWriter("Desktop\\result111111111111111111111111111.txt");
		while(T > 0) {
			T --;
			String s = reader.readLine();
			String[] sarry = s.split(" ");
			int M = Integer.parseInt(sarry[0]);
			int N = Integer.parseInt(sarry[1]);
//			deal(M, N);
			writer.write("Case #1: " + deal(M, N));
		}
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static double deal(int M, int N) {
		double[][][] result = new double[M + 1][N + 1][N + 2];
		//j = 0
		for(int i = 0; i < M + 1; i ++) {
			for(int k = 0; k < N + 2; k ++) {
				result[i][0][k] = 1.0;
			}
		}
		//i = 0
		for(int j = 0; j < N + 1; j ++) {
			for(int k = 0; k < N + 2; k ++) {
				if(0 - j >= k - N) {
					result[0][j][k] = 1.0;
				}//else = 0
			}
		}
		
		//i = 1
		for(int j = 1; j < N + 1; j ++) {
			for(int k = 0; k < N + 2; k ++) {
				result[1][j][k] = 1 / (1 + j) * result[0][j - 1][k];
			}
		}
		
		//k = 0
		for(int i = 0; i < M + 1; i ++) {
			for(int j = 0; j < N + 1; j ++) {
				if(i - j > 0 - N) {
					result[i][j][0] = 1.0;
				}
			}
		}
		
		//dp
		for(int i = 2; i < M + 1; i ++) {
			for(int j = 1; j < N + 1; j ++) {
				for(int k = 1; k < N + 2; k ++) {
					result[i][j][k] = 1.0 * i / (i + j) * j / (i + j - 1) * result[i - 1][j - 1][k] +
							i * (i - 1) / (i + j) / (i + j - 1) * result[i - 2][j][k - 1];
				}
			}
		}
		return (result[M][N][N + 1]);
	}
	
	public static int getIndex(int k, int N) {
		return k + N;
	}
	
	public static void main(String[] args) throws Exception, IOException {
		Main.sovle();
//		Main.deal(1, 0);
	}
}
