package S503_NextGreaterElementII;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

	// 使用單調遞減棧和模擬循環陣列
	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		Arrays.fill(result, -1); // 預設 -1

		Stack<Integer> stack = new Stack<>(); // 存的是索引

		// 遍歷兩輪 模擬循環陣列
		for(int i = 0; i < 2 * n;i++){
			int num = nums[i % n];

			while(!stack.isEmpty() && num > nums[stack.peek()]){
				result[stack.pop()] = num;
			}
			// 僅在 i < n 才加入stack 不然會溢出
			if(i < n){
				stack.add(i);
			}
		}

		return result;
	}
}
