package S77_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	// 使用backTracking窮舉 但需要去重
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		backTrack(result, new ArrayList<>(), n, k, 1);
		return result;
	}

	private void backTrack(List<List<Integer>> result, List<Integer> path, int n, int k, int start) {
		// 長度等於k 就加入結果
		if (path.size() == k) {
			result.add(new ArrayList<>(path));
			return;
		}

		for (int i = start; i <= n; i++) {
			path.add(i); // 將當前數字加入
			backTrack(result, path, n, k, i + 1); // 遞增窮舉可以避免重複如 [1,2] [2,1]這樣的結果
			path.remove(path.size() - 1); // 剪枝 將最後元素刪除
		}
	}
}
