Lintcode 95 · Validate Binary Search Tree

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
    boolean isBST;
    int max, min;
    public Info(boolean isBST, int max, int min) {
        this.isBST = isBST;
        this.max = max;
        this.min = min;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        return process(root).isBST;
    }

    private Info process(TreeNode root) {
        if (root == null) {
            return null;  // 在上游中去处理为null的情况
        }

        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);

        int max = root.val;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
        }

        int min = root.val;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
        }

        boolean isBST = true;
        if (leftInfo != null && !leftInfo.isBST) {
            isBST = false;
        }
        if (rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }
        if (leftInfo != null && leftInfo.max >= root.val) {
            isBST = false;
        }
        if (rightInfo != null && rightInfo.min <= root.val) {
            isBST = false;
        }

        return new Info(isBST, max, min);
    }
}