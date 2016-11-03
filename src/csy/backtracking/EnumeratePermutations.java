package csy.backtracking;

/**
 * 
 * Description: Enumerate all the permutations of 1 to N.
 * Using a memo table to remember which numbers have been used.
 */
public class EnumeratePermutations {

	public static void backtrack(int N, int[] array, int index, boolean[] used) {
		//base condition
		if(index == N) {
			for(int i : array) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		for(int i = 0; i < used.length; ++ i) {
			if(!used[i]) {
				used[i] = true;
				array[index] = i;
				backtrack(N, array, index + 1, used);
				//recover
				used[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		int N = 3;
		int[] array = new int[N];
		boolean[] used = new boolean[N];
		backtrack(N, array, 0, used);
	}
}
