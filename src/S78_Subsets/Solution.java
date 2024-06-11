package S78_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 使用backtracking 題目為不重複數字  故不需要處理重複的情況
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int statr) {
        result.add(new ArrayList<>(tempList));
        for (int i = statr; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1); // 關鍵  移除剛剛加入的位於tempList尾端的數
        }
    }
}
