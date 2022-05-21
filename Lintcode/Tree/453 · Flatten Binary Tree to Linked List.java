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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        List<TreeNode> results = new ArrayList<>();
        preOrder(root, results);
        TreeNode head = results.get(0);
        for (int i = 1; i < results.size(); i++) {
            head.left = null;
            head.right = results.get(i);
            head = results.get(i);
        }
    }

    private void preOrder(TreeNode root, List<TreeNode> results) {
        if (root == null) {
            return;
        }
        results.add(root);
        preOrder(root.left, results);
        preOrder(root.right, results);
    }
}

//--------------------------------------------------------------------------
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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        processAndReturnLastNode(root);
    }

    private TreeNode processAndReturnLastNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftLastNode = processAndReturnLastNode(root.left);
        TreeNode rightLastNode = processAndReturnLastNode(root.right);

        if (leftLastNode != null) {
            leftLastNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (rightLastNode != null) {
            return rightLastNode;
        }
        if (leftLastNode != null) {
            return leftLastNode;
        }
        return root;
    }
}