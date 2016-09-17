/**
* <p>Title: HeapSort.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Feb 25, 2016
* @version version 1.0
*/
package csy.sort;

/**
 * <p>Title: HeapSort</p>
 * <p>Description: </p>
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 * Unstable sorting algorithm.
 * @author chenshiyang
 * @date Feb 25, 2016
 * @time 11:05:03 AM
 */
public class HeapSort {
	public void sort(int[] array){
		if(null == array || array.length <= 1){
			return;
		}
		buildMaxHeap(array);
		int size = array.length;
		while(size > 1){
			swap(array, 0, size - 1);
			size --;
			maxHeapify(array, 0, size);
		}
	}
	
	private void buildMaxHeap(int[] array){
		for(int root = array.length / 2 - 1; root >=0; root --){
			maxHeapify(array, root, array.length);
		}
	}
	
	private void maxHeapify(int[] array, int rootIdx, int size){
		int leftIdx = rootIdx * 2 + 1;
		int rightIdx = rootIdx * 2 + 2;
		int largest = rootIdx;
		if(leftIdx < size && array[rootIdx] < array[leftIdx]){
			largest = leftIdx;
		}
		if(rightIdx < size && array[largest] < array[rightIdx]){
			largest = rightIdx;
		}
		if(rootIdx != largest){
			swap(array, rootIdx, largest);
			maxHeapify(array, largest, size);
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
		HeapSort so = new HeapSort();
		int[] array1 = {5, 3, 2, 4, 6, 1};
		so.sort(array1);
		for(int i = 0; i < array1.length; i ++){
			System.out.print(array1[i] + "\t");
		}
	}
}
