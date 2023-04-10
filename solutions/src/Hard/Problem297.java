package Hard;

import  Util.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

public class Problem297 {
    static
    public class Codec {
        String NULL_STRING = "null";
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return NULL_STRING;
            Queue<Queue<TreeNode>> queues = new ArrayDeque<>();
            Queue<TreeNode> one = new ArrayDeque<>();
            Queue<TreeNode> two = new ArrayDeque<>();
            queues.add(one);
            queues.add(two);
            one.add(root);
            StringBuilder result = new StringBuilder();
            result.append(root.val);
            TreeNode pointer;
            Boolean nextNonNullInRow = false, nonNullInRow = root.left != null || root.right != null;
            
            while (!queues.peek().isEmpty()) {
                one = queues.remove();
                two = queues.remove();
                
                while(!one.isEmpty()) {
                    pointer = one.remove();
                    if (pointer.left != null) {
                        result.append(",").append(pointer.left.val);
                        two.add(pointer.left);
                        nextNonNullInRow = nextNonNullInRow || pointer.left.left != null || pointer.left.right != null;
                    } else if (nonNullInRow) {
                        result.append(",").append(NULL_STRING);
                    }
                    if (pointer.right != null) {
                        result.append(",").append(pointer.right.val);
                        two.add(pointer.right);
                        nextNonNullInRow = nextNonNullInRow || pointer.right.left != null || pointer.right.right != null;
                    } else if (nonNullInRow) {
                        result.append(",").append(NULL_STRING);
                    }
                }
                
                nonNullInRow = nextNonNullInRow;
                nextNonNullInRow = false;
                queues.add(two);
                queues.add(one);
            }
            
            return result.toString();
        }
    
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (NULL_STRING.equals(data))
                return null;
            String[] values = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            Queue<Queue<TreeNode>> queues = new ArrayDeque<>();
            Queue<TreeNode> one = new ArrayDeque<>();
            Queue<TreeNode> two = new ArrayDeque<>();
            queues.add(one);
            queues.add(two);
            one.add(root);
            int pointer = 1;
            TreeNode current;
            
            while (!queues.peek().isEmpty()) {
                one = queues.remove();
                two = queues.remove();
                
                while (!one.isEmpty() && pointer < values.length) {
                    current = one.remove();
                    if (!NULL_STRING.equals(values[pointer])) {
                        TreeNode left = new TreeNode(Integer.parseInt(values[pointer]));
                        current.left = left;
                        two.add(left);
                    }
                    pointer++;
                    if (pointer < values.length && !NULL_STRING.equals(values[pointer])) {
                        TreeNode right = new TreeNode(Integer.parseInt(values[pointer]));
                        current.right = right;
                        two.add(right);
                    }
                    pointer++;
                }
                
                queues.add(two);
                queues.add(one);
            }
            
            return root;
        }
    }
    
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode l2 = new TreeNode(9);
        TreeNode rl2 = new TreeNode(15);
        TreeNode rr2 = new TreeNode(7);
        TreeNode r2 = new TreeNode(20, rl2, rr2);
        TreeNode root2 = new TreeNode(-10, l2, r2);
        System.out.println(codec.serialize(root2));
        
        System.out.println(codec.serialize(codec.deserialize("5,4,7,3,null,2,null,-1,null,9")));
    }
}