package S88_MergeSortedArray;

public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 設置指針
        int p1 = m - 1; // num1最後有效元素
        int p2 = n - 1; // num2最後元素
        int p = m + n - 1; // num1最後元素

        // 從後往前合併 
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // num2還有剩餘元素  拷貝到num1中
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}
