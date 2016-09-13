package test.wangyi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * Description: netease coding test 3. BFS works.
 */
public class Main32 {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while (reader.hasNext()) {
			String s = reader.nextLine();
			String[] sarry = s.split(" ");
			int N = Integer.parseInt(sarry[0]);
			int M = Integer.parseInt(sarry[1]);
			if(N == M) {
				System.out.println(0);
				continue;
			}
			int[] table = new int[M + 1];
//			Arrays.fill(table, -1);
			int min = 100_000;
			Queue<Integer> queue = new LinkedList<>();
			queue.add(N);
			int sketch = 0;
			int sons = 1;
			boolean find = false;
			while(!queue.isEmpty()) {
				if(find) {
					break;
				}
				int num = 0;//num of nodes in this layer.
				while(sons -- > 0) {
					int n = queue.poll();
					List<Integer> factors = getFactor(n);
					for(Integer i : factors) {
						if(n + i > M) {//more than need.
							continue;
						}
						if(table[n + i] == -2) {//appears before.
							continue;
						}
						if(n + i == M) {
							min = Math.min(min, sketch + 1);
							find = true;
							break;
						} else {
							queue.add(n + i);
							table[n + i] = -2;
							num ++;
						}
					}
				}
				sons = num;
				sketch += 1;
			}
			if(min == 100_000) {
				System.out.println(-1);
			} else {
				System.out.println(min);
			}
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
		Main32.solve();
	}
}