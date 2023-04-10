package Medium;

import Util.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Problem105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return generateTree(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }
    
    private TreeNode generateTree(int[] preorder, int[] inorder, int startPre, int endPre, int startIn, int endIn) {
        if (startPre == endPre && startIn == endIn)
            return null;
        
        TreeNode root = new TreeNode(preorder[startPre]);
        int i = startIn;
        while (inorder[i] != preorder[startPre])
            i++;
        
        TreeNode left = generateTree(preorder, inorder, startPre + 1, startPre + 1 + i - startIn, startIn, i);
        TreeNode right = generateTree(preorder, inorder, startPre + 1 + i - startIn, endPre, i + 1, endIn);
        root.left = left;
        root.right = right;
        
        return root;
    }
  
    public static void main(String[] args) {
        Problem105 problem105 = new Problem105();
        TreeNode root = problem105.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
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
