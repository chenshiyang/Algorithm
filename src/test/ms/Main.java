package test.ms;

import java.util.Scanner;


/**
 * 
 * Description: Microsoft test 1.
 */
public class Main {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			int N = reader.nextInt();
			int numOdd = 0;
			int numEven = 0;
			while(N > 0) {
				N --;
				if(reader.nextInt() % 2 == 0) {
					++ numEven;
				} else {
					++ numOdd;
				}
			}
			System.out.println(Math.abs(numEven - numOdd));
		}
		reader.close();
	}
	
	public static void main(String[] args) {
		Main.solve();
	}
}