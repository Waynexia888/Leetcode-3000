public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here
        if (S == null || S.length < 3) {
            return 0;
        }
        
        int count = 0;
        Arrays.sort(S);
        for (int i = 2; i < S.length; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    count += right - left;
                    right--;
                } else {   // <= 7
                    left++;
                }
            }
        }
        return count;
    }
}

// a + b > c 
// a <= b <= c 

// [3, 4, 5, 6, 7] 
//     R        c
//     L

//  3 + 6 > 7   count = R - L = 3 (3 6; 4 6; 5 6), 移动R
//  3 + 5 > 7   count = R - L = 2 (3 5; 4 5)
//  3 + 4 ? 7                                      移动L

// follow up? unique 3 numbers, 那就只能一个一个数咯

// time: O(n^2);
// space: O(1);

