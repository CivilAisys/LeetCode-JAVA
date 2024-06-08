package S55_JumpGame;

public class Solution {

    /**
     * 使用 greedy
     */
    public boolean canJump(int[] nums) {
        int maxReach = 0; // 能到達最遠的位置
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // 如果當前索引超過了能到達的最遠位置，則返回 false
            }
            maxReach = Math.max(maxReach, i + nums[i]); // 更新能到達的最遠位置
        }
        return true; // 如果遍歷結束且沒有提前返回 false，則返回 true
    }

    /**
     * 使用dp
     */
    public boolean canJump1(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n]; // dp數組 儲存的為是否能到達該位置
        dp[0] = true; // 初始位置一定可以到達自己

        for (int i = 1; i < n; i++) {
            dp[i] = false; // 預設為false
            // 狀態轉移方程 如果可以從位置j到達i
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }
}
