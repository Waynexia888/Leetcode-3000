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
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        int curMinDepth = Math.min(left, right) + 1;
        // 当左子树或右子树为空时，最小深度取决于另一颗子树
        if (left == 0) {
            curMinDepth = right + 1;
        }
        if (right == 0) {
            curMinDepth = left + 1;
        }
        return curMinDepth;
    }
}