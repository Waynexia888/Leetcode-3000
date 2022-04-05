public class Solution {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] results = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                results[0] = map.get(target - numbers[i]);
                results[1] = i;
                return results;
            } else {
                map.put(numbers[i], i);  // 2: 0
            }
        }
        return new int[]{-1, -1};
    }
}

// 如果本题让你找2个数 而不是找2个index，那么可以使用two pointers，相向双指针