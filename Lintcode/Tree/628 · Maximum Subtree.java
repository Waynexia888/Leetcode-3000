Lintcode 628 · Maximum Subtree

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
class Info {
    int subTreeSum;
    int maxSum;  
    TreeNode maxRoot;
    public Info(int sum, int maxSum, TreeNode maxRoot) {
        this.subTreeSum = sum;
        this.maxSum = maxSum;
        this.maxRoot = maxRoot;
    }
}
public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */

    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        return process(root).maxRoot;
    }

    private Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, Integer.MIN_VALUE, null);
        } 
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int subTreeSum = leftInfo.subTreeSum + rightInfo.subTreeSum + root.val;
        
        int maxSum = Integer.MIN_VALUE;  // max(leftInfo.maxSum, rightInfo.maxSum, subTreeSum)
        TreeNode maxRoot = null;
        if (subTreeSum >= Math.max(leftInfo.maxSum, rightInfo.maxSum)) {
            maxSum = subTreeSum;
            maxRoot = root;
        } else {
            if (leftInfo.maxSum > rightInfo.maxSum) {
                maxSum = leftInfo.maxSum;
                maxRoot = leftInfo.maxRoot;
            } else {
                maxSum = rightInfo.maxSum;
                maxRoot = rightInfo.maxRoot;
            }
        }

        return new Info(subTreeSum, maxSum, maxRoot);
    }
}

// ---------------------------------------------------------------------
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
class Info {
    int subTreeSum;
    int maxSum;  
    TreeNode maxRoot;
    public Info(int sum, int maxSum, TreeNode maxRoot) {
        this.subTreeSum = sum;
        this.maxSum = maxSum;
        this.maxRoot = maxRoot;
    }
}
public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */

    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        return process(root).maxRoot;
    }

    private Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, Integer.MIN_VALUE, null);
        } 
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int subTreeSum = leftInfo.subTreeSum + rightInfo.subTreeSum + root.val;
        
        int maxSum = subTreeSum;
        TreeNode maxRoot = root;
        if (leftInfo.maxSum >= maxSum) {
            maxSum = leftInfo.maxSum;
            maxRoot = leftInfo.maxRoot;
        }
        if (rightInfo.maxSum >= maxSum) {
            maxSum = rightInfo.maxSum;
            maxRoot = rightInfo.maxRoot;
        }
        return new Info(subTreeSum, maxSum, maxRoot);
    }
}