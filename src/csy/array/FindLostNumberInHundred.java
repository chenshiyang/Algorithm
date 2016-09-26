package csy.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * Description: Given a array of length 98, containing number from 1 to 100. Find the lost two 
 * numbers that don't appear in this array.
 */
public class FindLostNumberInHundred {
	/**
	* Description: Solution 1: change this problem to : find two numbers that appear only once in a array, the rest
	* 98 numbers both appear 2 times.
	* 
	* We need to add 1, 2, ..., 100 to change the problem.
	* @param array
	*/
	public void findNumbers(int[] array) {
		if(null == array) {
			return;
		}
		
		int res = 0;//xor result of all the number;
		for(int i = 1; i < 101; i ++) {
			res ^= i;
		}

		for(int i = 0; i < array.length; i ++) {
			res ^= array[i];
		}
		
		//represent res as a binary number. the bit that equals to 1 shows that the 
		//two lost number is different in this bit.
		int index = findBitEqualToOne(res);
		int num1 = 0, num2 = 0;
		for(int i = 1; i < 101; i ++) {
			if(((i >> index) & 1) == 1) {
				num1 ^= i;
			} else {
				num2 ^= i;
			}
		}
		for(int i = 0; i < array.length; i ++) {
			if((array[i] >> index & 1) == 1) {
				num1 ^= array[i];
			} else {
				num2 ^= array[i];
			}
		}
		System.out.println(num1);
		System.out.println(num2);
	}
	
	private int findBitEqualToOne(int num) {
		int index = 0;
		while((num & 1) == 0 && index < 32) {
			num >>= 1;
			index ++;
		}
		return index;
	} 
	
	/**
	* Description: Solution 2: Use equation: a + b = 5050-sum, a^2 + b^2 = sum2
	* and solve these two equation.
	* @param array
	*/
	public void findNumbers2(int[] array) {
		if(null == array) {
			return;
		}
		
		int sum1 = 5050, sum2 = 0;
		for(int i = 1; i < 101; i ++) {
			sum2 += i * i;
		}
		for(int i = 0; i < array.length; i ++) {
			sum1 -= array[i];
			sum2 -= array[i] * array[i];
		}
		int num1 = 0, num2 = 0;
		//solve the equation, then will get these two answer.
		num1 = (int) ((sum1 + Math.sqrt(2 * sum2 - sum1 * sum1)) / 2);
		num2 = (int) ((sum1 - Math.sqrt(2 * sum2 - sum1 * sum1)) / 2);
		System.out.println(num1);
		System.out.println(num2);
	}
	
	public static void main(String[] args) {
		FindLostNumberInHundred so = new FindLostNumberInHundred();
		//create test data.
		Random rand = new Random();
		int num1 = rand.nextInt(100) + 1;
		int num2 = rand.nextInt(100) + 1;
		System.out.println(num1);
		System.out.println(num2);
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i < 101; i ++) {
			if(i != num1 && i != num2) {
				list.add(i);
			}
		}
		int[] array = new int[98];
		for(int i = 0; i < array.length; i ++) {
			array[i] = list.get(i);
		}

		so.findNumbers(array);
		so.findNumbers2(array);
	}
}
