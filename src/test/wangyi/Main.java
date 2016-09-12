package test.wangyi;

import java.util.Scanner;

/**
 * 
 * Description: netease coding test 1.
 */
public class Main {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		
		while(reader.hasNext()) {
			int R2 = Integer.parseInt(reader.nextLine());
			int res = 0;//top bottom left right
			int half = R2 / 2;
			if(isSquare(R2)) {
				res += 4;
			}
			for(int i = 1; i * i <= half; i ++ ) {
				if(isSquare(R2 - i * i)) {
					if(i * i == half) {
						res -= 4;
					}
					res += 8;
				}
			}
			System.out.println(res);
		}
		reader.close();
	}
	
	public static boolean isSquare(int n) {
		double m = Math.sqrt(n);
		int a = (int)m;
		if(a * a == n) {
			return true;
		}
		else {
			return false;
		}
	}
	
  public static void main(String[] args) {
	  Main.solve();
  }
}
