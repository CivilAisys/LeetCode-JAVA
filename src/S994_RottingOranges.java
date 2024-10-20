import java.util.LinkedList;
import java.util.Queue;

public class S994_RottingOranges {

	public int orangesRotting(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		int freshOranges = 0;

		// 將所有爛橘子加入隊列並計算新鮮橘子的數量
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 2) {
					queue.offer(new int[] { i, j }); // 將爛橘子加入隊列
				} else if (grid[i][j] == 1) {
					freshOranges++;
				}
			}
		}

		// 沒有新鮮橘子  直接返回0
		if (freshOranges == 0) {
			return 0;
		}

		int minutes = 0;
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };  // 上下左右的四個方向

		// bfs 擴散腐爛
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean hasRotten = false; // 有新的腐爛橘子代表要+1分鐘

			for (int i = 0; i < size; i++) {
				int[] rotten = queue.poll();
				int row = rotten[0];
				int col = rotten[1];

				// 嘗試向四個方向擴散
				for (int[] dir : directions) {
					int newRow = row + dir[0];
					int newCol = col + dir[1];

					// 如果新位置在邊界內，且是新鮮的橘子，則讓它變爛
					if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
						grid[newRow][newCol] = 2;  // 新鮮橘子變爛
						freshOranges--;  // 新鮮橘子數量減少
						queue.offer(new int[] { newRow, newCol });  // 新的腐爛橘子加入隊列
						hasRotten = true;  // 表示有橘子變爛
					}
				}
			}

			// 如果本輪有新橘子變爛，則時間增加
			if (hasRotten) {
				minutes++;

			}
		}

		// 如果所有的新鮮橘子都變爛了，返回所需時間，否則返回 -1
		return freshOranges == 0 ? minutes : -1;
	}
}
