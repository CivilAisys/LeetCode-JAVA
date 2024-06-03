package S39_CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*
     * 使用backtracking(窮舉)跑遍所有可能  將candidates每個元素可加可不加
     * */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain,
        int start) {
        if (remain < 0) {
            return; // 沒有return也可以  但是return讓邏輯更完善
        } else if (remain == 0) {
            //將結果加入
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);// 將當前加入
                backtrack(result, tempList, candidates, remain - candidates[i], i); // 遞歸調用。不移動索引是因為支援重複選擇
                tempList.remove(tempList.size() - 1); // 移除剛剛加入的數並接續循環
            }
        }
    }
}
