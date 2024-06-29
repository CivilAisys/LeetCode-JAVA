package S134_GasStation;

public class Solution {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int totalTank = 0; // 總油量
		int currentTank = 0; // 當前油量
		int startStation = 0; // 起始點
		// 排除掉不可能的起點 並判斷總油量就可以知道是否有解
		for (int i = 0; i < gas.length; i++) {
			totalTank += gas[i] - cost[i];
			currentTank += gas[i] - cost[i];
			// 排除不可能的起點 移動起點並重置當前油量
			if (currentTank < 0) {
				// 可以更新為 i + 1是因為 到達i時 i可能不是起點或當前起點
				// 但是i沒辦法到達 i+1 代表起點到i的總油量是不夠的  所以從中間任一點都是不夠的
				startStation = i + 1;
				currentTank = 0;
			}
		}

		return totalTank >= 0 ? startStation : -1;
	}
}
