Lintcode 1094 · Second Minimum Node In a Binary Tree
Leetcode 671. Second Minimum Node In a Binary Tree

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
     * @param root: the root
     * @return: the second minimum value in the set made of all the nodes' value in the whole tree
     */
    private int min1, min2;
    public int findSecondMinimumValue(TreeNode root) {
        min1 = root.val;
        min2 = -1;
        topDownDfs(root);
        return min2 == -1 ? -1 : min2;
    }

    private void topDownDfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (min2 == -1 && root.val > min1) {
            min2 = root.val;
        } else if (min1 < root.val && root.val < min2) {
            min2 = root.val;
        }
        topDownDfs(root.left);
        topDownDfs(root.right);
    }
}

// -------------------------------------------------------------------------
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
     * @param root: the root
     * @return: the second minimum value in the set made of all the nodes' value in the whole tree
     */
    
    public int findSecondMinimumValue(TreeNode root) {
        int[] ans = new int[2];
        ans[0] = root.val;  // 第1小
        ans[1] = -1;        // 第2小
        topDownDfs(root, ans);
        return ans[1] == -1 ? -1 : ans[1];
    }

    private void topDownDfs(TreeNode root, int[] ans) {
        if (root == null) {
            return;
        }

        if (ans[1] == -1 && root.val > ans[0]) {
            ans[1] = root.val;
        } else if (ans[0] < root.val && root.val < ans[1]) {
            ans[1] = root.val;
        }
        topDownDfs(root.left, ans);
        topDownDfs(root.right, ans);
    }
}