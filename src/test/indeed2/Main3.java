package test.indeed2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * Description: 
 */
public class Main3 {
	static int[] array;
	static int[][] ways;
	static long max = Integer.MIN_VALUE;
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			int N = reader.nextInt();
			int M = reader.nextInt();
			array = new int[N + 1];
			ways = new int[M][2];
			for(int i = 1; i < N + 1; i ++) {
				array[i] = reader.nextInt();
			}
			for(int i = 0; i < M; i ++) {
				ways[i][0] = reader.nextInt();
				ways[i][1] = reader.nextInt();
			}
			
			for(int i = 0; i <= M; i ++) {
				boolean[] used = new boolean[M];
				List<Integer> select = new ArrayList<>();
				deal(used, select, i);
			}
			System.out.println(max);
		}
		reader.close();
	}
	
	static void deal(boolean[] used, List<Integer> select, int k) {
		if(select.size() == k) {
			swapAndCompute(select);
		} else {
			for(int i = 0; i < used.length; i ++) {
				if(!used[i]) {
					used[i] = true;
					select.add(i);
					deal(used, select, k);
					used[i] = false;
					int index = select.size() - 1;
					select.remove(index);
				}
			}
		}
		
	}
	
	static void swapAndCompute(List<Integer> used) {
		for(Integer i : used) {
//			System.out.print(i + " ");
			int left = ways[i][0];
			int right = ways[i][1];
			while(left < right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left ++;
				right --;
			}
		}
//		System.out.println();
//		for(int i = 1; i < array.length; i ++) {
//			System.out.print(array[i] + "  ");
//		}
//		System.out.println();
		//compute
		long sum = 0;
		for(int i = 1; i < array.length; i ++) {
			sum += array[i] * i;
		}
		max = Math.max(sum, max);
		
		//recover
		for( int i = used.size() - 1; i >= 0; i --) {
			int m = used.get(i);
//			System.out.print(i + " ");
			int left = ways[m][0];
			int right = ways[m][1];
			while(left < right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left ++;
				right --;
			}
		}
	}
	
	public static void main(String[] args) {
		Main3.solve();
	}
}
