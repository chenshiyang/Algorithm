package csy.search;

public class BinarySearchWithRotation {
    /**
     * 这个方法的思路是判断mid left right 与target的大小关系 来确定target可能在哪个区间
     * 这种解法有问题
     *
     * @param array
     * @param target
     * @return
     */
    public int search(int[] array, int target) {
        if(null == array || array.length == 0) {
            return -1;
        }
        int l = 0;
        int r = array.length - 1;
        // i.e. array = [5,6,7,1,2,3,4]
        while(l <= r) {
            int mid = l + (r - l) / 2;//mid=3
            if(array[mid] < target) {
                if(array[l] < target) {// 假设target=7
                    r = mid - 1;//=====这里有问题
                } else if(array[l] > target) {// 假设找的是3
                    l = mid + 1;
                } else {
                    return l;// array[l] ==target
                }
            } else if(array[mid] > target) {
                if(array[r] < target) {
                    r = mid - 1;
                } else if(array[r] > target) {
                    r = mid - 1;
                } else {
                    return r;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 该方法的思路是先判断哪个区间是有序的, 然后通过判断target是否在有序
     * 的那个区间内来选择接下来要继续迭代哪个区间
     *
     *
     * @param array
     * @param target
     * @return
     */
    public int search2(int[] array, int target) {
        if(null == array || array.length == 0) {
            return -1;
        }
        int l = 0;
        int r = array.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(target == array[mid]) {
                return mid;
            }
            if(isSorted(array, l, mid)) {//如果左半区间是有序的
                if(target < array[mid] && target >= array[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {//否则右半区间是有序的
                if(target > array[mid] && target <= array[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    private boolean isSorted(int[] array, int start, int end) {
        return array[start] < array[end];
    }

    public static void main(String[] args) {
        int[] array1 = {5, 6, 7, 1, 2, 3, 4};
        BinarySearchWithRotation so = new BinarySearchWithRotation();
        System.out.println(so.search(array1, 1));
        System.out.println(so.search(array1, 6));
        System.out.println(so.search(array1, 3));
        System.out.println(so.search(array1, 0));
        int[] array2 = {3, 4, 5, 6, 7, 1, 2};
        System.out.println(so.search(array2, 7));// 方法1的反例

        System.out.println("Solution 2============");

        System.out.println(so.search2(array1, 1));
        System.out.println(so.search2(array1, 6));
        System.out.println(so.search2(array1, 3));
        System.out.println(so.search2(array1, 0));
        System.out.println(so.search2(array2, 7));// 方法1的反例
    }
}
