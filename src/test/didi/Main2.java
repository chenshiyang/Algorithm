package test.didi;

import java.util.Scanner;

/**
 * Didi coding test 2. longest common substring.
 * 
 * @author csy
 *
 */
public class Main2 {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while (reader.hasNext()) {
			int n = Integer.parseInt(reader.nextLine());
			int[] A = new int[n];
			String s = reader.nextLine();
			String[] sarry = s.split(" ");
			for (int i = 0; i < n; i++) {
				A[i] = Integer.parseInt(sarry[i]);
			}

			// dp
			int nEnd = A[0];
			int nAll = A[0];
			for (int i = 1; i < n; i++) {
				nEnd = Math.max(A[i], nEnd + A[i]);
				nAll = Math.max(nEnd, nAll);
			}
			System.out.println(nAll);
		}
		reader.close();
	}

	public static void main(String[] args) {
		Main2.solve();
	}
}
