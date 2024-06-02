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

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 此條件為關鍵  代表mid可能為值的所在為left右側 最後當mid = left = right時指向的會是第一個出現的值
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 因為left = mid + 1 且內部會縮小距離  最後可能數組會越界
        if (left < nums.length && nums[left] == target) {
            return left;
        }

        return -1;
    }

    private int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right >= 0 && nums[right] == target) {
            return right;
        }

        return -1;
    }

}
