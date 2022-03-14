public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // 确定答案范围
        int start = 1, end = 0;
        for (int wood : L) {
            end = Math.max(wood, end);
        }

        // >=k 的最后一个位置
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (getWoodPieces(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (getWoodPieces(L, end) >= k) {
            return end;
        }
        if (getWoodPieces(L, start) >= k) {
            return start;
        }
        return 0;
    }

    private int getWoodPieces(int[] L, int len) {
        int pieces = 0;
        for (int woodLength : L) {
            pieces += (woodLength / len);
        }
        return pieces;
    }
}

// 232 / 114 = 2  
// 124 /114 = 1
// 456 / 114 = 4

//        x-2  x- 1   x   x + 1  x + 2
//        >=k  >=k   >=k   <k     < k

//        ooooXXXXX

// [232, 6, 456] 
// k = 7
// ?


// time: O(n * logn)
// space: O(1)