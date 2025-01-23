package S435_NonOverlappingIntervals;

import java.util.Arrays;

public class Solution {

	/**
	 * 貪婪法的應用需要滿足兩個條件
	 * 1.最優子結構 (Optimal Substructure)：
	 * 問題的最優解可以由其子問題的最優解構成。
	 * 換句話說，當我們解決了部分問題後，剩餘的問題結構和原問題是一樣的，我們可以用相同的方法解決剩下的問題。
	 *
	 * 2.貪婪選擇性 (Greedy Choice Property)：
	 * 每次做的「局部最優選擇」，最終能夠導致全局最優解。
	 * 換句話說，每次選擇看似最佳的解，不會影響後續的選擇，並且最終可以達到最優解。
	 */
	public int eraseOverlapIntervals(int[][] intervals) {
		// 1. 按照結束時間排序 (升序)
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

		// 2. 初始化變數
		int lastEnd = intervals[0][1]; // 第一個區間的結束時間
		int removeCount = 0; // 記錄需要移除的區間數

		// 3. 遍歷所有區間
		for (int i = 1; i < intervals.length; i++) {
			// 若當前區間與上個選擇的區間不重疊
			if (intervals[i][0] >= lastEnd) {
				lastEnd = intervals[i][1]; // 更新最後選擇的結束時間
			} else {
				// 區間重疊，計數移除
				removeCount++;
			}
		}

		// 4. 回傳需要移除的區間數量
		return removeCount;
	}
}
