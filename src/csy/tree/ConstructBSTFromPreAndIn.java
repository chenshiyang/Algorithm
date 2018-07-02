package csy.tree;

/**
 * 从中序遍历和前序遍历构建出一棵二叉树
 *
 */
public class ConstructBSTFromPreAndIn {
    public TreeNode constructTree(int[] pre, int[] in) {
        if(null == pre || null == in || pre.length == 0 || pre.length != in.length) {
            return null;
        }
        TreeNode root = doConstruct(pre, in, 0, pre.length, 0, in.length);
        return root;
    }

    private TreeNode doConstruct(int[] pre, int[] in, int pstart, int pend, int istart, int iend) {
        if(pstart >= pend || istart >= iend) {
            return null;
        }
        System.out.println("pstart pend    " + pstart + "  " + pend);
        TreeNode root = new TreeNode();
        int rootVal = pre[pstart];
        root.key = new Key(rootVal);
        int rootIndex = find(in, istart, iend, rootVal);
        if(-1 == rootIndex) {
            throw new RuntimeException("invalid inorder");
        }
        int leftNodeNum = rootIndex - istart;
        int rightNodeNum = iend - rootIndex;
        root.left = doConstruct(pre, in, pstart + 1, pstart + 1 + leftNodeNum, istart, rootIndex);
        root.right = doConstruct(pre, in, pstart + 1 + leftNodeNum, pend, rootIndex + 1, iend);
        return root;
    }

    private int find(int[] array, int start, int end, int target) {
        for(int i = start; i < end; i ++) {
            if(array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        ConstructBSTFromPreAndIn so = new ConstructBSTFromPreAndIn();
        TreeNode root = so.constructTree(pre, in);
        BinarySearchTree tree = new BinarySearchTree();
        tree.setRoot(root);
        System.out.println(tree.preorderTraversal());
        System.out.println(tree.inorderTraversal());
        System.out.println(tree.postorderTraversal());
    }
}
