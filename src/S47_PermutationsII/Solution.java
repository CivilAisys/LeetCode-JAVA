package S47_PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * 同第46題使用backtrack 但是nums內元素為重複  故需去重處理
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 關鍵 需要排序才能處理去重處理
        List<Integer> tempList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(result, tempList, nums, used);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        // 中止條件
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // 跳過條件  其中確保不會有重複 關鍵在於 當當前元素與前一個相同時 必須在前一個被使用才將當前加入
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
                    continue;
                tempList.add(nums[i]); // 當前元素加入
                used[i] = true;
                backtrack(result, tempList, nums, used);
                used[i] = false; // 移除使用
                tempList.remove(tempList.size() - 1); // 移除剛剛加入的元素
            }
        }
    }
}
