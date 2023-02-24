package Easy;

import Util.TreeNode;

public class Problem572 {
    private boolean isSameTree(TreeNode p, TreeNode q) {
        return ((p == null || q == null) && p == q) ||
                (p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return root != null && (isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    public static void main(String[] args) {
        Problem572 problem572 = new Problem572();
        TreeNode rlr = new TreeNode(30);
        TreeNode rll = new TreeNode(25);
        TreeNode rl = new TreeNode(15, rll, rlr);
//        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);
        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20, rl, rr);
        TreeNode root = new TreeNode(3, l, r);

        TreeNode rlr1 = new TreeNode(30);
        TreeNode rll1 = new TreeNode(25);
        TreeNode rl1 = new TreeNode(15, rll1, rlr1);
//        TreeNode rl = new TreeNode(15);
        TreeNode rr1 = new TreeNode(7);
        TreeNode r1 = new TreeNode(20, rl1, rr1);

        System.out.println(problem572.isSubtree(root, r1));

        rl.left = null;

        System.out.println(problem572.isSubtree(root, r1));
    }
}
