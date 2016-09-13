package leetcode.string;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    	if(null == strs || strs.length == 0) {
    		return "";
    	}
    	
    	//get shortest length
    	int shortest = strs[0].length();
    	for(int i = 1; i < strs.length; i ++) {
    		if(strs[i].length() < shortest) {
    			shortest = strs[i].length();
    		}
    	}
    	
    	String s = strs[0];
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < shortest; i ++) {
    		if(isPrefix(s, strs, i)) {
    			sb.append(s.charAt(i));
    		}
    		else {
    			break;
    		}
    	}
    	return sb.toString();
    }
    
    private boolean isPrefix(String s, String[] strs, int index) {
    	for(int i = 1; i < strs.length; i ++) {
    		if(s.charAt(index) != strs[i].charAt(index)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * solution 2 : sort tow array, then compare the first element and the last element.
     * like jiabi dingli.
     * 
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
    	if(null == strs || strs.length == 0) {
    		return "";
    	}
    	
    	Arrays.sort(strs);
    	StringBuilder sb = new StringBuilder();
    	String s1 = strs[0], s2 = strs[strs.length - 1];
    	for(int i = 0; i < s1.length() && i < s2.length(); i ++) {
    		if(s1.charAt(i) == s2.charAt(i)) {
    			sb.append(s1.charAt(i));
    		}
    		else {
    			break;
    		}
    	}
    	return sb.toString();
    }
    
    public static void main(String[] args) {
		LongestCommonPrefix so = new LongestCommonPrefix();
		String[] strs = {"chenshiyang", "chenshi", "cheng", "chen"};
		String[] strs2 = {"aa", "a"};
		System.out.println(so.longestCommonPrefix(strs));
		System.out.println(so.longestCommonPrefix2(strs));
		System.out.println(so.longestCommonPrefix(strs2));
		System.out.println(so.longestCommonPrefix2(strs2));
	}
}
