package test.wangyi;

import java.util.Scanner;

/**
 * 
 * Description: netease coding test 2.
 */
public class Main2 {
	public static void solve() {
		Scanner reader = new Scanner(System.in);		
		while(reader.hasNext()) {
			long N = Integer.parseInt(reader.nextLine());
			long count = 0;
			count = deal(N);
			System.out.println(count);
		}
		reader.close();
	}

	public static long deal(long N) {
		if(N == 1) {
			return 1L;
		}
		if(N % 2 != 0) {
			long part = (1 + N) * (N + 1) / 4;
			return part + deal((N - 1) / 2);
		} else {
			long part = N * N / 4;
			return part + deal(N / 2);
		}
	}
	
   public static void main(String[] args) {
	  Main2.solve();
  }
}
