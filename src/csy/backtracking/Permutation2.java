package csy.backtracking;

/**
 * 
 * Description: given an array, output the result of A(k, n). n is the length of array, and k 
 * is the number of integer we want.
 */
public class Permutation2 {
	
	public void getPermutation(int[] array, int begin, int k) {
		//base condition.
		if(begin == k) {
			for(int i = 0; i < k; i ++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = begin; i < array.length; ++ i) {
			swap(array, begin, i);
			getPermutation(array, begin + 1, k);
			swap(array, begin, i);
		}
	}
	
	public void swap(int[] array, int left, int right) {
		if(left == right) {
			return;
		}
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public static void main(String[] args) {
		Permutation2 so = new Permutation2();
		int[] array = {1, 2, 3, 4};
//		so.getPermutation(array, 0, 1);
//		so.getPermutation(array, 0, 2);
		so.getPermutation(array, 0, array.length);//equals to full permutation
		
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
