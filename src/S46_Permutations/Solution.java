package S46_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 使用backtracking 因為不重複但需要紀錄已經使用過的值
     * 時間和空間複雜度為O (n * n!) 每個選擇都要遍歷n遍  總共有 n!種選擇
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        // 中止條件
        if (nums.length == tempList.size()) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i])  // 跳過使用過的
                    continue;
                used[i] = true; // 關鍵 讓後續遞迴調用將當前略過
                tempList.add(nums[i]); // 當前加入
                backtrack(result, tempList, nums, used);
                used[i] = false; // 移除使用
                tempList.remove(tempList.size() - 1); // 移除剛剛加入的元素
            }
        }
    }
}
