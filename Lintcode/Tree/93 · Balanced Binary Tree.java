Lintcode 93 · Balanced Binary Tree
Leetcode 110. Balanced Binary Tree

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
    public boolean isBalancedBT;
    public int height;
    public Info(boolean isBalancedBT, int height) {
        this.isBalancedBT = isBalancedBT;
        this.height = height;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return process(root).isBalancedBT;
    }

    private Info process(TreeNode node) {
        if (node == null) {
            return new Info(true, 0);
        }

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalancedBT = true;
        if (!leftInfo.isBalancedBT || !rightInfo.isBalancedBT) {
            isBalancedBT = false;
        }
        if (Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBalancedBT = false;
        }
        return new Info(isBalancedBT, height);
    }
}