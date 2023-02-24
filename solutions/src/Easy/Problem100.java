package Easy;

import Util.TreeNode;

public class Problem100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return ((p == null || q == null) && p == q) ||
                (p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public static void main(String[] args) {
        Problem100 problem100 = new Problem100();
        TreeNode rlr = new TreeNode(30);
        TreeNode rl = new TreeNode(15, null, rlr);
//        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);
        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20, rl, rr);
        TreeNode root = new TreeNode(3, l, r);

        TreeNode rlr1 = new TreeNode(30);
        TreeNode rl1 = new TreeNode(15, null, rlr1);
//        TreeNode rl = new TreeNode(15);
        TreeNode rr1 = new TreeNode(7);
        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(20, rl1, rr1);
        TreeNode root1 = new TreeNode(3, l1, r1);

        System.out.println(problem100.isSameTree(root, root1));

        rl1.right = null;

        System.out.println(problem100.isSameTree(root, root1));
    }
}
