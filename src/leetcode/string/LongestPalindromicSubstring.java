package leetcode.string;

public class LongestPalindromicSubstring {
	/**
	 * Dynamic Program Time: O(n ^ 2) Space: O(n^2)
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
		//length == 1
		for(int i = 0; i < len; i ++) {
			table[i][i] = true;
		}
		//length == 2
		for(int i = 0; i < len - 1; i ++) {
			if(s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = true;
				maxStart = i;
				maxEnd = i + 1;
			}
		}
		
		//length > 2
		for(int l = 2; l < len; l ++) {//l: length
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
	
	/**
	* Description: choose a center, and expand to both direction from this center.
	* There 2*n - 1 centers. So the time complexity is O(N^2) Space complexity is O(1)
	* @param s
	* @return
	*/
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
	
	/**
	* Description: Manacher Solution to solve this problem.
	* Time is O(n), Space is O(n).
	* @param s
	* @return
	*/
	public String longestPalindrome3(String s) {
		if(null == s || s.length() < 2) {
			return s;
		}
		//first turn the length of s into odd, by adding "#".
		StringBuilder sb = new StringBuilder();
		sb.append('*').append('#');//add '*' to prevent array outbound.
		for(int i = 0; i < s.length(); i ++) {
			sb.append(s.charAt(i)).append('#');
		}
		sb.append('@');
		String temp = s;
		s = sb.toString();
		
		//running manacher algorithm.
		int id = 1, maxLen = 1;
		int maxId = 1;
		int[] parry = new int[s.length()];
		parry[1] = 1;
		for(int i = 2; i < 2 * temp.length() + 1; i ++) {//caution: i　< 2 * temp.length() + 1, not i < s.length()
			if(parry[id] + id > i) {
				parry[i] = Math.min(parry[id] - (i - id), parry[2 * id - i]);
			} else {
				parry[i] = 1;
			}
			while(s.charAt(i + parry[i]) == s.charAt(i - parry[i])) {
				++ parry[i];
			}
			if(i + parry[i] > id + parry[id]) {
				id = i;
			}
			if(maxLen < parry[i]) {
				maxId = i;
				maxLen = parry[i];
			}
		}

		//get the startIndex in original String
		int originalStart = (maxId - 1) / 2 - (maxLen - 1) / 2;
		return temp.substring(originalStart, originalStart + maxLen - 1);
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubstring so = new LongestPalindromicSubstring();
		String[] tests = {
				null,
				"",
				"a",
				"ab",
				"abcdefghheedcba",
				"abcdefedcbaa"
		};
//		System.out.println(so.longestPalindrome3("ghheedcba"));
		for(String s : tests) {
			System.out.println(so.longestPalindrome1(s));
			System.out.println(so.longestPalindrome2(s));
			System.out.println(so.longestPalindrome3(s));
		}
	}
}
