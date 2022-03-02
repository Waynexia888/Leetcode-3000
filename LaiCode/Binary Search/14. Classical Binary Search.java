// Given a target integer T and an integer array A sorted in ascending order, find the index i such that A[i] == T or return -1 if there is no such index.

// Assumptions

// There can be duplicate elements in the array, and you can return any of the indices i such that A[i] == T.
// Examples

// A = {1, 2, 3, 4, 5}, T = 3, return 2
// A = {1, 2, 3, 4, 5}, T = 6, return -1
// A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3

// Corner Cases:
// What if A is null or A is of zero length? We should return -1 in this case.

public class Solution {
    public int binarySearch(int[] array, int target) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0, end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (array[start] == target) {
            return start;
        }
        if (array[end] == target) {
            return end;
        }
        return -1;
    }
}

// time: O(nlogn)
// space: O(1)