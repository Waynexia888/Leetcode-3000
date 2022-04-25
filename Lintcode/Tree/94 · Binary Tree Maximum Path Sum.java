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
     * @param root: The root of binary tree.
     * @return: An integer
     */
    private int globalMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // write your code here
        dfs(root);
        return globalMax;
    }

    // dfs() -> 最大路径和
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftInfo = dfs(root.left);
        int rightInfo = dfs(root.right);
        leftInfo = leftInfo > 0 ? leftInfo : 0;
        rightInfo = rightInfo > 0 ? rightInfo : 0;
        int curSum = leftInfo + rightInfo + root.val; // Math.max(leftInfo, 0) + Math.max(rightInfo, 0) + root.val;
        globalMax = Math.max(globalMax, curSum);
        return Math.max(leftInfo, rightInfo) + root.val;  //每层递归返回的是 -> max path sum from root to leaf
    }
}

// -------------------------  Divide Conquer ----------------------------------

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
    int singlePathSum; // 从root往下走到任意点的最大路径，这条路径可以不包含任何点
    int maxPathSum; // 从树中任意到任意点的最大路径, 这条路径至少包含一个点
    public Info(int singlePathSum, int maxPathSum) {
        this.singlePathSum = singlePathSum;
        this.maxPathSum = maxPathSum;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        return process(root).maxPathSum;
    }

    private Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, Integer.MIN_VALUE);
        }

        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        leftInfo.singlePathSum = Math.max(leftInfo.singlePathSum, 0);
        rightInfo.singlePathSum = Math.max(rightInfo.singlePathSum, 0);
        int singlePathSum = Math.max(leftInfo.singlePathSum, rightInfo.singlePathSum) + root.val;
        int maxPathSum = Math.max(Math.max(leftInfo.maxPathSum, rightInfo.maxPathSum),
                                  leftInfo.singlePathSum + rightInfo.singlePathSum + root.val);
        return new Info(singlePathSum, maxPathSum);
    }
}