package S496_NextGreaterElementI;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

	// 使用單調遞減棧 (Monotonic Decreasing Stack) + HashMap
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Map<Integer, Integer> ngeMap = new HashMap<>(); // 紀錄nums2 的 next greater element
		Stack<Integer> stack = new Stack<>(); // 遞減棧

		// 遍歷nums2
		for (int num : nums2) {
			// 若棧頂元素小於當前  代表當前為棧頂的nextGreaterElement
			while (!stack.isEmpty() && stack.peek() < num) {
				ngeMap.put(stack.pop(), num);
			}
			stack.add(num);
		}

		// 處理nums1 從 map 查詢結果
		int[] result = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			result[i] = ngeMap.getOrDefault(nums1[i], -1);
		}

		return result;
	}
}
