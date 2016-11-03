package test.indeed3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * Description: Solution of indeed round 3, test 2. Not elegant.
 */

public class Main5 {

	static PriorityQueue<String> min = new PriorityQueue<>();

	static String S;

	static int K;

	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while (reader.hasNext()) {
			S = reader.nextLine();
			K = reader.nextInt();

			char[] chars = S.toCharArray();

			Set<String> set = new HashSet<>();
			for (char c : chars)
				set.add(String.valueOf(c));

			List<String> remains = new ArrayList<>(set);

			List<String> current = new ArrayList<>();
			backtrack(current, remains);
			System.out.println(min.poll());
		}
		reader.close();
	}

	public static void backtrack(List<String> cur, List<String> remains) {
		if (remains.size() == 0) {
			return;
		}
		for (int i = 0; i < remains.size(); i++) {
			String c = remains.get(i);

			List<String> newCur = new ArrayList<>(cur);
			newCur.add(c);

			List<String> newRemain = new ArrayList<>(remains.subList(i + 1,
					remains.size()));

			StringBuffer s = new StringBuffer();
			for (char cs : S.toCharArray()) {
				if (newCur.contains(cs + "")) {
					s.append(cs + "");
				}
			}

			if (s.length() >= K) {
				min.add(s.toString());
			}
			backtrack(newCur, newRemain);
		}
	}

	public static void main(String[] args) {
		Main5.solve();
	}
}
