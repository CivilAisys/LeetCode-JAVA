package S207_CourseSchedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// 建立入度數組與鄰接表(可用來表圖的結構)
		// 入度數組是為了找到修課的起始點
		int[] inDegree = new int[numCourses];
		Map<Integer, List<Integer>> graph = new HashMap<>();

		// 初始化圖
		for (int i = 0; i < numCourses; i++) {
			graph.put(i, new ArrayList<>());
		}
		// 構建圖
		for (int[] pre : prerequisites) {
			int course = pre[0];
			int preReq = pre[1];
			graph.get(preReq).add(course); // preReq -> course
			inDegree[course]++; // 課程入度+1
		}
		// 初始化隊列  將入度為0的節點加入
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		int completedCourses = 0;
		while (!queue.isEmpty()) {
			int current = queue.poll(); // 取出當前可以學習的課程
			completedCourses++; // 完成當前課程
			// 遍歷當前課程的後繼節點
			for (int neighbor : graph.get(current)) {
				inDegree[neighbor]--; // 將後繼課程的入度減 1
				if (inDegree[neighbor] == 0) {
					queue.offer(neighbor); // 如果後繼課程的入度變為 0，加入隊列
				}
			}
		}
		return completedCourses == numCourses;
	}
}
