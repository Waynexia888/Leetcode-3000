Lintcode 597 · Subtree with Maximum Average

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
    int numberOfNode;
    double maxAverage;
    TreeNode maxRoot;
    public Info(int subTreeSum, int numberOfNode, double maxAverage, TreeNode maxRoot){
        this.subTreeSum = subTreeSum;
        this.numberOfNode = numberOfNode;
        this.maxAverage = maxAverage;
        this.maxRoot = maxRoot;
    }
}
public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        return process(root).maxRoot;
    }
    private Info process(TreeNode root){
        if (root == null) {
            return new Info(0, 0, Integer.MIN_VALUE, null);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int subTreeSum = leftInfo.subTreeSum + rightInfo.subTreeSum + root.val;
        int numberOfNode = leftInfo.numberOfNode + rightInfo.numberOfNode + 1;
        double curAverage = (double) subTreeSum / numberOfNode;
        double maxAverage = curAverage;
        TreeNode maxRoot = root;
        if (leftInfo.maxAverage >= maxAverage) {
            maxAverage = leftInfo.maxAverage;
            maxRoot = leftInfo.maxRoot;
        }
        if (rightInfo.maxAverage >= maxAverage) {
            maxAverage = rightInfo.maxAverage;
            maxRoot = rightInfo.maxRoot;
        }
        return new Info(subTreeSum, numberOfNode, maxAverage, maxRoot);
    }
}