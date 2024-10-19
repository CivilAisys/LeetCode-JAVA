package S658_FindKClosestElements;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	// 使用二分查找及滑動 窗口
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		// 二分查找 找到距離 x 最近的起始點
		int left = 0;
		int right = arr.length - k;

		// 二分查找
		while (left < right) {
			// mid 表示窗口最左側
			int mid = left + (right - left) / 2;
			// 比較中點與 x 的距離來決定範圍縮小的方向
			if (x - arr[mid] > arr[mid + k] - x) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		// 從最接近 x 的起始點返回長度為 k 的子數組
		List<Integer> result = new ArrayList<>();
		for (int i = left; i < left + k; i++) {
			result.add(arr[i]);
		}

		return result;
	}
}
