package leetcode.string;

public class LongestPalindromicSubstring {
	/**
	 * Dynamic Program
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome1(String s) {
		if(null == s || s.length() <= 1) {
			return s;
		}
		int len = s.length();
		int maxStart = 0, maxEnd = 0;
		boolean[][] table = new boolean[len][len];
		for(int i = 0; i < len; i ++) {
			table[i][i] = true;
		}
		for(int i = 0; i < len - 1; i ++) {
			if(s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = true;
				maxStart = i;
				maxEnd = i + 1;
			}
		}

		for(int l = 2; l < len; l ++) {
			for(int i = 0; i + l < len; i ++) {
				if(s.charAt(i) == s.charAt(i + l) && table[i + 1][i + l - 1]) {
					table[i][i + l] = true;
					maxStart = i;
					maxEnd = i + l;
				}
			}
		}
		return s.substring(maxStart, maxEnd + 1);
	}
	
	public String longestPalindrome2(String s) {
		if(null == s || s.length() <= 1) {
			return s;
		}
		int start = 0, end = 0;
		for(int i = 0; i < s.length(); i ++) {
			int len1 = expandFromCenter(s, i, i);
			int len2 = expandFromCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if(len > end - start + 1) {//there are difference between: if(len > end - start + 1)
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}
	
	private int expandFromCenter(String s, int left, int right) {
		int l = left, r = right;
		while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l --;
			r ++;
		}
		return r - l - 1;
	}
	public static void main(String[] args) {
		LongestPalindromicSubstring so = new LongestPalindromicSubstring();
		String[] tests = {
				null,
				"",
				"a",
				"ab",
				"abcdefghheedcba"
		};
		for(String s : tests) {
			System.out.println(so.longestPalindrome1(s));
			System.out.println(so.longestPalindrome2(s));
		}
	}
}
