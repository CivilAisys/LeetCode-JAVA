package S27_RemoveElement;

public class Solution {

    /**
     * 同26題邏輯  使用雙指針
     */
    public int removeElement(int[] nums, int val) {
        int slow = 0; // 初始化慢指針指向當前要調換的位置

        // 使用快指針遍歷數組並進行比對調換
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                // 當 快指針位址值不為val時。替換slow的值為fast值並將slow往後移動
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow; // 此時慢指針就是新數組長度 因為slow所指向就是要進行比對的位置 故會比實際索引+1
    }
}

