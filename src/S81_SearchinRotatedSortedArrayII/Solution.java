package S81_SearchinRotatedSortedArrayII;

public class Solution {

	public boolean search(int[] nums, int target) {
		// 左右端點
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return true;
			}
			// 無法區分哪邊排序 將左右端點縮小
			if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
				left++;
				right--;
				continue;
			}

			// 判斷左右半邊是否排序
			if (nums[left] <= nums[mid]) {
				// 左半邊是排序過的
				// 判斷target 是否在 left -> mid 的區間內
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				// 右半邊是排序過的
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return false;
	}
}
