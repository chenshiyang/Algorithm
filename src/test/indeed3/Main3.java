package test.indeed3;

import java.util.Scanner;

/**
 * 
 * Description: Indeed round 3, test 4.
 * Given a number N.
 * Find a number that is i times of N(i = 2, 3, ..., 10), and it is also a permutation of N.
 * 
 * We need to print the counts of these numbers.
 * 
 * Example:
 * 1035
 * 
 * output:
 * 1
 * 
 * Because 3105 = 1035 * 3, and 3105 is a permutation of 1035.
 * 
 * 1234
 * 
 * output:
 * 0
 * 
 * no satisfied permutations.
 */
public class Main3 {

	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			int N = reader.nextInt();
			int count = 0;
			int[] num = getNum(N);
			for(int i = 2; i < 10; i ++) {
				int[] num1 = getNum(N * i);
				if(equal(num, num1)) {
					count ++;
				}
			}
			System.out.println(count);
		}
		reader.close();
	}
	
	public static boolean equal(int[] num1, int[] num2) {
		for(int i = 0; i < num1.length; i++) {
			if(num1[i] != num2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static int[] getNum(int n) {
		int[] num = new int[10];
		int m;
		while(n != 0) {
			m = n % 10;
			n /= 10;
			num[m]++;
		}	
		return num;
	}
	
	public static void main(String[] args) {
		Main3.solve();
	}
}
