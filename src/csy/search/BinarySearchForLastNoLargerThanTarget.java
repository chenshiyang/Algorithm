package csy.search;

/**
 * 从有序数组里醉倒最后一个不大于target的元素
 *
 */
public class BinarySearchForLastNoLargerThanTarget {
    public int search(int[] array, int target) {
        if(null == array || array.length == 0) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if(low == 0) {
            return -1;
        } else {
            return low - 1;
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7};
        BinarySearchForLastNoLargerThanTarget so = new BinarySearchForLastNoLargerThanTarget();
        System.out.println(so.search(array, -1));
        System.out.println(so.search(array, 0));
        System.out.println(so.search(array, 1));
        System.out.println(so.search(array, 2));
        System.out.println(so.search(array, 3));
        System.out.println(so.search(array, 4));
        System.out.println(so.search(array, 5));
        System.out.println(so.search(array, 6));
        System.out.println(so.search(array, 7));
        System.out.println(so.search(array, 8));

    }
}
