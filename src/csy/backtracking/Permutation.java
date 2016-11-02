package csy.backtracking;

/**
 * 
 * Description: Given an input array, output all the possible purmutation of
 * this array.
 */
public class Permutation {
	
	public void getPermutation(int[] array, int begin, int end) {
		//base condition, output the result or do anything else.
		if(begin == end) {
			for(int i : array) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for(int i = begin; i <= end; ++ i) {
			swap(array, begin, i);
			getPermutation(array, begin + 1, end);
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
		Permutation so = new Permutation();
		int[] array = {1, 2, 3};
		so.getPermutation(array, 0, array.length - 1);
		//the content of array won't be changed after permutation.
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
