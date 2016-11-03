package csy.backtracking;

/**
 * 
 * Description: Enumerate the combinations of given array.
 */
public class EnumerateCombinations {
	
	public static void backtrack(int[] array, boolean[] used, int index) {
		//base condition
		if(index == array.length) {
			for(int i = 0; i < array.length; ++ i) {
				if(used[i]) {
					System.out.print(array[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		
		used[index] = false;
		backtrack(array, used, index + 1);
		
		used[index] = true;
		backtrack(array, used, index + 1);
		used[index] = false;
	}
	
	public static void enumerateCombinations(int[] array) {
		boolean[] used = new boolean[array.length];
		backtrack(array, used, 0);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4};
		EnumerateCombinations.enumerateCombinations(array);
	}
}
