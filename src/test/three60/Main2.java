//package test.three60;
//
//import java.util.Scanner;
//
///**
// * 
// * Description: 
// */
//public class Main2 {
//	public static void solve() {
//		Scanner reader = new Scanner(System.in);
//		while(reader.hasNext()) {
////			int n = Integer.parseInt(reader.nextLine());
//			String s = reader.nextLine();
//			int numBit = s.length();
//			int n = Integer.parseInt(s);
//			int[] rememberTable = new int[10];
//			for(int i = 0; i < rememberTable.length; i ++) {
//				rememberTable[i] = (int)Math.pow(2, i);	
//			}
//			int[] table = {1, 11, 111, 1111, 11111, 111111, 1111111, 11111111, 111111111};
//			if(n >= table[numBit - 1]) {
//				int res = 0;
//				for(int i = 0; i < numBit; i ++) {
//					res += rememberTable[i];
//				}
//				System.out.println(res);
//				continue;
//			}
//			else {
//				int len = getLength(n);
//				int res = 0;
//				for(int i = 0; i < len - 1; i ++) {
//					res += rememberTable[i];
//				}
//				
//				n = (int) (n % Math.pow(10, len - 1));
//				if(n == 0) {
//					res += 1;
//				}
//				while(n != 0) {
//					
//				}
//				
//				int res = 0;
//				int len = 0;
//				while(true) {
//					if(n < 10) {
//						res += 1;
//						break;
//					}
//					if(n == 10) {
//						res += 2;
//						break;
//					}
//					len = getLength(n);
//					for(int i = 0; i < len - 1; i ++) {
//						res += rememberTable[i];
//					}
//					n = (int) (n % Math.pow(10, len - 1));
////					if(n >= table[len - 2]);{
////						res += (2 * rememberTable[len - 2]);
////						break;
////					}
//					res += deal(n, rememberTable, table);
//				}
//				System.out.println(res);
//			}		
//		}
//		reader.close();
//	}
//	
//	public static int deal(int n, int[] rememberTable, int[] table) {
//		int len  = 0;
//		int res = 0;
//		if(n < 10) {
//			res += 1;
//			return res;
//		}
//		if(n == 10) {
//			res += 2;
//			return res;
//		}
//		len = getLength(n);
//		for(int i = 0; i < len - 1; i ++) {
//			res += rememberTable[i];
//		}
//		n = (int) (n % Math.pow(10, len - 1));
//		if(n >= table[len - 2]){
//			res += (2 * rememberTable[len - 2]);
//			return res;
//		} else {
//			return deal(n, rememberTable, table);
//		}
//	}
//	
//	public static int getLength(int n) {
//		int len = 0;
//		while(n >= 1) {
//			n /= 10;
//			len ++;
//		}
//		return len;
//	}
//	
//	public static void main(String[] args) {
////		System.out.println(Main2.getLength(110));
//		Main2.solve();
//	}
//}
