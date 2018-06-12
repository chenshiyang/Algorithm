package csy.array;

/**
 * 寻找总和为给定值的区间
 * 数组里的元素都是非负数
 * 使用两个指针来寻找
 *
 */
public class FindTargetSection {
    public void findSection(int[] array, int target) {
        if(null == array || array.length == 0) {
            return;
        }
        int sum = 0;
        for(int i = 0, j = -1; i < array.length && j < array.length; ) {
            if(sum < target) {
                if(j + 1 < array.length) {
                    j ++;
                    sum += array[j];
                } else {
                    break;
                }
            } else if(sum > target) {
                sum -= array[i];
                i ++;
            } else {
                for(int k = i ; k <= j; k ++) {
                    System.out.print(array[k] + "+" );
                }
                System.out.println("=" + target);
                sum -= array[i];
                i ++;
            }
        }
    }

    public static void main(String[] args) {
        FindTargetSection so = new FindTargetSection();
        int[] array = {3, 6, 1, 7, 2};
        so.findSection(array, 10);
    }
}
