package csy.backtracking;

import java.util.Arrays;

/**
 * 
 * Description: 
 * Given a char array, enumerate all the possible permutations of these chars.
 * Remember to remvoe duplicate results.
 * 
 * Example:
 * given  abb
 * 
 * output:
 * abb
 * bba
 * bab
 * 
 * 
 * Solution: sort the input char array, and at each loop, compare the char used in last loop with
 * the char in current loop, if the same, just skip this loop.
 */
public class EnumerateLetterPermutations {
	
	public static void backtrack(char[] result, char[] carry, int[] count, int index) {
		//base condition
		if(index == result.length) {
			for(char c : result) {
				System.out.print(c);
			}
			System.out.println();
			return;
		}
		
		char prev = ' ';
		for(int i = 0; i < carry.length; ++ i) {
			if(count[carry[i]] > 0 && carry[i] != prev) {
				result[index] = carry[i];
				count[carry[i]] -= 1;
				prev = carry[i];//remember the char used in last loop.
				backtrack(result, carry, count, index + 1);
				//recover
				count[carry[i]] += 1;
			}
		}
	}
	
	public static void getPermutations(char[] carry) {
		Arrays.sort(carry);//sort the input array, important.
		char[] result = new char[carry.length];
		int[] count = new int[256];//asicii code
		for(char c : carry) {
			count[c] ++;
		}
		backtrack(result, carry, count, 0);
	}
	
	public static void main(String[] args) {
		char[] carry = "abcb".toCharArray();
		EnumerateLetterPermutations.getPermutations(carry);
	}
}
