package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    /**
     * 递归DFS方法
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(null == root) {
            return result;
        }
        List<Integer> solution = new ArrayList<>();
        doPathSum(root, result, sum, solution);
        return result;
    }

    private void doPathSum(TreeNode root, List<List<Integer>> result, int sum, List<Integer> solution) {
        solution.add(root.val);
        if(root.left == null && root.right == null && root.val == sum) {
            List<Integer>  so = new ArrayList<>();
            so.addAll(solution);
            result.add(so);
            solution.remove(solution.size() - 1);
            return;
        }

        if(null != root.left) {
            doPathSum(root.left, result, sum - root.val, solution);
        }
        if(null != root.right) {
            doPathSum(root.right, result, sum - root.val, solution);
        }
        solution.remove(solution.size() - 1);
    }

    /**
     * 迭代方法
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {

    }

    public static void main(String[] args) {
        PathSumII so = new PathSumII();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.left = node9;
        node6.right = node10;

        System.out.println(so.pathSum(node1, 22));
    }
}
