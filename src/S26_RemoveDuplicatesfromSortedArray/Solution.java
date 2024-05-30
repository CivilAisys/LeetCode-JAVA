package S26_RemoveDuplicatesfromSortedArray;

public class Solution {

    /*
     * 使用雙指針來進行比對跟調換
     * */
    public int removeDuplicates(int[] nums) {
        int j = 1; // 此指針指向重複時應該要被替換掉的索引 初始為1因為至少1個不重複

        // 從第二個元素開始遍歷
        for (int i = 1; i < nums.length; i++) {
            // 當前元素與前一個不相等時
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i]; // 將當前元素複製給 nums[j]
                j++; // 移動指針
            }
        }
        return j; // j就是去重後的數組長度  
    }
}
