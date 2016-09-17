/**
* <p>Title: QuickSort.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Feb 24, 2016
* @version version 1.0
*/
package csy.sort;

/**
 * <p>Title: QuickSort</p>
 * <p>Description: </p>
 * Time complexity: Best: O(nlogn), Average: O(nlogn), Worst: O(n^2)
 * Space complexity: Best: O(logn), Worst: O(n).
 * Unstable sorting algorithm.
 * @author chenshiyang
 * @date Feb 24, 2016
 * @time 9:38:21 PM
 */
public class QuickSort {
	public void sort(int[] array){
		if(null == array || array.length <= 1){
			return;
		}
		partition(array, 0, array.length - 1);
	}
	
	private void partition(int[] array, int left, int right){
		if(right - left < 1){
			return;
		}
		int pivot = getPivot(array, left, right);//the pivot is stored in array[left]
		int pivotIdx = left;
		int i = left + 1;
		for(int j = i; j <= right; j ++){
			if(array[j] < pivot){
				swap(array, i, j);
				i ++;
			}
		}
		swap(array, pivotIdx, i - 1);//array[i - 1] is the last one that small than pivot.
		partition(array, left, i - 2);
		partition(array, i, right);
	}
	
	private int getPivot(int[] array, int left, int right){
		return array[left];
	}
	
	private void swap(int[] array, int i, int j){
		if(i == j){
			return;
		}
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args){
		QuickSort so = new QuickSort();
		int[] array1 = {5, 3, 2, 4, 6, 1};
		so.sort(array1);
		for(int i = 0; i < array1.length; i ++){
			System.out.print(array1[i] + "\t");
		}
	}
}
