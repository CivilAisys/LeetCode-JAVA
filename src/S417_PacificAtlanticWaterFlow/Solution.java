package S417_PacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	private static final int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 上下左右

	/**
	 * 從太平洋和大西洋的邊界開始模擬水流逆推回去
	 */
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		int rows = heights.length;
		int cols = heights[0].length;

		boolean[][] pacific = new boolean[rows][cols]; // 能流向太平洋
		boolean[][] atlantic = new boolean[rows][cols]; // 能流向大西洋
		List<List<Integer>> result = new ArrayList<>();

		// 從大西洋和太平洋邊界訪問
		for (int row = 0; row < rows; row++) {
			dfs(heights, pacific, row, 0); // 太平洋左邊界
			dfs(heights, atlantic, row, cols - 1); // 大西洋右邊界
		}

		for (int col = 0; col < cols; col++) {
			dfs(heights, pacific, 0, col); // 太平洋上邊界
			dfs(heights, atlantic, rows - 1, col); // 大西洋下邊界
		}

		// 遍歷兩個矩陣確認兩者都能到達的節點
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (pacific[row][col] && atlantic[row][col]) {
					result.add(Arrays.asList(row, col));
				}
			}
		}
		return result;
	}

	private void dfs(int[][] heights, boolean[][] ocean, int row, int col) {
		ocean[row][col] = true; // 標記當前節點為可到達

		// 四個方向遍歷檢查
		for (int[] dir : directions) {
			int newRow = row + dir[0];
			int newCol = col + dir[1];
			// 條件檢查邊界合法且新節點可以正常流向且未被標記
			if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length
				&& heights[newRow][newCol] >= heights[row][col] && !ocean[newRow][newCol]) {
				dfs(heights, ocean, newRow, newCol);
			}
		}
	}
}
