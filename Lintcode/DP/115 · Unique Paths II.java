 public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
       
        // state: dp[i][i] 代表: 从起点(0, 0) 到坐标(i, j)的方案个数
        int[][] dp = new int[m][n];

        // Initialization:
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {  // i => col
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }

        
        // fucntion：dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }  
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Answer:
        return dp[m - 1][n - 1];
    }
}