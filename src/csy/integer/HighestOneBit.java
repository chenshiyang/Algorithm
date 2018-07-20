package csy.integer;

public class HighestOneBit {
    /**
     * 获取不大于i的最大的2的完全平方数
     *
     * 这个方法取自JDK Integer.highestOneBit
     *
     * @param i
     * @return
     */
    public int highestOneBit(int i) {
        i |= (i >> 1);
        System.out.println(i);
        i |= (i >> 2);
        System.out.println(i);
        i |= (i >> 4);
        System.out.println(i);
        i |= (i >> 8);
        System.out.println(i);
        i |= (i >> 16);
        System.out.println(i);
        return i - (i >>> 1);
    }

    public static void main(String[] args) {
        HighestOneBit so = new HighestOneBit();
        System.out.println(so.highestOneBit(7));
        System.out.println(so.highestOneBit(8));
        System.out.println(so.highestOneBit(129));
        System.out.println(so.highestOneBit(1024));
    }
}
