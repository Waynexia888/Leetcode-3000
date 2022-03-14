public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */ 
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        int left = findPosition(A, target);
        int right = left + 1;
        int[] results = new int[k];

        for (int i = 0; i < results.length; i++) {
            if (left < 0) {
                results[i] = A[right];
                right++;
                continue;
            }
            if (right > A.length - 1) {
                results[i] = A[left];
                left--;
                continue;
            }
            if (Math.abs(A[left] - target) <= Math.abs(A[right] - target)) {
                results[i] = A[left];
                left--;
            } else {
                results[i] = A[right];
                right++;
            }
        }
        return results;
    }

    //find <=target的最右边的位置
    private int findPosition(int[] A, int target) {
        int start = 0;
        int end = A.length -1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target < A[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[end] <= target) {
            return end;
        }
        if (A[start] <= target) {
            return start;
        }
        return -1;
    }
}

// time: O(log(n) + k)
// space: O()