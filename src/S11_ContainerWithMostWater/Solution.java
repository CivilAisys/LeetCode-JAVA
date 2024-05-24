package S11_ContainerWithMostWater;

public class Solution {

	/**
	 * 使用貪心法並使用雙指針進行左右移動計算容積
	 */
	public int maxArea(int[] height) {
		int maxVolume = 0; // 最大容積
		int left = 0, right = height.length - 1;

		while (right > left) {
			// 比較當前容積與當前最大容積
			maxVolume = Math.max(maxVolume, Math.min(height[left], height[right]) * (right - left));
			// 短邊內移
			if (height[left] <= height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxVolume;
	}
}
