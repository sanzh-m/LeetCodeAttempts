package Easy;

import Util.TreeNode;

public class Problem104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null && root.right != null)
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        if (root.left != null)
            return maxDepth(root.left) + 1;
        if (root.right != null)
            return maxDepth(root.right) + 1;
        return 1;
    }

    public static void main(String[] args) {
        Problem104 problem104 = new Problem104();
        TreeNode rlr = new TreeNode(30);
        TreeNode rl = new TreeNode(15, null, rlr);
        TreeNode rr = new TreeNode(7);
        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20, rl, rr);
        TreeNode root = new TreeNode(3, l, r);
        System.out.println(problem104.maxDepth(root));
    }
}
