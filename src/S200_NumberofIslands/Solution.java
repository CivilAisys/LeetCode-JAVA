package S200_NumberofIslands;

public class Solution {

	// 使用DFS
	public int numIslands(char[][] grid) {
		int numIslands = 0; // 島嶼數量
		int rows = grid.length;
		int cols = grid[0].length;

		// 遍歷網格
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// 遇到 '1' 代表找到新島嶼
				if (grid[i][j] == '1') {
					numIslands++; // 島嶼數量 + 1
					// dfs遍歷 將這個島嶼相鄰部分都標記為 '0'
					dfs(grid, i, j);
				}
			}
		}

		return numIslands;
	}

	// 標記與(i, j) 相連的所有陸地
	private void dfs(char[][] grid, int i, int j) {
		// 超出邊界或值不是 '1' 就返回
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}

		// 將節點標記為 '0' 表示已訪問
		grid[i][j] = '0';

		// 上下左右進行dfs
		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);
	}

}
