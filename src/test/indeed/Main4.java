package test.indeed;

import java.util.Scanner;

/**
 * 
 * Description: 
 */
public class Main4 {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			int N = reader.nextInt();
			double[] array = new double[N + 1];
			array[1] = 1;
			array[2] = 1;
			array[3] = 5 / 3;
			for(int i = 3; i < N + 1; i ++) {
				double val = 0;
				for(int j = 0; j < i; j ++) {
						val += 1.0 / i * (1 + getResult(array, i - j - 2) + getResult(array, j - 1));
				}
				array[i] = val;
			}
			System.out.println(array[N]);
		}
		reader.close();
	}
	
	private static double getResult(double[] array, int index) {
		if(index < 0) {
			return 0;
		}
		return array[index];
	}
	
	public static void main(String[] args) {
		Main4.solve();
	}
}