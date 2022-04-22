Lintcode 467 · Complete Binary Tree
Leetcode 958. Check Completeness of a Binary Tree

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
     * @param root: the root of binary tree.
     * @return: true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        // 空的二叉树是CBT
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 条件1: 右边不为空，左边为空，不满足CBT
                if (node.right != null && node.left == null) {
                    return false;
                }
                // 条件2: 第一次发现左右不双全的节点之后，剩下的节点必定是叶子结点，否则就不满足CBT
                if (leaf && (node.left != null || node.right != null)) {
                    return false;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left == null || node.right == null) {
                    leaf = true;
                }
            }
        }
        return true;
    }
}

//-------------------------------