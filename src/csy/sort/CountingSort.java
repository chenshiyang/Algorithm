/**
* <p>Title: CountingSort.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Feb 26, 2016
* @version version 1.0
*/
package csy.sort;

/**
 * <p>Title: CountingSort</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Feb 26, 2016
 * @time 2:53:44 PM
 */
public class CountingSort {
	public void sort(int[] array, int range){
		if(null == array || array.length <= 1){
			return;
		}
		int[] countArray = new int[range + 1];//from 0 to range
		for(int i = 0; i < array.length; i ++){
			countArray[array[i]] ++;
		}
		for(int i = 1; i < countArray.length; i ++){
			countArray[i] += countArray[i - 1];
		}
		int[] sortedArray = new int[array.length];
		for(int i = array.length - 1; i >= 0; i --){
			sortedArray[countArray[array[i]] - 1] = array[i];
			countArray[array[i]] --;
		}
		for(int i = 0; i < array.length; i ++){
			array[i] = sortedArray[i];
		}
	}
	
	public static void main(String[] args){
		CountingSort so = new CountingSort();
		int[] array1 = {5, 3, 2, 4, 6, 1, 8};
		so.sort(array1, 8);
		for(int i = 0; i < array1.length; i ++){
			System.out.print(array1[i] + "\t");
		}
	}
}
