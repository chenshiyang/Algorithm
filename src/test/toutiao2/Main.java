package test.toutiao2;

/**
 * 
 * Description: 
 */
import java.util.Scanner;

/**
 * 
 * Description: 
 */
public class Main {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			long n = reader.nextLong();
			long m = reader.nextLong();
			long highest = getHighestNumber(n);
			long num = getNum(n);
			
			int region = 1;
			int numPerRegion = 0;
			for(int i = 1; i < num; i ++) {
				numPerRegion = numPerRegion * 10 + 1;
			}
			int[] regions = new int[9];
			for(int i = 0; i < regions.length; i ++) {
				regions[i] = numPerRegion;
			}
			//one region has extra numbers.
			long extra = n - (long)Math.pow(10, num - 1) + 1;
			regions[(int) (highest - 1)] += extra;
//			System.out.println(numPerRegion);
//			System.out.println(regions[0]);
			
			//find m locates in which region
			long total = 0;
			int regionNum = 1;
			for(int i = 0; i < regions.length; i ++) {
				if(total + regions[i] < m) {
					total += regions[i];
					regionNum ++;
				} else {
					break;
				}
			}
//			System.out.println(regionNum);
			for(int i = 0; i < regionNum - 1; i ++) {
			m -= regions[i];
		}
			for(int i = 1; i <= n; i ++) {
				if(getHighestNumber(i) == regionNum) {
					m --;
					if(m == 0) {
						System.out.println(i);
						break;
					}
				}
			}
//			for(int i = 0; i < regionNum - 1; i ++) {
//				m -= regions[i];
//			}
//			System.out.println(m);
//			
//			long[] array = new long[(int) num];
//			array[0] = 1;
//			for(int i = 1; i < array.length; i ++) {
//				array[i] = array[i - 1] * 10 + 1;
//			}
//			if(num == 1) {
//				System.out.println("hello");
//				array[(int) (num - 1)] = n - (long)Math.pow(10, num - 1) + 1;
//			} else {
//				array[(int)(num - 1)] = array[(int)(num - 2)] + n - (long)Math.pow(10, num - 1) + 1;
//			}
////			for(long i : array) {
////				System.out.println(i);
////			}
//			for(int i = 0; i < array.length; i ++) {
//				if(m < array[i]) {
//					
//				} else {
//					continue;
//				}
//			}
		}
		reader.close();
	}
	
	public static long getHighestNumber(long x) {
		while(x >= 10) {
			x /= 10;
		}
		return x;
	}
	
	public static long getNum(long x) {
		int count = 0;
		while(x > 0) {
			x /= 10;
			++ count;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Main.solve();
	}
}