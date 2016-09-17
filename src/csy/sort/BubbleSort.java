package csy.sort;

/**
 * 
 * Description: Implementation of Bubble Sort.
 */
public class BubbleSort {
	/**
	* Description: Basic bubble sort, sink small to head of array.
	* @param array
	*/
	public void sort(int[] array) {
		if(null == array || array.length <= 1) {
			return;
		}
		
		for(int i = 0; i < array.length; i ++) {
			for(int j = array.length - 1; j > i; j --) {
				if(array[j - 1] > array[j]) {
					swap(array, j - 1, j);
				}
			}
		}
	}
	
	/**
	* Description: Basic bubble sort, float big to tail of array.
	* @param array
	*/
	public void sort2(int[] array) {
		if(null == array || array.length <= 1) {
			return;
		}
		
		for(int i = array.length - 1; i >= 0; i --) {
			for(int j = 0; j < i; j ++) {
				if(array[j + 1] < array[j]) {
					swap(array, j, j + 1);
				}
			}
		}
	}
	
	/**
	* Description: Improved bubble sort, use a flag to remember whether in a certain
	* loop, is there a swap operation. If not, means that the array is in order, then
	* we can return directly.
	* @param array
	*/
	public void sort3(int[] array) {
		if(null == array || array.length <= 1) {
			return;
		}
		
		for(int i = array.length - 1; i >= 0; i --) {
			boolean hasSwap = false;
			for(int j = 0; j < i; j ++) {
				if(array[j + 1] < array[j]) {
					swap(array, j, j +  1);
					hasSwap = true;
				}
			}
			if(!hasSwap) {
				return;
			}
		}
	}
	
	private void swap(int[] array, int i, int j) {
		//use xor operation to sway two number
		array[i] = array[i] ^ array[j];
		array[j] = array[i] ^ array[j];
		array[i] = array[i] ^ array[j];
	}
	
	public static void main(String[] args) {
		BubbleSort so = new BubbleSort();
		int[] test1 = null;
		int[] test2 = {4};
		int[] test3 = {1, 5, 3, 2};
		so.sort(test1);
		so.sort(test2);
		so.sort(test3);
		System.out.println();
		for(int i = 0; i < test2.length; i ++){
			System.out.print(test2[i] + "\t");
		}
		System.out.println();
		for(int i = 0; i < test3.length; i ++){
			System.out.print(test3[i] + "\t");
		}
		System.out.println();
		//test sort2
		int[] test4 = {6, 4, 5, 3, 1, 2, 0};
		so.sort2(test4);
		for(int i = 0; i < test4.length; i ++){
			System.out.print(test4[i] + "\t");
		}
		System.out.println();
		//test sort3
		int[] test5 = {1, 2, 3, 4, 5, 6};
		so.sort3(test5);
		for(int i = 0; i < test5.length; i ++){
			System.out.print(test5[i] + "\t");
		}
		System.out.println();
	}
}
