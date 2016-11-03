package test.indeed3;

import java.util.Scanner;

/**
 * 
 *  Description: Brute force solution of indeed round3, test2.
 */
public class Main22 {
	
	public static String min;
	
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			String S = reader.nextLine();
			int K = Integer.parseInt(reader.nextLine());
			
			if(K > S.length()) {
				System.out.println("No solution.");
				continue;
			}
			
			if(K == S.length()) {
				System.out.println(S);
				continue;
			}
			int[] array = new int[10];
			min = S;
			for(char c : S.toCharArray()) {
				array[c - 'a'] += 1;
			}
			boolean[] remove = new boolean[10];
			deal(S, K, array, remove, 0);
			System.out.println(min);
		}
		reader.close();
	}
	
	public static void deal(String s, int k, int[] array, boolean[] remove, int index) {
		if(index == array.length) {
			//compute
			computeAndCompare(s, remove);
			return;
		}
		int sum = 0;
		remove[index] = true;
		for(int i = 0; i <= index; i ++) {
			if(remove[i]) {
				sum += array[i];
			}
		}
		if(s.length() - sum >= k) {//can remove
			deal(s, k, array, remove, index + 1);
		}
		remove[index] = false;
		deal(s, k, array, remove, index + 1);
	}
	
	public static void computeAndCompare(String s, boolean[] remove) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); ++ i) {
			if(!remove[s.charAt(i) - 'a']) {
				sb.append(s.charAt(i));
			}
		}
		String newString = sb.toString();
		min = min.compareTo(newString) < 0 ? min : newString;
	}
	
	public static void main(String[] args) {
		Main22.solve();
	}
}

