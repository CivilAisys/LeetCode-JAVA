package S310_MinimumHeightTrees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	/**
	 * 理解特性：
	 * 樹的高度由最遠的葉節點決定，為了最小化高度，應該讓樹的直徑盡可能平均分佈於根節點的兩側。
	 * 這意味著最小高度樹的根節點只能出現在樹的直徑的中心
	 */
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		// 僅有兩個節點的情況下 兩者都是最小高度樹的根節點候選
		if (n <= 2) {
			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				result.add(i);
			}
			return result;
		}

		// 1.構建鄰接表
		List<Set<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new HashSet<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		// 2.找出初始葉節點(邊只有1的)
		List<Integer> leaves = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (graph.get(i).size() == 1) {
				leaves.add(i);
			}
		}

		// 3.拓樸排序移除葉節點至剩餘1 or 2個節點
		int remainNodes = n;
		while(remainNodes > 2){
			remainNodes -= leaves.size();
			List<Integer> newRemainNodes = new ArrayList<>();
			for(int leaf : leaves){
				int neighbor = graph.get(leaf).iterator().next(); // 找出葉節點對應的臨節點
				graph.get(neighbor).remove(leaf); // 臨節點移除該葉節點
				// 檢查neighbor節點是否為葉節點
				if(graph.get(neighbor).size() == 1){
					newRemainNodes.add(neighbor);
				}
			}
			leaves = newRemainNodes;
		}
		// 剪枝完最後剩下的節點就是解答
		return leaves;
	}
}
