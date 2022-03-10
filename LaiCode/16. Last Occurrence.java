// Given a target integer T and an integer array A sorted in ascending order, 
// find the index of the last occurrence of T in A or return -1 if there is no such index.

// Assumptions

// There can be duplicate elements in the array.

// Examples

// A = {1, 2, 3}, T = 2, return 1
// A = {1, 2, 3}, T = 4, return -1
// A = {1, 2, 2, 2, 3}, T = 2, return 3

// Corner Cases
// What if A is null or A is array of zero length? We should return -1 in this case.

public class Solution {
  public int lastOccur(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return -1;
    }

    int start = 0, end = array.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (array[mid] <= target) {
        start = mid;
      } else {
        end = mid;
      }
    }

    if (array[end] == target) {
      return end;
    }
    if (array[start] == target) {
      return start;
    }
    return -1;
  }
}


// time: O(log(n))
// space: O(1)