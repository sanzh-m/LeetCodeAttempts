package Easy;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        if (root.left != null && root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        else if (root.right != null) {
            root.left = root.right;
            root.right = null;
        }
        else if (root.left != null) {
            root.right = root.left;
            root.left = null;
        }
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        Problem226 problem226 = new Problem226();
        TreeNode ll = new TreeNode(1);
        TreeNode lr = new TreeNode(3);
        TreeNode rl = new TreeNode(6);
        TreeNode rr = new TreeNode(9);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode r = new TreeNode(7, rl, rr);
        TreeNode root = new TreeNode(4, l, r);
        problem226.invertTree(root);
        List<TreeNode> one = new ArrayList<>(), two = new ArrayList<>(), temp;
        one.add(root);
        while (one.size() != 0) {
            for (TreeNode tn: one) {
                if (tn.left != null)
                    two.add(tn.left);
                if (tn.right != null)
                    two.add(tn.right);
                System.out.print(tn.val + " ");
            }
            System.out.println();
            temp = one;
            one = two;
            two = temp;
            two.clear();
        }
    }
}
