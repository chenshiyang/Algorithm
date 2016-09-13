package leetcode.string;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	/**
	 * Given a string S, find the length of the longest substring T that contains at
	 * most two distinct characters.
	 * 
	 * Solution: Two pointers. Time Complexity is O(2n)
	 * 
	 * This solution can be extended to k distinct characters.
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if(null == s) {
			return -1;
		}
		if(s.length() <= 2) {
			return s.length();
		}
		int[] count = new int[256];
		int i = 0, numDistinct = 0, maxLen = 0;
		for(int j = 0; j < s.length(); j ++) {
			if(count[s.charAt(j)] == 0) {
				numDistinct ++;
			}
			count[s.charAt(j)] ++;
			while(numDistinct > 2) {
				count[s.charAt(i)] --;
				if(count[s.charAt(i)] == 0) {
					numDistinct --;
				}
				i ++;
			}
			maxLen = Math.max(maxLen, j - i + 1);
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		LongestSubstringWithAtMostTwoDistinctCharacters so = new LongestSubstringWithAtMostTwoDistinctCharacters();
		String[] tests = {
				"",
				"a",
				"ab",
				"abc",
				"ababcba"
		};
		for(String s : tests) {
			System.out.println(so.lengthOfLongestSubstringTwoDistinct(s));
		}
	}
}
