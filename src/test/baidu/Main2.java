package test.baidu;

import java.util.Scanner;

/**
 * 
 * Description: 
 */
public class Main2 {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			int Te = Integer.parseInt(reader.next());
			while(Te > 0) {
				Te --;
				int n = Integer.parseInt(reader.next());
				int res = 0;
				int total = n * 2 - 1;
				for(int i = 0; i < total; i ++) {
					res ^= Integer.parseInt(reader.next());
				}
				System.out.println(res);
			}
		}
		reader.close();
	}
	
	public static void main(String[] args) {
		Main2.solve();
	}
}
