package test.toutiao2;

import java.util.Scanner;

/**
 * 
 * Description: 
 */
public class Main2 {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			String needle = reader.nextLine();
			String haystack = needle + needle;
			System.out.println(countMatch(haystack, needle));
		}
		reader.close();
	}
	
	public static int countMatch(String haystack, String needle) {
		int count = -1;
		int[] next = makeNext(needle);
		int j = 0;
		for(int i = 0; i < haystack.length(); i ++) {
			while(j != 0 && needle.charAt(j) != haystack.charAt(i)) {
				j = next[j - 1];
			}
			if(needle.charAt(j) == haystack.charAt(i)) {
				j ++;
			}
			if(j == needle.length()) {
				j = next[j - 1];
				count ++;
			}
		}
		return count;
	}
	
	private static int[] makeNext(String needle) {
		int[] next = new int[needle.length()];
		int j = 0;

		for(int i = 1; i < needle.length(); i ++) {
			while(j != 0 && needle.charAt(i) != needle.charAt(j)) {
				j = next[j - 1];
			}
			if(needle.charAt(i) == needle.charAt(j)) {
				j ++;
			}
			next[i] = j;
		}
		return next;
	}
	
	public static void main(String[] args) {
		Main2.solve();
	}
}