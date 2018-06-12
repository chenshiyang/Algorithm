package csy.sort;

/**
 * 归并排序 inplace 版
 */
public class MergeSort2 {
    public void sort(int[] array) {
        sortHelper(array, 0, array.length);
    }

    private void sortHelper(int[] array, int start, int end) {
        if(null == array || end - start <= 1) {
            return;
        }
        int leftLength = start + (end - start) / 2;
        sortHelper(array, start, leftLength);
        sortHelper(array, leftLength, end);
        merge(array, start, leftLength, leftLength, end);
    }

    private void merge(int[] array, int ls, int le, int rs, int re) {
        int[] tarry = new int[re - ls];
        int i = ls, j = rs, k = 0;
        while(i < le || j < re) {
            if(i >= le) {
                tarry[k ++] = array[j ++];
            } else if(j >= re) {
                tarry[k ++] = array[i ++];
            } else {
                tarry[k ++] = array[i] > array[j] ? array[j ++] : array[i ++];
            }
        }
        for(int _ = 0; _ < tarry.length; _ ++) {
            array[ls + _] = tarry[_];
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 2, 4, 6, 1};
        MergeSort2 so = new MergeSort2();
        so.sort(array);
        for (int i : array) {
            System.out.println(i);
        }
        int[] array2 = {6, 4, 7, 2, 9, 1, 0};
        so.sort(array2);
        for (int i : array2) {
            System.out.print(i + "\t");
        }
    }
}
