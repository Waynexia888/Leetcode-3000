//----------------------------------解法一： 选或不选----------------------------------------
public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     *          we will sort your return value in output
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        dfs(nums, 0, temp, results);
        return results;
    }

    private void dfs(int[] nums, int index, List<Integer> temp, List<List<Integer>> results) {
        if (index == nums.length) {
            results.add(new ArrayList<>(temp));
            return;
        }

        // 选
        temp.add(nums[index]);
        dfs(nums, index + 1, temp, results);
        // 不选
        temp.remove(temp.size() - 1);
        dfs(nums, index + 1, temp, results);
    }
}
//----------------------------------解法二----------------------------------------

public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     *          we will sort your return value in output
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        dfs(nums, 0, temp, results);
        return results;
    }

    private void dfs(int[] nums, int startIndex, List<Integer> temp, List<List<Integer>> results) {
        results.add(new ArrayList<>(temp));

        for (int i = startIndex; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, i + 1, temp, results);
            temp.remove(temp.size() - 1);
        }
    }
}