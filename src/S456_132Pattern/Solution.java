package S456_132Pattern;

import java.util.Stack;

public class Solution {

	public boolean find132pattern(int[] nums) {
		if (nums.length < 3) {
			return false;
		}

		Stack<Integer> stack = new Stack<>(); // 單調遞減棧
		Integer maxK = Integer.MIN_VALUE; // 次大的數 132中的2

		// 從右向左遍歷  因為我們要找的是右邊的數 要先確認 nums[k] < nums[j]
		for (int i = nums.length - 1; i >= 0; i--) {







		}





	}
}
