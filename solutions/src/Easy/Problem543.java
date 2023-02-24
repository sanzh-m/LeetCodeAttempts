package Easy;

import Util.TreeNode;

public class Problem543 {
    private static class NodeCheck {
        private int maxLength;
        private int maxDiameter;

        public NodeCheck(int maxLength, int maxDiameter) {
            this.maxLength = maxLength;
            this.maxDiameter = maxDiameter;
        }

        public int getMaxLength() {
            return maxLength;
        }

        public int getMaxDiameter() {
            return maxDiameter;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return getNodeMaxLengthAndDiameter(root).getMaxDiameter();
    }

    private NodeCheck getNodeMaxLengthAndDiameter(TreeNode root) {
        if (root == null)
            return new NodeCheck(-1, 0);

        NodeCheck leftRes = getNodeMaxLengthAndDiameter(root.left);
        NodeCheck rightRes = getNodeMaxLengthAndDiameter(root.right);
        int largerDiameter = Math.max(leftRes.getMaxDiameter(), rightRes.getMaxDiameter());

        return new NodeCheck(Math.max(leftRes.getMaxLength(), rightRes.getMaxLength()) + 1, Math.max(largerDiameter, leftRes.getMaxLength() + 1 + rightRes.getMaxLength() + 1));
    }

    public static void main(String[] args) {
        Problem543 problem543 = new Problem543();
        TreeNode rlr = new TreeNode(30);
        TreeNode rl = new TreeNode(15, null, rlr);
//        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);
        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20, rl, rr);
        TreeNode root = new TreeNode(3, l, r);
        System.out.println(problem543.diameterOfBinaryTree(root));
    }
}
