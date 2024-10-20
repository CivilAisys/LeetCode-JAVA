package S977_SquaresofaSortedArray;

public class Solution {

	public int[] sortedSquares(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		int left = 0;
		int right = n - 1;
		int index = n - 1; // 填充結果陣列的索引 從後面開始填充

		// 雙指針遍歷完
		while (left <= right) {
			// 左右指針的平方
			int leftSquare = nums[left] * nums[left];
			int rightSquare = nums[right] * nums[right];

			if (leftSquare > rightSquare) {
				result[index] = leftSquare;
				left++;
			} else {
				result[index] = rightSquare;
				right--;
			}
			index--; // 填充下一個位置
		}

		return result;
	}
}
