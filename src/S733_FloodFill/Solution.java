package S733_FloodFill;

public class Solution {

	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int oldColor = image[sr][sc]; // 起始點顏色

		// 若起始點顏色與新顏色相同 無須任何操作
		// 因為題目要變更從起始點開始相鄰與起始點相同的顏色
		if (oldColor == color) {
			return image;
		}
		// 深度優先搜索
		dfs(image, sr, sc, oldColor, color);

		return image;
	}

	private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
		// 邊界檢查  確保不越界
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
			return;
		}

		// 當前點與舊顏色不同  不用處理
		if (image[sr][sc] != oldColor) {
			return;
		}

		// 當前修改為新顏色
		image[sr][sc] = newColor;

		// 上下左右遞歸
		dfs(image, sr - 1, sc, oldColor, newColor);
		dfs(image, sr + 1, sc, oldColor, newColor);
		dfs(image, sr, sc - 1, oldColor, newColor);
		dfs(image, sr, sc + 1, oldColor, newColor);
	}
}
