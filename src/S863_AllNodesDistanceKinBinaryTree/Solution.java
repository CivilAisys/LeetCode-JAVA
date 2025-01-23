package S863_AllNodesDistanceKinBinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

	// 時間及空間複雜度皆為 O(N)
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		// 將樹轉換為無向圖  建立圖的臨接表
		Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
		buildGraph(root, null, graph);

		// 層序遍歷 使用queue輔助
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		Set<TreeNode> visited = new HashSet<>(); // 紀錄已訪問過的節點

		queue.offer(target);
		visited.add(target);

		int distance = 0; // 當前距離
		while (!queue.isEmpty()) {
			// 距離為k 將當層加入到結果內並直接退出迴圈
			if (distance == k) {
				for (TreeNode node : queue) {
					result.add(node.val);
				}
				break;
			}

			int size = queue.size(); // 當層節點數量
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();

				for (TreeNode neighbor : graph.get(node)) {
					// 若鄰居未被訪問過
					if (!visited.contains(neighbor)) {
						queue.offer(neighbor);
						visited.add(neighbor);
					}
				}
			}
			distance++; // 距離增加
		}
		return result;
	}

	private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
		if (node == null)
			return;
		// 若map沒有key 初始化value
		if (!graph.containsKey(node)) {
			graph.put(node, new ArrayList<>());
		}
		// 無向圖需與父節點建立雙向關係
		if (parent != null) {
			graph.get(parent).add(node);
			graph.get(node).add(parent);
		}

		// 子節點遞歸建立無向圖
		buildGraph(node.left, node, graph);
		buildGraph(node.right, node, graph);
	}
}
