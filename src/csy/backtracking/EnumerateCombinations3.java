package csy.backtracking;

/**
 * 
 * Description: 
 */
import java.util.Arrays;

/**
 * 
 * Description:  Enumerate the combinations of input array,
 * Compare with EnumerateCombinations2 to check the difference.
 */
public class EnumerateCombinations3 {
	
	public static void backtrack(int index, int size, int[] subset, int[] array) {//size is the size of subset
		
		if(index == array.length) {		
			for(int i = 0; i < size; ++ i) {
				System.out.print(subset[i] + " ");
			}
			System.out.println();
			return;
		}
		
		//select array[index] as the size-th number. 
		subset[size] = array[index];
		backtrack(index + 1, size + 1, subset, array);
			
		//do not select array[index] as the size-th number.
		backtrack(index + 1, size, subset, array);
	}
	
	public static void enumerate(int[] array) {
		int[] subset = new int[array.length];
		backtrack(0, 0, subset, array);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 3, 2, 4};
		Arrays.sort(array);
		EnumerateCombinations3.enumerate(array);
	}
}