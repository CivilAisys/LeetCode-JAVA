package S01_TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	/**
	 * 雙重迴圈暴力解
	 */
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	/**
	 * 最優解, 使用hashmap key儲存
	 */
	public int[] twoSum1(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i]; //計算補數
			if (map.containsKey(complement)) { //若是補數在map中 就代表找到其解
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i); //key存方當前數 value為index
		}

		throw new IllegalArgumentException("No two sum solution");
	}
}
