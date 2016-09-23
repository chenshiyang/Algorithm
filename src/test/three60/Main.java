package test.three60;

import java.util.Scanner;

/**
 * 
 * Description: 360 coding test 1.
 */
public class Main {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			String[] sarry = new String[3];
			for(int i = 0; i < 3; i ++) {
				sarry[i] = reader.nextLine();
			}
			boolean symmetric = true;
			for(int i = 0; i < 3; i ++) {
				if(!symmetric) {
					break;
				}
				for(int j = 0; j < 3 - i; j ++) {
					if(sarry[i].charAt(j) != sarry[2 - i].charAt(2 - j)) {
						symmetric = false;
						break;
					}
				}
			}
			if(symmetric) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		reader.close();
	}
	
	public static void main(String[] args) {
		Main.solve();
	}
}
