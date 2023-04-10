package Medium;

import Util.TreeNode;

public class Problem230 {
    private static class SearchResult {
        int count;
        Integer value;
        
        public SearchResult(int count, Integer value) {
            this.count = count;
            this.value = value;
        }
    }
    
    public int kthSmallest(TreeNode root, int k) {
        SearchResult res = new SearchResult(0, null);
        countNodesAndStopWhenK(root, k, res);
        return res.value;
    }
    
    private void countNodesAndStopWhenK(TreeNode root, int k, SearchResult currentResult) {
        if (root == null)
            return;
            
        countNodesAndStopWhenK(root.left, k, currentResult);
        
        if (currentResult.value != null)
            return;
        
        currentResult.count += 1;
        if (currentResult.count == k) {
            currentResult.value = root.val;
            return;
        }
        
        countNodesAndStopWhenK(root.right, k, currentResult);
    }
    
    public static void main(String[] args) {
        Problem230 problem230 = new Problem230();
        TreeNode lll = new TreeNode(5);
        TreeNode llr = new TreeNode(27);
        TreeNode ll = new TreeNode(19, lll, llr);
        TreeNode l = new TreeNode(26, ll, null);
        TreeNode rr = new TreeNode(56);
        TreeNode r = new TreeNode(47, null, rr);
        TreeNode root = new TreeNode(32, l, r);
        
        System.out.println(problem230.kthSmallest(root, 2));
    }
}
