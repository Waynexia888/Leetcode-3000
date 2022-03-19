public class Solution {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // state: dp[i][j] 代表: 从起点(0, 0) 到坐标(i, j)的方案总数
        int[][] dp = new int[m][n];

        // initialization: 第0行，第0列的前一步只能有一个方向过来
        for (int i = 0; i < m; i++) { //第0列
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) { //  第0行
            dp[0][j] = 1;
        }

        // function: dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Answer
        return dp[m - 1][n - 1];
    }
}

// time: O(m * n);
// space: O(m * n);