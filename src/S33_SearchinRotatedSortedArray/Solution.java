package S33_SearchinRotatedSortedArray;

public class Solution {

    /**
     * 使用改良的二分搜尋 需要再搜尋時判斷旋轉點
     */

    public int search(int[] nums, int target) {
        // 左右端點
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // 中間節點

            if (nums[mid] == target) {
                return mid;
            }

            // 確定左右部分哪邊是排序的
            if (nums[left] <= nums[mid]) {
                // 左半邊為排序過的
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; //目標在左半
                } else {
                    left = mid + 1; //目標在右半
                }
            } else {
                // 右半邊為排序過的
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1; // 目標在右半
                } else {
                    right = mid - 1; // 目標在左半
                }
            }
        }

        return -1; // 沒找到
    }
}
