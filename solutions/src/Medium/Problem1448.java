package Medium;

import Util.TreeNode;

public class Problem1448 {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }

    private int countGoodNodes(TreeNode root, int max) {
        if (root == null)
            return 0;
        int newMax = Math.max(root.val, max);
        return (root.val == newMax ? 1 : 0) + countGoodNodes(root.left, newMax) + countGoodNodes(root.right, newMax);
    }

    public static void main(String[] args) {
        Problem1448 problem1448 = new Problem1448();
        TreeNode ll = new TreeNode(3);
        TreeNode l = new TreeNode(1, ll, null);
        TreeNode rl = new TreeNode(1);
        TreeNode rr = new TreeNode(5);
        TreeNode r = new TreeNode(4, rl, rr);
        TreeNode root = new TreeNode(3, l, r);

        System.out.println(problem1448.goodNodes(root));
    }
}
