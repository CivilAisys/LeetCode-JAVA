package S787_CheapestFlightsWithinKStops;

import java.util.Arrays;

public class Solution {

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		// 初始化dp陣列 dp[i][j]：表示從 src 出發，最多經過 i 次訪問，到達城市 j 的最小花費。
		// 若 k = 1 所以共有 3種訪問 0次訪問(原地) 1次訪問(直飛) 2次訪問(1次中轉) 共 k+2種
		int[][] dp = new int[k + 2][n];
		for (int[] row : dp) {
			Arrays.fill(row, Integer.MAX_VALUE); // 初始值設為無限大
		}
		dp[0][src] = 0; // 初始條件，從 src 出發，不經過任何中轉 代表在原地

		return -1;
	}
}
