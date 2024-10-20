package S739_DailyTemperatures;

import java.util.Stack;

public class Solution {

	public int[] dailyTemperatures(int[] temperatures) {
		int n = temperatures.length;
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>(); // 單調棧(全部升序或降序)來儲存索引

		// 開始遍歷
		for (int i = 0; i < n; i++) {
			// 當當前溫度高於棧頂元素的氣溫
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int prevIndex = stack.pop(); // 彈出棧頂索引
				result[prevIndex] = i - prevIndex; // 計算天數差
			}
			// 將當前天索引壓入棧中
			stack.push(i);
		}

		// 最後棧中剩下的索引是無法找到更高氣溫的，它們的結果默認為 0
		return result;
	}
}
