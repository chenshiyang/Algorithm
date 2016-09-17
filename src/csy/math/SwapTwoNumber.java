package csy.math;

/**
* <p>Description: Swap two number's value without a temporal value.
*/
public class SwapTwoNumber{
	
	public static void main(String[] args) {
		//use xor operation to swap two number.
		int a = 3, b = 3;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a);
		System.out.println(b);
		//use add and substract to swap two number.
		int c = 5, d = 6;
		c = d - c;
		d = d - c;
		c = c + d;
		System.out.println(c);
		System.out.println(d);
	}
}
