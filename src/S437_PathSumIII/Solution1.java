package S437_PathSumIII;

import java.util.HashMap;

public class Solution1 {

	// 使用前綴和進行優化
	public int pathSum(TreeNode root, int targetSum) {
		// 初始化前綴和 HashMap，包含 {0: 1} 表示從根節點開始的情況
		HashMap<Long, Integer> prefixSumMap = new HashMap<>();
		prefixSumMap.put(0L, 1); // 前綴和為 0 的情況，表示從根到當前節點剛好為 targetSum

		// 調用遞歸函數，開始計算路徑和
		return dfs(root, 0, targetSum, prefixSumMap);
	}

	private int dfs(TreeNode node, long currSum, int targetSum, HashMap<Long, Integer> prefixSumMap) {
		if (node == null)
			return 0;

		// 當前路徑和
		currSum += node.val;
		// 計算從根節點到當前節點的路徑上，有多少條和等於 targetSum 的路徑
		int numPaths = prefixSumMap.getOrDefault(currSum - targetSum, 0);
		// 更新當前路徑和到前綴和 Map 中
		prefixSumMap.put(currSum, prefixSumMap.getOrDefault(currSum, 0) + 1);

		// 遞歸處理左右子樹
		numPaths += dfs(node.left, currSum, targetSum, prefixSumMap);
		numPaths += dfs(node.right, currSum, targetSum, prefixSumMap);

		// 回溯：從前綴和 Map 中移除當前路徑和，避免影響其他分支
		prefixSumMap.put(currSum, prefixSumMap.get(currSum) - 1);

		return numPaths;
	}
}
