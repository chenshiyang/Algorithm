package csy.search;

/**
 * 给定一个无序数组,找出这个数组排序后的第K个元素(即第K小元素)
 *
 */
public class FindKthElement {
    public int findKthElement(int[] array, int K) {
        if(null == array || array.length < K + 1 || K < 0) {
            throw new RuntimeException("illegal argument");
        }
        int start = 0;
        int end = array.length - 1;
        int pivotIndex = partition(array, start, end);
        while(pivotIndex != K) {
            if(pivotIndex < K) {
                start = pivotIndex + 1;
                pivotIndex = partition(array, start, end);
            } else {
                end = pivotIndex - 1;
                pivotIndex = partition(array, start, end);
            }
        }
        return array[pivotIndex];
    }

    private int partition(int[] array, int start, int end) {
        int pivotIndex = getPivotIndex(array, start, end);
        int pivot = array[pivotIndex];
        int i = start + 1;
        for(int j = start + 1; j <= end; j ++) {
            if(array[j] < pivot) {
                swap(array, i, j);
                i += 1;
            }
        }
        swap(array, pivotIndex, i - 1);
        return i - 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int getPivotIndex(int[] array, int start, int end) {
        return start;
    }

    public void findMedian(int[] array) {
        int len = array.length;
        if(0 != len % 2) {
            System.out.println("median is " + findKthElement(array, len / 2));
        } else {
            int median1 = findKthElement(array, len / 2 - 1);
            int median2 = findKthElement(array, len / 2);

            System.out.println("median is " + (median1 + median2) / 2.0);
        }
    }

    public static void main(String[] args) {
        int[] test1 = {4, 5, 2, 1, 6, 3, 0};
        FindKthElement so = new FindKthElement();
        System.out.println(so.findKthElement(test1, 2));
        for(int i = 0; i < test1.length; i ++) {
            System.out.println(so.findKthElement(test1, i));
        }
        // 特别应用 找中位数
        so.findMedian(test1);
        int[] test2 = {4, 5, 2, 1, 6, 3};
        so.findMedian(test2);
    }
}
