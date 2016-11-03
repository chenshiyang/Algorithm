package test.indeed3;

import java.util.Scanner;

/**
 * 
 * Description: indeed round 3, test 1.
 * Given the first 2 numbers. Find the 10th number of Fibonacci sequence.
 */
public class Main {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			int a = reader.nextInt();
			int b = reader.nextInt();
			
			for(int i = 3; i <= 10; i ++) {
				b += a;
				a = b - a;
			}
			System.out.println(b);
		}
		reader.close();
	}
	
	public static void main(String[] args) {
		Main.solve();
	}
}
