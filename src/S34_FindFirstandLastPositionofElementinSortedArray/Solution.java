package S34_FindFirstandLastPositionofElementinSortedArray;

public class Solution {

	/*
	 * 使用兩個二分搜尋法  透過邊界切換的條件達成搜尋到的值是第一個還是第二個
	 */
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[] { -1, -1 };
		if (nums.length == 0) {
			return result;
		}

		result[0] = findFirst(nums, target);
		result[1] = findLast(nums, target);
		return result;
	}

	private int findFirst(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int firstPosition = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			// 只要記錄最後一個出現target的位置就好
			if (nums[mid] == target) {
				firstPosition = mid;
				right = mid - 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return firstPosition;
	}

	private int findLast(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int lastPosition = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				lastPosition = mid;
				left = mid + 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return lastPosition;
	}

}
