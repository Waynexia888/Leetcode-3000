public class Solution {
    /**
     * @param nums: an array
     * @return: the number occurs twice and the number that is missing
     */
    public int[] findErrorNums(int[] nums) {
        // Write your code here
        int[] results = new int[2];
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                results[0] = n;
            } else {
                set.add(n);
            }
        }
        // set = {1}

        int N = nums.length;
        for (int i = 1; i <= N; i++) { // [1, 1, 3, 4]
            if (!set.contains(i)) {
                results[1] = i;
            }
        }
        return results;
    }
}

///////////////////////////////////////////////////////////////////////////
public class Solution {
    /**
     * @param nums: an array
     * @return: the number occurs twice and the number that is missing
     */
    public int[] findErrorNums(int[] nums) {
        // Write your code here
        int[] results = new int[2];
        Arrays.sort(nums);
        //key - currentNumber ; value - count
        //{1:1, 2:2, 4:1}
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int N = nums.length;
        for (int i = 1; i <= N; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 2) {
                results[0] = i;
            } else if (count == 0) {
                results[1] = i;
            }
        }
        return results;
    }
}

/////////////////////////////////////////////////////////////////////////
public class Solution {
    /**
     * @param nums: an array
     * @return: the number occurs twice and the number that is missing
     */
    public int[] findErrorNums(int[] nums) {
        // Write your code here
        int[] results = new int[2];
        Arrays.sort(nums);

        int N = nums.length;
        int[] map = new int[N + 1];
        // map = [0, 1, 2, 0, 1]
        for (int n : nums) {
            map[n]++;
        }

        for (int i = 1; i <= N; i++) {
            if (map[i] == 2) {
                results[0] = i;
            } else if (map[i] == 0) {
                results[1] = i;
            }
        }
        return results;
    }
}



