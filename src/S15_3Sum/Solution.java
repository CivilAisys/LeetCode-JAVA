package S15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	/**
	 * 使用雙指針並固定一個index進行查找  並且需要處理重複值的情況
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(nums); // 由小到大排序

		// 開始遍歷
		for (int i = 0; i < nums.length - 2; i++) { // i < nums.length -2 確保至少有3個數可以進行比對

			// 處理固定 i 重複的情況 避免數組越界
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			//雙指針
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (sum == 0) { //找到答案
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));

					// 排除雙指針重複的情形
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}

					while (left < right && nums[right] == nums[right - 1]) {
						right--;
					}

					// 移動指針
					left++;
					right--;

				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

		return result;
	}
}
