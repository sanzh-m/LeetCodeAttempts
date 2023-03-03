package Medium;

import Util.TreeNode;

public class Problem98 {
    public boolean isValidBST(TreeNode root) {
        return checkIsValidBST(root, null, null);
    }

    private boolean checkIsValidBST(TreeNode root, Integer max, Integer min) {
        if (root == null)
            return true;

        if (root.left != null && (root.left.val >= root.val || checkNodeViolatesMaxMin(root.left, max, min)))
           return false;

        if (root.right != null && (root.right.val <= root.val || checkNodeViolatesMaxMin(root.right, max, min)))
            return false;

        return checkIsValidBST(root.left, root.val, min) &&
                checkIsValidBST(root.right, max, root.val);
    }

    private boolean checkNodeViolatesMaxMin(TreeNode node, Integer max, Integer min) {
        if (max != null && node.val >= max)
            return true;
        if (min != null && node.val <= min)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Problem98 problem98 = new Problem98();
        TreeNode ll = new TreeNode(3);
        TreeNode l = new TreeNode(1, ll, null);
        TreeNode rl = new TreeNode(4);
        TreeNode rr = new TreeNode(6);
        TreeNode r = new TreeNode(5, rl, rr);
        TreeNode root = new TreeNode(3, l, r);

        System.out.println(problem98.isValidBST(root));

        ll.val = 0;

        System.out.println(problem98.isValidBST(root));

        TreeNode l1 = new TreeNode(4);
        TreeNode rl1 = new TreeNode(1);
        TreeNode rr1 = new TreeNode(7);
        TreeNode r1 = new TreeNode(6, rl1, rr1);
        TreeNode root1 = new TreeNode(5, l1, r1);

        System.out.println(problem98.isValidBST(root1));

        TreeNode llr2 = new TreeNode(27);
        TreeNode ll2 = new TreeNode(19, null, llr2);
        TreeNode l2 = new TreeNode(26, ll2, null);
        TreeNode rr2 = new TreeNode(56);
        TreeNode r2 = new TreeNode(47, null, rr2);
        TreeNode root2 = new TreeNode(32, l2, r2);

        System.out.println(problem98.isValidBST(root2));
    }
}
