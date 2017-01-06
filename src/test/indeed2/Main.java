package test.indeed2;

import java.util.Scanner;

/**
 * 
 * Description: 
 */
public class Main {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			int N = reader.nextInt() - 2;
			int num = 0;
			int left = reader.nextInt();
			int mid = reader.nextInt();
			int right = 0;
			while(N > 0) {
				N --;
				right = reader.nextInt();
				if(mid > left && mid > right) {
					num ++;
				}
				left = mid;
				mid = right;
			}
			System.out.println(num);
		}
		reader.close();
	}
	
	public static void main(String[] args) {
		Main.solve();
	}
}
