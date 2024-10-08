package S210_CourseScheduleII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		// 創建鄰接表和入度表
		List<List<Integer>> adjList = new ArrayList<>();
		int[] inDegree = new int[numCourses];

		// 初始化鄰接表
		for (int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<>());
		}

		// 填充鄰接表和入度表
		for (int[] pre : prerequisites) {
			int course = pre[0];
			int prerequisite = pre[1];
			adjList.get(prerequisite).add(course);
			inDegree[course]++;
		}

		// 使用隊列儲存所有入度為0的節點(不用先修的課程)
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		// 拓樸排序結果
		int[] order = new int[numCourses];
		int index = 0;

		// BFS
		while (!queue.isEmpty()) {
			int course = queue.poll();
			order[index++] = course;

			// 遍歷該節點的後續節點
			for (int nextCourse : adjList.get(course)) {
				inDegree[nextCourse]--;
				if (inDegree[nextCourse] == 0) {
					queue.offer(nextCourse);
				}
			}
		}

		// 若結果課程數不等於總課程數  便存在環
		if (index != numCourses) {
			return new int[0];
		}

		return order;
	}
}
