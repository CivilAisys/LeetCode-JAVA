package S456_132Pattern;

import java.util.Stack;

public class Solution {

	public boolean find132pattern(int[] nums) {
		if (nums.length < 3) {
			return false;
		}

		Stack<Integer> stack = new Stack<>(); // 單調遞減棧
		int maxK = Integer.MIN_VALUE; // 右側最大的次大值 132中的2 因為需要nums[i] < nums[k] 所以我們的nums[k]要保持最大值

		// 從右向左遍歷  因為我們要找的是右邊的數 要先確認 nums[k] < nums[j]
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] < maxK)
				return true;

			while (!stack.isEmpty() && nums[i] > stack.peek()) {
				maxK = stack.pop();
			}
			stack.push(nums[i]);
		}

		return false;
	}
}
