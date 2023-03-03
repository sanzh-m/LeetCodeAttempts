package Medium;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        populateRightSideView(root, 0, result);

        return result;
    }

    private void populateRightSideView(TreeNode root, int level, List<Integer> result) {
        if (root == null)
            return;
        if (result.size() <= level)
            result.add(root.val);
        else
            result.set(level, root.val);

        populateRightSideView(root.left, level + 1, result);
        populateRightSideView(root.right, level + 1, result);
    }

    public static void main(String[] args) {
        Problem199 problem199 = new Problem199();
        TreeNode lrl = new TreeNode(3);
        TreeNode lrr = new TreeNode(5);
        TreeNode ll = new TreeNode(0);
        TreeNode lr = new TreeNode(4, lrl, lrr);
        TreeNode rl = new TreeNode(7);
        TreeNode rr = new TreeNode(9);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode r = new TreeNode(8, rl, rr);
        TreeNode root = new TreeNode(6, l, r);

        System.out.println(Arrays.toString(problem199.rightSideView(root).toArray()));
    }
}
