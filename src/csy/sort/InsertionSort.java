/**
* <p>Title: InsertionSort.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Feb 24, 2016
* @version version 1.0
*/
package csy.sort;

/**
 * <p>Title: InsertionSort</p>
 * <p>Description: </p>
 * Time complexity: Best: O(n), Average: O(n^2), Worst: O(n^2)
 * Space complexity: O(1)
 * Stable sorting algorithm.
 * @author chenshiyang
 * @date Feb 24, 2016
 * @time 5:38:37 PM
 */
public class InsertionSort {
	public void sort(int[] array){
		if(null == array || array.length <= 1){
			return;
		}
		
		for(int i = 1; i < array.length; i ++){
			int key = array[i];
			int j = i - 1;
			while(j >= 0 && array[j] > key){
				array[j + 1] = array[j];
				j --;
			}
			if(j != i - 1){
				array[j + 1] = key;
			}
		}
	}
	
	public static void main(String[] args){
		InsertionSort so = new InsertionSort();
		int[] array1 = {5, 3, 2, 4, 6, 1};
		so.sort(array1);
		for(int i = 0; i < array1.length; i ++){
			System.out.print(array1[i] + "\t");
		}
	}
}
