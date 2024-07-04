package S152_MaximumProductSubarray;

public class Solution {

	public int maxProduct(int[] nums) {
		// 定義dpMax & dpMin
		int n = nums.length;
		int[] dpMax = new int[n];
		int[] dpMin = new int[n];

		//初始化dpMax & dpMin & maxProduct為第一個數
		dpMax[0] = nums[0];
		dpMin[0] = nums[0];
		int maxProduct = nums[0];
		// 從第二個開始遍歷
		for (int i = 1; i < n; i++) {
			// 重點 最大 * 負數 會變最小  最小 * 負數變為最大 故需要考慮當前元素正負
			if (nums[i] >= 0) {
				dpMax[i] = Math.max(nums[i], dpMax[i - 1] * nums[i]);
				dpMin[i] = Math.min(nums[i], dpMin[i - 1] * nums[i]);
			} else {
				dpMax[i] = Math.max(nums[i], dpMin[i - 1] * nums[i]);
				dpMin[i] = Math.min(nums[i], dpMax[i - 1] * nums[i]);
			}

			// 更新最大乘積
			maxProduct = Math.max(maxProduct, dpMax[i]);
		}

		return maxProduct;
	}
}
