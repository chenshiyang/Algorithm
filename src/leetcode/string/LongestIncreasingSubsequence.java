package leetcode.string;

/**
 * 严格最长上升子序列
 *
 */
public class LongestIncreasingSubsequence {
    /**
     * 动态规划求最长上升子序列
     *
     * @param array
     * @return
     */
    public int findLongestIncreasingSubsequence(int[] array) {
        if(null == array || array.length == 0) {
            return 0;
        }

        int[] dp = new int[array.length];
        for(int i = 0; i < dp.length; i ++) {
            dp[i] = 1;
        }
        int maxLen = dp[0];//记录最大的长度
        for(int i = 1; i < array.length; i ++) {
            for(int j = 0; j < i; j ++) {
                if(array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public int findLIS2(int[] array) {
        if(null == array || 0 == array.length) {
            return 0;
        }
        int[] ends = new int[array.length];
        int endSize = 0;
        for(int i = 0; i < array.length; i ++) {
            int low = 0;
            int high = endSize;
            while(low < high) {
                int mid = low + (high - low) / 2;
                if(ends[mid] < array[i]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }

            }
            if(high == endSize) {//如果没找到一个大于或等于array[i]的, 则新增一个
                ends[endSize ++] = array[i];
            } else {//否则,长度为high的子序列的最后一个元素的大小可以变得更小, 变成array[i]
                ends[high] = array[i];
            }
        }
        return endSize;
    }



    public static void main(String[] args) {
        LongestIncreasingSubsequence so = new LongestIncreasingSubsequence();
        int[] test1 = null;
        int[] test2 = {};
        int[] test3 = {2};
        int[] test4 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] test5 = {2, 2};
        int[] test6 = {10, 9, 3, 4, 6, 3, 5, 9, 4, 12};
        int[] test7 = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(so.findLongestIncreasingSubsequence(test1));
        System.out.println(so.findLongestIncreasingSubsequence(test2));
        System.out.println(so.findLongestIncreasingSubsequence(test3));
        System.out.println(so.findLongestIncreasingSubsequence(test4));
        System.out.println(so.findLongestIncreasingSubsequence(test5));
        System.out.println(so.findLongestIncreasingSubsequence(test6));
        System.out.println(so.findLongestIncreasingSubsequence(test7));

        System.out.println("Solution 2 ================");

        System.out.println(so.findLIS2(test1));
        System.out.println(so.findLIS2(test2));
        System.out.println(so.findLIS2(test3));
        System.out.println(so.findLIS2(test4));
        System.out.println(so.findLIS2(test5));
        System.out.println(so.findLIS2(test6));
        System.out.println(so.findLIS2(test7));
    }
}
