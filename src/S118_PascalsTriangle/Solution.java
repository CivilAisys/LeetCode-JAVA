package S118_PascalsTriangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	// 使用dp 狀態轉移方程為 dp[i][j] = dp[i-1][j-1] + dp[i-1][j]  每行開頭結尾皆為1
	// 時間複雜度:O(n^2) 空間複雜度:O(n^2)
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> dp = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));

			// 狀態轉移計算 第一.二列不用計算
			for (int j = 1; j < i; j++) {
				row.set(j, dp.get(i - 1).get(j - 1) + dp.get(i - 1).get(j));
			}

			dp.add(row);
		}
		return dp;
	}
}
