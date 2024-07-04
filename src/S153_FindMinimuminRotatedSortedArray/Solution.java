package S153_FindMinimuminRotatedSortedArray;

public class Solution {

	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			// 若中點元素大於右端元素, 說明最小值在右半部分
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid; // 包括中點
			}
		}

		// 當left= right 即為最小值
		return nums[left];
	}
}
