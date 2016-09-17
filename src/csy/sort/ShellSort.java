/**
* <p>Title: ShellSort.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Feb 25, 2016
* @version version 1.0
*/
package csy.sort;

/**
 * <p>Title: ShellSort</p>
 * <p>Description: </p>
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 * Unstable sorting algorithm.
 * @author chenshiyang
 * @date Feb 25, 2016
 * @time 3:08:52 PM
 */
public class ShellSort {
	public void sort(int[] array){
		if(null == array || array.length <= 1){
			return;
		}
		int step = array.length / 2;
		while(step >= 1){
			int startRange = array.length / step;
			for(int i = 0; i <= startRange; i ++){
				insertionSort(array, i, step);
			}
			step --;
/*			System.out.println("step length is " + (step + 1));
			for(int i = 0; i < array.length; i ++){
				System.out.print(array[i] + "\t");
			}
			System.out.println();*/
		}
	}
	
	private void insertionSort(int[] array, int start, int step){
		for(int i = start + step; i < array.length; i += step){
			int key = array[i];
			int j = i - step;
			while(j >= start && array[j] > key){
				array[j + step] = array[j];
				j -= step;
			}
			if(j + step != i ){
				array[j + step] = key;
			}
		}
	}
	
	public static void main(String[] args){
		ShellSort so = new ShellSort();
		int[] array1 = {5, 3, 2, 4, 6, 1, 8};
		so.sort(array1);
		for(int i = 0; i < array1.length; i ++){
			System.out.print(array1[i] + "\t");
		}
	}
}
