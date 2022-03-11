Given an array: ["good", "good", "good", "bad", "bad", "bad", "bad", "bad", "bad"]
find the index of first bad version.

-最直接解法,遍历一遍即可,time: O(n)
- 面试官follow up: 有没有更效率的解法

public int findFirstBadVersion(String[] arr) {
    
}

// -------------------------74 · First Bad Version -------------------------------
/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
public class Solution {
    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (SVNRepo.isBadVersion(start)) {
            return start;
        }
        return end;
    }
}