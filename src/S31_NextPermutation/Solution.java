package S31_NextPermutation;

public class Solution {

    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;

        int i = nums.length - 2;
        // 1.找到第一個降序的元素
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            //2. 因為i 右側都為降序 估需找到比nums[i] 大的第一個元素進行調換
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // 3.將兩個元素進行調換
            swap(nums, i, j);
        }

        // 4.i的右側此時都為降序為最大  故需要將整個i右側進行反轉得到下一個序列
        reverse(nums, i + 1, nums.length - 1);
    }

    /**
     * 進行兩個索引值的調換
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
