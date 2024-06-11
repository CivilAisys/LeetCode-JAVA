package S75_SortColors;

public class Solution {

    /**
     * 使用雙指針(頭尾) 當碰到0與頭指針交換並向右移  碰到2與尾指針交換並向左移
     * 1 留在中間不動即完成排序
     */
    public void sortColors(int[] nums) {
        int head = 0, tail = nums.length - 1, i = 0; // 頭尾指針即當前索引
        // i <= tail 代表已經都排序玩
        while (i <= tail) {

            if (nums[i] == 0) {
                swap(nums, i, head);
                head++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, tail, i);
                tail--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
