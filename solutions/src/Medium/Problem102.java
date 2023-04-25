package Medium;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        populateLevelOrder(root, 0, result);

        return result;
    }

    private void populateLevelOrder(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null)
            return;
        if (result.size() <= level)
            result.add(new ArrayList<>());
        List<Integer> list = result.get(level);
        list.add(root.val);
        populateLevelOrder(root.left, level + 1, result);
        populateLevelOrder(root.right, level + 1, result);
    }

    public static void main(String[] args) {
        Problem102 problem102 = new Problem102();
        TreeNode lrl = new TreeNode(3);
        TreeNode lrr = new TreeNode(5);
        TreeNode ll = new TreeNode(0);
        TreeNode lr = new TreeNode(4, lrl, lrr);
        TreeNode rl = new TreeNode(7);
        TreeNode rr = new TreeNode(9);
        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode r = new TreeNode(8, rl, rr);
        TreeNode root = new TreeNode(6, l, r);

        List<List<Integer>> result = problem102.levelOrder(root);

        for (List<Integer> list: result)
            System.out.println(Arrays.toString(list.toArray()));
    }
}
