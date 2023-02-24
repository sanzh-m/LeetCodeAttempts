package Easy;

import Medium.Problem11;
import Util.TreeNode;

public class Problem110 {
    private static class NodeCheck {
        private int maxLength;
        private boolean balanced;

        public NodeCheck(int maxLength, boolean balanced) {
            this.maxLength = maxLength;
            this.balanced = balanced;
        }

        public int getMaxLength() {
            return maxLength;
        }

        public boolean getBalanced() {
            return balanced;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return checkNodeBalanced(root).getBalanced();
    }

    private NodeCheck checkNodeBalanced(TreeNode root) {
        if (root == null)
            return new NodeCheck(-1, true);

        NodeCheck left = checkNodeBalanced(root.left);
        NodeCheck right = checkNodeBalanced(root.right);

        if (!left.getBalanced() || !right.getBalanced() || Math.abs(left.getMaxLength() - right.getMaxLength()) > 1)
            return new NodeCheck(-1, false);

        return new NodeCheck(Math.max(left.getMaxLength(), right.getMaxLength()) + 1, true);
    }

    public static void main(String[] args) {
        Problem110 problem110 = new Problem110();
        TreeNode rlr = new TreeNode(30);
        TreeNode rl = new TreeNode(15, null, rlr);
//        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);
        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20, rl, rr);
        TreeNode root = new TreeNode(3, l, r);
        System.out.println(problem110.isBalanced(root));
    }
}
