package csy.string;

/**
 * 
 * Description: The implementation of KMP algorithm.
 * Search my ONENOTE notes to get the document.
 */
public class KMP {
	
	public int kmp(String haystack, String needle) {
		if(null == needle || null == haystack || haystack.length() == 0) {
			return -1;
		}
		if(needle.length() == 0) {
			return 0;
		}
		
		int[] next = makeNext(needle);
		int j = 0;//index in needle
		for(int i = 0; i < haystack.length(); i ++) {// i is index in haystack
			while(j != 0 && needle.charAt(j) != haystack.charAt(i)) {
			    //当比较到haystack[i] != needle[j]
                //这说明haystack[i-1] 是等于needle[j-1]的
                //而next[j-1],假设其值为k 则needle[k] 是等于needle[j-1]的，直接用它来和haystak[i]比较
				j = next[j - 1];
			}
			if(needle.charAt(j) == haystack.charAt(i)) {
				j ++;
			}
			if(j == needle.length()) {
				System.out.println("Pattern occurs with shift " + (i - needle.length() + 1));
				j = next[j - 1];//if you want to get all the result, just set this so that it can continue to search.
				//if you only want the get the first occurence, just break here.
//				return i - needle.length() + 1;
			}
		}
		return -1;//未找到匹配的子串，返回-1
	}

	/**
	 * 创建部分匹配表
	 *
	 * @param needle
	 * @return
	 */
	private int[] makeNext(String needle) {
		int[] next = new int[needle.length()];//the array of the max prefix and suffix length.
		int j = 0;//the prefix/suffix length of needle.subString(0, i);
		//here j has two meaning: 1. the length of the prefix
		//						   2. the index of the jth element.
		//next[0] = 0
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
		KMP so = new KMP();
		String h1 = "BBC ABCDAB ABCDABCDABDE ABCDABD";
		String n1 = "ABCDABD";
		so.kmp(h1, n1);
		String n2 = "ABCDEF";
		System.out.println(so.kmp(h1, n2));
	}
}
