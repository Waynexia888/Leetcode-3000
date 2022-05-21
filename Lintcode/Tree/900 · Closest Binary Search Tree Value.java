/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        if (root == null) {
            return 0;
        }

        TreeNode minNode = lowerBound(root, target);
        TreeNode maxNode = upperBound(root, target);
        if (minNode == null) {
            return maxNode.val;
        }
        
        if (maxNode == null) {
            return minNode.val;
        }

        if (target - minNode.val > maxNode.val - target) {
            return maxNode.val;
        }
        return minNode.val;
    }

    // <= target 的最大值
    private TreeNode lowerBound(TreeNode root, double target) {
        if (root == null) {
            return null;
        }
        
        if (target < root.val) {
            return lowerBound(root.left, target);
        }
        TreeNode minNode = lowerBound(root.right, target);
        return (minNode != null) ? minNode : root;
    }
    
    // >= target 的最小值
    private TreeNode upperBound(TreeNode root, double target) {
        if (root == null) {
            return null;
        }

        if (target >= root.val) {
            return upperBound(root.right, target);
        }
        TreeNode maxNode = upperBound(root.left, target);
        return (maxNode != null) ? maxNode : root;
    }
}

// --------------------------------非递归版本-----------------------------------
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        TreeNode minNode = root;
        TreeNode maxNode = root;

        while (root != null) {
            if (root.val < target) {
                minNode = root;
                root = root.right;
            } else if (root.val > target) {
                maxNode = root;
                root = root.left;
            } else {
                return root.val;
            }
        }
        if (Math.abs(maxNode.val - target) <= Math.abs(target - minNode.val)) {
            return maxNode.val;
        }
        return minNode.val;
    }
}