package csy.dp;

/**
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] array = new int[n + 1];
        array[0] = 1;
        for(int i = 1; i < array.length; ++ i) {
            for(int j = 0; j < i; ++ j) {
                array[i] += (array[j] * array[i - 1 - j]);
            }
        }
        return array[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees so = new UniqueBinarySearchTrees();
        System.out.println(so.numTrees(1));
        System.out.println(so.numTrees(2));
        System.out.println(so.numTrees(3));
        System.out.println(so.numTrees(4));
    }
}
