package Medium;

import Util.TreeNode;

public class Problem235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val >= root.val && q.val <= root.val || p.val <= root.val && q.val >= root.val)
            return root;
        return lowestCommonAncestor(p.val > root.val ? root.right : root.left, p, q);
    }

    public static void main(String[] args) {
        Problem235 problem235 = new Problem235();
        TreeNode lrl = new TreeNode(3);
        TreeNode lrr = new TreeNode(5);
        TreeNode ll = new TreeNode(0);
        TreeNode lr = new TreeNode(4, lrl, lrr);
        TreeNode rl = new TreeNode(7);
        TreeNode rr = new TreeNode(9);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode r = new TreeNode(8, rl, rr);
        TreeNode root = new TreeNode(6, l, r);

        System.out.println(problem235.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4)).val);
    }
}
