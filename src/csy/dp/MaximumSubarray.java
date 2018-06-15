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

	/**
	 * leetcode 58题
	 * 给定一个数组,找到和最大的子数组,至少包含一个元素
	 *
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		if(null == nums || nums.length < 1) {
			return 0;
		}
		//记录当前最大的子数组的和
        int maxSum = nums[0];
		int sumEndWithCurrentElement = nums[0];
		for(int i = 1; i < nums.length; i ++) {
			//以nums[i]结尾的子数组的和
			if(sumEndWithCurrentElement > 0) {//这里是以nums[i-1]结尾的子数组
				sumEndWithCurrentElement += nums[i];//这里是以nums[i]结尾的子数组
			} else {
			    sumEndWithCurrentElement = nums[i];
            }
            maxSum = Math.max(maxSum, sumEndWithCurrentElement);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		MaximumSubarray so = new MaximumSubarray();
		int[] test1 = {1, -2, 3, 5, -3, 2};//8
		int[] test2 = {0, -2, 3, 5, -1, 2};//9
		int[] test3 = {-9, -2, -3, -5, -3};//-2
		
		System.out.println(so.solve(test1) == 8);
		System.out.println(so.solve(test2) == 9);
		System.out.println(so.solve(test3) == -2);

		System.out.println(so.maxSubArray(test1));
		System.out.println(so.maxSubArray(test2));
		System.out.println(so.maxSubArray(test3));
	}
}
