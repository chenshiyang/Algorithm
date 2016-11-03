package csy.backtracking;

import java.util.Arrays;

/**
 * 
 * Description:  Enumerate the combinations of input array,
 * as long as the input array is lexigraphically inorder,
 * then then output will be lexigraphically inorder too.
 */
public class EnumerateCombinations2 {
	
	public static void backtrack(int index, int size, int[] subset, int[] array) {//size is the size of subset
		for(int i = 0; i < size; ++ i) {
			System.out.print(subset[i] + " ");
		}
		System.out.println();
		
		for(; index < array.length; ++ index) {
			//select array[index] as the size-th number. 
			subset[size] = array[index];
			backtrack(index + 1, size + 1, subset, array);
			
		}
	}
	
	public static void enumerate(int[] array) {
		int[] subset = new int[array.length];
		backtrack(0, 0, subset, array);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 3, 2, 4};
		Arrays.sort(array);
		EnumerateCombinations2.enumerate(array);
	}
}
