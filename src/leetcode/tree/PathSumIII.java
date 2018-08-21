package leetcode.tree;

/**
 * leetcode PathSum III
 */
class PathSumIII {
    /**
     * 以root为起点,和为sum的路径条数
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if(null == root) {
            return 0;
        }
        return findPath(root, 0, sum) + pathSum(root.left, sum) +
                pathSum(root.right, sum);
    }

    /**
     * 经过root 且当前和为currSum, 计算和为sum的路径条数
     *
     * @param root
     * @param currSum
     * @param sum
     * @return
     */
    private int findPath(TreeNode root, int currSum, int sum) {
        if(null == root) {
            return 0;
        }
        int res = 0;
        currSum += root.val;
        if(currSum == sum) {
            res += 1;
        }
        return res + findPath(root.left, currSum, sum) + findPath(root.right, currSum, sum);
    }

    public static void main(String[] args) {
        PathSumIII so = new PathSumIII();
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node5.right = node9;
        System.out.println(so.pathSum(node1, 8));
        System.out.println(so.pathSum(node1, 21));
        System.out.println(so.pathSum(node1, 3));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
