package S525_ContiguousArray;

import java.util.HashMap;

public class Solution {

	public int findMaxLength(int[] nums) {
		// 創建HashMap來儲存前綴和和對應出現的索引
		HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

		// 初始化：當前綴和為 0 時，索引為 -1，代表在計算開始之前
		// 重要  不然在後續 0,1數量相同時 沒有辦法辨別與起點的距離
		prefixSumMap.put(0, -1);

		// 最大長度 和 前綴和
		int maxLength = 0;
		int prefixSum = 0;

		// 遍歷數組
		for (int i = 0; i < nums.length; i++) {
			// 將 0 視為 -1  1不變
			prefixSum += nums[i] == 0 ? -1 : 1;

			// 如果當前前綴和已經出現過，計算該子陣列的長度
			if (prefixSumMap.containsKey(prefixSum)) {
				// 計算當前前綴和相同的索引距離
				int previousIndex = prefixSumMap.get(prefixSum);
				maxLength = Math.max(maxLength, i - previousIndex); // 不包含 previousIndex 所以不用+1
			} else {
				prefixSumMap.put(prefixSum, i);
			}
		}

		return maxLength;
	}
}
