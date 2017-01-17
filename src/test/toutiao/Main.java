package test.toutiao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * Description: n个数里面任一两个数的异或值 >= m 的个数
 */
public class Main {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			int n = reader.nextInt();
			int m = reader.nextInt();
			Set<Integer> set = new HashSet<>();
			for(int i = 0; i < n; i ++) {
				set.add(reader.nextInt());
			}
			int count = 0;
			Iterator<Integer> iterator = set.iterator();
			while(iterator.hasNext()) {
				int a = iterator.next();
				int cap = getCap(m);
				for(int i = m; i <= cap; i ++) {
					if(set.contains(i ^ a)) {
						count ++;
					}
				}
			}
			System.out.println(count / 2);
		}
		reader.close();
	}
	
	public static int getCap(int n) {
		int i = 1;
		while(i < n) {
			i *= 2;
		}
		return i - 1;
	}
	
	public static void main(String[] args) {
		Main.solve();
	}
}
