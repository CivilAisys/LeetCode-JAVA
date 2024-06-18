package S128_LongestConsecutiveSequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        // 使用Set 來過濾以及查詢
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0; // 最大長度
        // 遍歷nums
        for (int num : nums) {
            // 僅需要查看為起點的值 若該num-1有在set內代表該num值非為起點
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 檢查後續的值是否在set中
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                // 與當前最大長度取大
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public int longestConsecutive1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // 先對數組進行排序
        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { // 要排除重複  不然會對計算最大長度產生干擾
                if (nums[i] == nums[i - 1] + 1) {
                    // 如果當前數字和前一個數字連續
                    currentStreak += 1;
                } else {
                    // 否則重置當前連續序列的長度
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        // 最後再檢查一次最長連續序列的長度
        return Math.max(longestStreak, currentStreak);
    }
}
