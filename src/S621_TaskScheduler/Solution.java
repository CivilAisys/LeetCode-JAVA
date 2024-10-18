package S621_TaskScheduler;

import java.util.Arrays;

public class Solution {

	public int leastInterval(char[] tasks, int n) {
		// 紀錄每個任務出現的頻率
		int[] taskCounts = new int[26];
		for (char task : tasks) {
			taskCounts[task - 'A']++;
		}

		// 排序
		Arrays.sort(taskCounts);

		// 找到出現最多次數任務的次數
		int maxFreq = taskCounts[25];

		// 計算最多任務之間應該有多少空位
		int idleSlots = (maxFreq - 1) * n;

		// 用其餘任務去填充這些空位
		for (int i = 24; i >= 0 && taskCounts[i] > 0; i--) {
			idleSlots -= Math.min(taskCounts[i], maxFreq - 1);
		}

		// 如果空位還沒填滿，則總時間為所有任務的長度加上空位
		// 如果空位已經填滿或者不需要空位，則總時間就是所有任務的數量
		return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
	}
}
