package csy.search;

/**
 * 从有序数组里找到第一个不小于target的数, 返回其下标
 *
 */
public class BinarySearchForFirstNoLessThanTarget {

    public int search(int[] array, int target) {
        if(null == array || array.length == 0) {
            return -1;
        }
        int low = 0;
        int high = array.length;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if(high == array.length) {//说明target大于数组的最大值, 找不到一个不小于target的数
            return -1;
        } else {
            return high;
        }
    }

    public int search2(int[] array, int target) {
        if(null == array || array.length == 0) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if(high == array.length - 1) {
            return -1;
        } else {
            return high + 1;
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7};
        BinarySearchForFirstNoLessThanTarget so = new BinarySearchForFirstNoLessThanTarget();
        System.out.println(so.search(array, -1));
        System.out.println(so.search(array, 0));
        System.out.println(so.search(array, 4));
        System.out.println(so.search(array, 7));
        System.out.println(so.search(array, 8));

        System.out.println(so.search2(array, -1));
        System.out.println(so.search2(array, 0));
        System.out.println(so.search2(array, 4));
        System.out.println(so.search2(array, 7));
        System.out.println(so.search2(array, 8));
    }
}
