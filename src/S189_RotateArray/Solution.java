package S189_RotateArray;

public class Solution {

	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k = k % n; // 避免 k > N
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {
			// 計算當前元素在旋轉 k 步後的新位置
			temp[(i + k) % n] = nums[i];
		}
		// 複製回原數組
		for (int i = 0; i < n; i++) {
			nums[i] = temp[i];
		}
	}
}
