package test.wap;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 
 * Description: 
 */
public class CreateData {
	public static void main(String[] args) throws Exception {


		int N = 6;
		int M = 2;
		String path = "D:\\testwap" + N + "_" + M + ".txt";
		PrintWriter writer = new PrintWriter(path);
		Random rand = new Random();
		writer.write(N + " " + M + "\n");
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i ++) {
			sb.append(rand.nextInt(10) + 1);
			if(i < N - 1) {
				sb.append(" ");
			}
		}
		sb.append("\n");
		writer.write(sb.toString());
		Set<String> set = new HashSet<String>();
		for(int i = 0; i < N - 1; i ++) {
			int left = rand.nextInt(N) + 1;
			int right = rand.nextInt(N) + 1;
			while(right == left) {
				right = rand.nextInt(N) + 1;
			}
			while(set.contains(left + " " + right) || set.contains(right + " " + left)) {
				left = rand.nextInt(N) + 1;
				right = rand.nextInt(N) + 1;
				while(right == left) {
					right = rand.nextInt(N) + 1;
				}
			}
			set.add(left + " " + right);
			writer.write(left + " " + right + "\n");
		}
		writer.flush();
		writer.close();
	}
}
