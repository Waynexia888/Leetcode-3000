public class Solution {
    /**
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        //state: dp(i) - fibonacci sequence's ith position的value
        int[] dp = new int[2];  //[0,1]
        //initialization:
        dp[0] = 0;
        dp[1] = 1;
        //function: dp[i]= dp[i-2] (dp[0]) + dp[i-1] (dp[1])
        for (int i = 2; i < n; i++) {
           dp[i % 2]= dp[(i - 2) % 2] + dp[(i - 1) % 2];
           //int temp = dp[1];
           //dp[1] = dp[0] + dp[1];
           //dp[0] = temp;
        }
        //answer
        return n % 2 == 0 ? dp[1] : dp[0];
    }
    //0,1
    //i=2; dp[0] = dp[0] + dp[1] --> 1,1
    //dp[1] = dp[1] + dp[0] --> 1,2
    //dp[0] = dp[0] + dp[1] --> 3,2

    //0,1
    //1,1
    //1,2
    //2,3
    //3,5
    //5,8
}