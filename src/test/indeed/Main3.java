package test.indeed;

import java.util.Scanner;

/**
 * 
 * Description:
 */
public class Main3 {
	static int K;
	static int diff = Integer.MAX_VALUE;

	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while (reader.hasNext()) {
			int N = reader.nextInt();
			K = reader.nextInt();
			int[] array = new int[N];
			for (int i = 0; i < array.length; i++) {
				array[i] = reader.nextInt();
			}
			getPermutation(array, 0, array.length - 1);
			System.out.println(diff);
		}
		reader.close();
	}

	private static void getPermutation(int[] array, int begin, int end) {
		if (begin == end) {
			char[] operator = new char[array.length - 1];
			for (int i = 0; i < operator.length; i++) {
				operator[i] = '+';
			}
			computeResult(array, operator, 0);
		} else {
			for (int i = begin; i <= end; i++) {
				swap(array, begin, i);
				getPermutation(array, begin + 1, end);
				swap(array, i, begin);
			}
		}
	}

	private static void computeResult(int[] array, char[] operator, int index) {
		if(diff == 0) {//return early
			return;
		}
		if (index == operator.length) {
			int res = array[0];
			for (int i = 0; i < operator.length; i++) {
				if (operator[i] == '+') {
					res += array[i + 1];
				} else {
					res *= array[i + 1];
				}
			}
//			System.out.println(res);
			diff = Math.min(diff, Math.abs(res - K));
		} else {
			operator[index] = '+';
			computeResult(array, operator, index + 1);
			operator[index] = '*';
			computeResult(array, operator, index + 1);
		}
	}

	private static void swap(int[] array, int i, int j) {
		if (i == j) {
			return;
		}
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void main(String[] args) {
		Main3.solve();
	}
}
