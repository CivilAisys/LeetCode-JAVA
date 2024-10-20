package S973_KClosestPointstoOrigin;

import java.util.PriorityQueue;

public class Solution {

	public int[][] kClosest(int[][] points, int k) {
		// 使用 最大堆來保存最接近的k個點
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(distance(b), distance(a))
			// 根據距離大小比較
		);

		// 遍歷所有的點
		for (int[] point : points) {
			maxHeap.offer(point);
			if (maxHeap.size() > k) {
				maxHeap.poll(); // 如果堆的大小超過K 移除距離最遠的點
			}
		}

		// 將堆中 k 個點轉回為結果陣列
		int[][] result = new int[k][2];
		for (int i = 0; i < k; i++) {
			result[i] = maxHeap.poll();
		}

		return result;
	}

	// 計算到原點的距離平方  可以省去開根號的麻煩
	private int distance(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}
}
