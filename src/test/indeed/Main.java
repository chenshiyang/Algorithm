package test.indeed;

import java.util.Scanner;

/**
 * 
 * Description: 
 */
public class Main {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			String s = reader.nextLine();
			String[] sarry = s.split("ra");
			StringBuilder sb = new StringBuilder();
			for(String ss : sarry) {
				sb.append(ss);
			}
			System.out.println(sb.toString());
		}
		reader.close();
	}
	
	public static void main(String[] args) {
		Main.solve();
	}
}
