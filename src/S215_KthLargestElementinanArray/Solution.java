package S215_KthLargestElementinanArray;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	public int findKthLargest(int[] nums, int k) {
		// 創建最大堆
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

		// 所有元素加入最大堆
		for (int num : nums) {
			maxHeap.offer(num);
		}

		// 移除前 k - 1 個最大元素
		for (int i = 1; i < k; i++) {
			maxHeap.poll();
		}

		return maxHeap.peek();
	}
}
