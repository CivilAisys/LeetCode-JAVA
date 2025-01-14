package S42_TrappingRainWater;

public class Solution {

	/*
	 * 使用雙指針 雨水公式為 water[i] = min(leftMax[i], rightMax[i]) - height[i]
	 * 及為該位置可以收集的雨水量
	 * 時間複雜度 O(N) 空間複雜度 O(1)
	 */
	public int trap(int[] height) {
		if (height.length == 1) {
			return 0;
		}

		int left = 0, right = height.length - 1;
		int leftMax = 0, rightMax = 0;
		int totalWater = 0;

		while (left < right) {
			// 比較height[left] height[right]  當左邊較低，那left位置可儲雨水量就依照leftMax，不與右側相關，反之亦然
			if (height[left] < height[right]) {
				// 左邊較低 比較當前與左側最大值來決定是否能儲存雨水
				if (height[left] < leftMax) {
					totalWater += leftMax - height[left];
				} else {
					leftMax = height[left];
				}
				left++;
			} else {
				// 右邊較低 比較當前與右側最大值
				if (height[right] < rightMax) {
					totalWater += rightMax - height[right];
				} else {
					rightMax = height[right];
				}
				right--;
			}
		}
		return totalWater;
	}
}
