package Hard;

import Util.TreeNode;

public class Problem124 {
    public int maxPathSum(TreeNode root) {
        var result = calcMaxPathSum(root);
        return result[1];
    }
    
    private Integer[] calcMaxPathSum(TreeNode root) {
        if (root == null)
            return new Integer[]{null, null};
            
        var leftRes = calcMaxPathSum(root.left);
        var rightRes = calcMaxPathSum(root.right);
        
        Integer maxLen, maxSubLen, maxPath;
        
        if ((leftRes[0] == null || leftRes[0] <= 0) && (rightRes[0] == null || rightRes[0] <= 0)) {
            maxLen = root.val;
            maxSubLen = Integer.MIN_VALUE;
        }
        else {
            maxSubLen = Math.max(
                (leftRes[0] == null || leftRes[0] <= 0) ? 0 : leftRes[0], 
                (rightRes[0] == null || rightRes[0] <= 0) ? 0 : rightRes[0]
                );
            maxLen = maxSubLen + root.val;
        }
        
        maxPath = Math.max(
            (leftRes[0] != null ? leftRes[0] : 0) + root.val + (rightRes[0] != null ? rightRes[0] : 0), 
            maxLen
            );
        maxPath = Math.max(maxPath, maxSubLen);
        maxPath = Math.max(maxPath, Math.max(
            leftRes[1] != null ? leftRes[1] : Integer.MIN_VALUE, 
            rightRes[1] != null ? rightRes[1] : Integer.MIN_VALUE
            ));
        
        return new Integer[]{maxLen, maxPath};
    }
    
    public static void main(String[] args) {
        Problem124 problem124 = new Problem124();
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode root1 = new TreeNode(1, l1, r1);
        System.out.println(problem124.maxPathSum(root1));
        
        TreeNode l2 = new TreeNode(9);
        TreeNode rl2 = new TreeNode(15);
        TreeNode rr2 = new TreeNode(7);
        TreeNode r2 = new TreeNode(20, rl2, rr2);
        TreeNode root2 = new TreeNode(-10, l2, r2);
        System.out.println(problem124.maxPathSum(root2));
        
        TreeNode l3 = new TreeNode(-1);
        TreeNode r3 = new TreeNode(-2);
        TreeNode root3 = new TreeNode(2);
        System.out.println(problem124.maxPathSum(root3));
    }
}