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
				startStation = i + 1;
				currentTank = 0;
			}
		}

		return totalTank >= 0 ? startStation : -1;
	}
}
