package test.wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * Description: netease coding test 3. DP backwards. works.
 */
public class Main34 {
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
			table[M] = 0;
			for(int i = M - 1; i >= N; i --) {
				int cur = 100_000;
				List<Integer> factors = getFactor(i);
				for(int f : factors) {
					if(i + f > M) {
						continue;
					}
					if(table[i + f] == -1) {
						continue;//no solution
					} else {
						cur = Math.min(cur, table[i + f] + 1);
					}
				}
				table[i] = cur;
			}
			min = table[N];
			if(min == 100_000) {
				min = -1;
			}
			System.out.println(min);
		}
		reader.close();
	}
	
	public static List<Integer> getFactor(int i) {
		List<Integer> list = new ArrayList<>();
		for(int j = 2; j * j <= i; j ++) {
			if(i % j == 0) {
				list.add(j);
				list.add(i / j);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Main34.solve();
	}
}

