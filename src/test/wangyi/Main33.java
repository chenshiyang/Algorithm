package test.wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * Description: netease coding test 3. DFS  hard to write.
 */
public class Main33 {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while (reader.hasNext()) {
			String s = reader.nextLine();
			String[] sarry = s.split(" ");
			int N = Integer.parseInt(sarry[0]);
			int M = Integer.parseInt(sarry[1]);
			int[] table = new int[M + 1];
			Arrays.fill(table, -1);
			int min = 100_000;
			Stack<Integer> stack = new Stack<>();
			stack.push(N);
			while(!stack.isEmpty()) {
				int n = stack.peek();
				List<Integer> factors = getFactor(n);
				int cur = 100_000;
				for(int i : factors) {
					int temp = n + i;
					if(n + i > M) {
						break;
					}
					if(table[n + i] != -1) {
						cur = Math.min(cur, table[n + i]);
					}
					stack.push(temp);
				}
			}
//			min = Math.min(min, deal(N, M, table));
			System.out.println(min);
		}
		reader.close();
	}
	
	public static int deal(int N, int M, int[] table) {
		if(N > M) {
			return 100_000;
		}
		if(N == M) {
			return 0;
		}
		if(table[N] != -1) {
			return table[N];
		}
		List<Integer> factors = getFactor(N);
		int min = 100_1000;
		for(int i = 0; i < factors.size(); i ++) {
			if(N + factors.get(i) > M) {
				break;
			}
			if(table[N + factors.get(i)]  != -1) {
				min = Math.min(min, 1 + table[N + factors.get(i)]);
			} else {
				min = Math.min(min, 1 + deal(N + factors.get(i), M, table));
			}
		}
		table[N] = min;
		return min;
	}
	
	public static List<Integer> getFactor(int i) {
		List<Integer> list = new ArrayList<>();
		int end = i / 2;
		for(int j = 2; j <= end; j ++) {
			if(i % j == 0) {
				list.add(j);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Main33.solve();
	}
}

