package S209_MinimumSizeSubarraySum;

public class Solution {

	// 時間複雜度:O(n) 空間複雜度:O(1)
	public int minSubArrayLen(int target, int[] nums) {
		int left = 0, sum = 0, minLength = Integer.MAX_VALUE;
		// 使用滑動窗口
		for (int right = 0; right < nums.length; right++) {
			sum += nums[right]; // 拓展右邊界

			while (sum >= target) {
				minLength = Math.min(minLength, right - left + 1);
				// 縮減左邊界來確認是否有更小的組合
				sum -= nums[left];
				left++;
			}
		}
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
}
