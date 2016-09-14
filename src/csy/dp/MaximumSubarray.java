package csy.dp;

public class MaximumSubarray {
	public int solve(int[] A) {
		if(null == A || A.length < 1) {
			return 0;
		}
		
		int nEnd = A[0];
		int nAll = A[0];
		int start = 0;
		int end = 0;
		int maxStart = 0;
		int maxEnd = 0;
		for(int i = 1; i < A.length; i ++) {
//			nEnd = Math.max(A[i], A[i] + nEnd);
			if(A[i] >= A[i] + nEnd) {
				nEnd = A[i];
				start = i;
				end = i;
			} else {
				nEnd = A[i] + nEnd;
				end = i;
			}
//			nAll = Math.max(nEnd, nAll);
			if(nEnd > nAll) {
				nAll = nEnd;
				maxStart = start;
				maxEnd = end;
			}
		}
		System.out.println("start is " + maxStart + " , end is " + maxEnd);
		return nAll;
	}
	
	public static void main(String[] args) {
		MaximumSubarray so = new MaximumSubarray();
		int[] test1 = {1, -2, 3, 5, -3, 2};//8
		int[] test2 = {0, -2, 3, 5, -1, 2};//9
		int[] test3 = {-9, -2, -3, -5, -3};//-2
		
		System.out.println(so.solve(test1) == 8);
		System.out.println(so.solve(test2) == 9);
		System.out.println(so.solve(test3) == -2);
	}
}
