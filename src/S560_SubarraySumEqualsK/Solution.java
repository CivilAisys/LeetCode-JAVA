package S560_SubarraySumEqualsK;

import java.util.HashMap;

public class Solution {

	public int subarraySum(int[] nums, int k) {
		// 哈希表  用來儲存前綴和出現的次數
		HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
		// 初始化，前綴和為0的情況出現過一次（這是用來處理子數組從起始點開始等於 k 的情況）
		prefixSumCount.put(0, 1);

		int prefixSum = 0; // 當前前綴和
		int count = 0; // 結果計數

		// 遍歷數組
		for (int num : nums) {
			// 計算當前前綴和
			prefixSum += num;

			// 若 prefixSum - k 在哈希表中  代表有對應的子數組和為k
			if (prefixSumCount.containsKey(prefixSum - k)) {
				count += prefixSumCount.get(prefixSum - k);
			}

			// 更新哈希表，記錄當前前綴和的出現次數
			prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
		}

		return count;
	}
}
