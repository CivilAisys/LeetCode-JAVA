package S45_JumpGameII;

public class Solution {

    /**
     * 使用貪心算法來進行計算
     */
    public int jump(int[] nums) {
        int jump = 0; // 跳躍次數
        int currentEnd = 0; // 當前跳躍可達到最遠的位置 初始為0
        int farthest = 0; // 可達到的最遠位置

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            // 當到達了當前跳躍可到的最遠位置  需要更新跳躍次數跟currentEnd
            if (i == currentEnd) {
                jump++;
                currentEnd = farthest;
            }
        }
        return jump;
    }
}
