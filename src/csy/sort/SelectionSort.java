/**
* <p>Title: SelectionSort.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Feb 23, 2016
* @version version 1.0
*/
package csy.sort;

/**
 * <p>Title: SelectionSort</p>
 * <p>Description: </p>
 * Time complexity: Best: O(n^2), Average: O(n^2), Worst: O(n^2)
 * Space complexity: O(1)
 * Unstable sorting alrogithm.
 * @author chenshiyang
 * @date Feb 23, 2016
 * @time 10:08:54 PM
 */
public class SelectionSort {
	public void selectionSort(int[] array){
		if(null == array || array.length <= 1){
			return;
		}
		for(int i = 0; i < array.length; i ++){
			int minIdx = i;
			for(int j = i + 1; j < array.length; j ++){
				if(array[j] < array[minIdx]){
					minIdx = j;
				}
			}
			swap(array, i, minIdx);
		}
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
		SelectionSort so = new SelectionSort();
		int[] array1 = {5, 3, 2, 4, 6, 1};
		so.selectionSort(array1);
		for(int i = 0; i < array1.length; i ++){
			System.out.print(array1[i] + "\t");
		}
	}
}
