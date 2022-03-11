// Given a target integer T and an integer array A sorted in ascending order, 
//find the index of the first occurrence of T in A or return -1 if there is no such index.

// Assumptions

// There can be duplicate elements in the array.
// Examples

// A = {1, 2, 3}, T = 2, return 1
// A = {1, 2, 3}, T = 4, return -1
// A = {1, 2, 2, 2, 3}, T = 2, return 1

// Corner Cases:
// What if A is null or A of zero length? We should return -1 in this case.

public class Solution {
  public int firstOccur(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return -1;
    }

    int start = 0, end = array.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (array[mid] < target) {
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

// time: O(logn)
// space: O(1)

//------------------------------Recursion Way ------------------------------------
public class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
      // write your code here
      return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
      // base case 
      if (start > end) {
        return -1;
      }

      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        if (mid >= 1 && nums[mid] == nums[mid - 1]) {
          return binarySearch(nums, start, mid - 1, target);
        } else {
          return mid;
        }
      } else if (nums[mid] < target) {
        return binarySearch(nums, mid + 1, end, target);
      }
      return binarySearch(nums, start, mid - 1, target);
    }
}


public class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
      // write your code here
      return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
      // base case 
      if (start > end) {
        return -1;
      }

      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        while (mid >= 1 && nums[mid] == nums[mid - 1]) {
          mid--;
        }
        return mid;
      } else if (nums[mid] < target) {
        return binarySearch(nums, mid + 1, end, target);
      }
      return binarySearch(nums, start, mid - 1, target);
    }
}