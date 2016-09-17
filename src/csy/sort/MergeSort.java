/**
* <p>Title: MergeSort.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Feb 24, 2016
* @version version 1.0
*/
package csy.sort;

/**
 * <p>Title: MergeSort</p>
 * <p>Description: </p>
 * Time complexity: Best: O(nlogn), Average: O(nlogn), Worst: O(nlogn)
 * Space complexity: O(n)
 * Stable algorithm.
 * @author chenshiyang
 * @date Feb 24, 2016
 * @time 8:29:35 PM
 */
public class MergeSort {
	public void sort(int[] array){
		if(null == array || array.length <= 1){
			return;
		}
		int[] left = new int[array.length / 2];
		int[] right = new int[array.length - left.length];
		for(int i = 0; i < left.length; i ++){
			left[i] = array[i];
		}
		for(int i = 0; i < right.length; i ++){
			right[i] = array[i + left.length];
		}
		sort(left);
		sort(right);
		merge(array, left, right);
	}
	
	private void merge(int[] array, int[] left, int[] right){
		int i = 0, j = 0, k = 0;
		while(i < left.length || j < right.length){
			if(i >= left.length){
				array[k ++] = right[j ++];
			}
			else if(j >= right.length){
				array[k ++] = left[i ++];
			}
			else{
				array[k ++] = left[i] <= right[j] ? left[i ++] : right[j ++];
			}
		}
	}
	
	public static void main(String[] args){
		MergeSort so = new MergeSort();
		int[] array1 = {5, 3, 2, 4, 6, 1};
		so.sort(array1);
		for(int i = 0; i < array1.length; i ++){
			System.out.print(array1[i] + "\t");
		}
	}
}
