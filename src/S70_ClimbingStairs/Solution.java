package S70_ClimbingStairs;

public class Solution {

    /**
     * 使用dp
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        // 初始化dp數組
        int[] dp = new int[n + 1]; // n+1是因為dp[0]的關係  原地不動
        dp[0] = 1;
        dp[1] = 1;
        // 填充dp數組
        for (int i  = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // 狀態轉移方程
        }

        return dp[n];
    }
}
