package S542_01Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	// 使用多源廣度搜尋(BFS)
	public int[][] updateMatrix(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;

		int[][] dist = new int[row][col]; // 儲存某個節點到0的最近距離
		Queue<int[]> queue = new LinkedList<>();

		// 初始化距離矩陣和隊列
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (mat[i][j] == 0) {
					dist[i][j] = 0; // 自身為0 距離就為0
					queue.offer(new int[] { i, j });
				} else {
					dist[i][j] = Integer.MAX_VALUE; // 初始化為無限大，表示尚未訪問
				}
			}
		}

		// 定義四個方向：上、下、左、右
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		// 開始BFS
		while (!queue.isEmpty()) {
			int[] cell = queue.poll();   // 取出隊首元素
			int i = cell[0];
			int j = cell[1];

			// 遍歷相鄰的四個方向
			for (int[] dir : dirs) {
				int ni = i + dir[0];   // 新的列索引
				int nj = j + dir[1];   // 新的行索引

				// 檢查新的位置是否在矩陣範圍內
				if (ni >= 0 && ni < row && nj >= 0 && nj < col) {
					// 如果新的距離更小，更新距離並將新位置加入隊列
					if (dist[ni][nj] > dist[i][j] + 1) {
						dist[ni][nj] = dist[i][j] + 1;
						queue.offer(new int[] { ni, nj });
					}
				}
			}

		}
		return dist;
	}
}
