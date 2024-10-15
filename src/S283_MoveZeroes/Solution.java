package S283_MoveZeroes;

public class Solution {
	public void moveZeroes(int[] nums) {
		int nonZeroIndex = 0; // 用來標記非零元素應該放置的位置

		// 遍歷數組
		for (int i = 0; i < nums.length; i++) {
			// 如果當前元素不為 0，將它放到 nonZeroIndex 的位置
			if (nums[i] != 0) {
				nums[nonZeroIndex] = nums[i];
				nonZeroIndex++; // nonZeroIndex 往後移動
			}
		}

		// 將 nonZeroIndex 後面的所有元素設置為 0
		for (int i = nonZeroIndex; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}
