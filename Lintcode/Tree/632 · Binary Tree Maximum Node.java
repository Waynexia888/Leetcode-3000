Lintcode 632 · Binary Tree Maximum Node

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
    int maxValue;
    TreeNode maxRoot;
    public Info(TreeNode maxRoot, int maxValue) {
        this.maxRoot = maxRoot;
        this.maxValue = maxValue;
    }
}

public class Solution {
    /**
     * @param root: the root of tree
     * @return: the max node
     */
    public TreeNode maxNode(TreeNode root) {
        // write your code here
        return process(root).maxRoot;
    }

    private Info process(TreeNode root) {
        if (root == null) {
            return new Info(null, Integer.MIN_VALUE);
        }

        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int maxValue = root.val;
        TreeNode maxRoot = root;
        if (leftInfo.maxValue >= maxValue) {
            maxValue = leftInfo.maxValue;
            maxRoot = leftInfo.maxRoot;
        }
        if (rightInfo.maxValue >= maxValue) {
            maxValue = rightInfo.maxValue;
            maxRoot = rightInfo.maxRoot;
        }
        return new Info(maxRoot, maxValue);
    }
}