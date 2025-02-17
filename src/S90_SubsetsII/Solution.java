package S90_SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	// 使用 backTracking(窮舉) & 剪枝
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums); // 需要對nums排序不然無法去重
		backTracking(result, new ArrayList<>(), nums, 0);
		return result;
	}

	private void backTracking(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
		// 加入result
		result.add(new ArrayList<>(tempList));

		for (int i = start; i < nums.length; i++) {
			// 處理重複 i > start 才不會錯誤過濾
			if(i > start && nums[i - 1] == nums[i]) continue;
			tempList.add(nums[i]); // 加入當前
			backTracking(result, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1); // 剪枝 回溯
		}
	}
}
