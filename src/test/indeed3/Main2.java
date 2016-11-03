package test.indeed3;

import java.util.Scanner;

/**
 * 
 * Description: Indeed round 3, test 2.
 * Problem:
 * the first line is a string S. the character in S only contain a, b, c, d, e, f, g, h, i, j. (i.e. 10 kinds of chars)
 * the second line is a integer K.
 * we can remove  some chars from S, then get a new string s2. for example, given "abcda", we can remove 'a',
 * get "bcd", or remove 'b' and 'c', get "ada".
 * 
 * We need to find such a string min that min.length() >= K and, min is lexicographically smallest.
 * 
 * Example:
 * ajjjj
 * 1
 * 
 * output:
 * a
 * 
 * ajjjj
 * 2
 * output:
 * jjjj
 * 
 * 
 * Greedy solution. Remove from left side. Each time before we remove a char, we need to
 * check if the new string satisfy the conditions.
 */
public class Main2 {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			String S = reader.nextLine();
			int K = Integer.parseInt(reader.nextLine());
			
			if(K == S.length()) {
				System.out.println(S);
				continue;
			}
			
			String s = new String(S);
			while(s.length() >= K) {
				int i = 0;
				for(; i < s.length(); i ++) {
					String s2 = s.replaceAll(String.valueOf(s.charAt(i)), "");
					if(s.compareTo(s2) > 0 && s2.length() >= K) {
						s = s2;
//						System.out.println(s);
						break;
					}
				}
				if(i == s.length()) {// can not be better.
					break;
				}
//				if(s.length() == K) {
//					break;
//				}
			}
			System.out.println(s);
		}
		reader.close();
	}
	
	public static void main(String[] args) {
		Main2.solve();
	}
}
