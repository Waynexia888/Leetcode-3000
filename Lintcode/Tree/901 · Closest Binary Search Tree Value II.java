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
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     *          we will sort your return value in output
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        List<Integer> values = new ArrayList<>();
        dfs(root, values);

        int size = values.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = values.get(i);
        }
        // <= target的最后一个数
        int left = binarySearch(arr, target);
        int right = left + 1;

        List<Integer> results = new ArrayList<>();
        
        for (int i = 1; i <= k; i++) {
            if (left < 0) {
                results.add(arr[right]);
                right++;
                continue;
            }

            if (right > arr.length - 1) {
                results.add(arr[left]);
                left--;
                continue;
            }

            if (Math.abs(target - arr[left]) <= Math.abs(arr[right] - target)) {
                results.add(arr[left]);
                left--;
            } else {
                results.add(arr[right]);
                right++;
            }
        }
        return results;

    }

    private void dfs(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        dfs(root.left, values);
        values.add(root.val);
        dfs(root.right, values);
    }

    private int binarySearch(int[] arr, double target) {
        int start = 0, end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (arr[end] <= target) {
            return end;
        }
        if (arr[start] <= target) {
            return start;
        }
        return -1;
    }
}