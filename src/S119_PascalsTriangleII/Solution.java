package S119_PascalsTriangleII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	// 使用dp 時間複雜度:O(n^2) 空間複雜度:O(n^2)
	public List<Integer> getRow(int rowIndex) {
		List<List<Integer>> dp = new ArrayList<>();

		for (int i = 0; i <= rowIndex; i++) {
			List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));

			// 狀態轉移計算 第一.二列不用計算
			for (int j = 1; j < i; j++) {
				row.set(j, dp.get(i - 1).get(j - 1) + dp.get(i - 1).get(j));
			}
			dp.add(row);
		}

		return dp.get(rowIndex);
	}

	// follow up 時間複雜度:O(n^2) 空間複雜度:O(n)
	public List<Integer> getRow1(int rowIndex) {
		List<Integer> row = new ArrayList<>(Collections.nCopies(rowIndex + 1, 0));
		row.set(0, 1); // 開頭皆為1 此代表為第一層

		// 只使用一層row來同時表示當層及上一層 並需要倒序更新避免更新錯誤
		for (int i = 1; i <= rowIndex; i++) {
			// 倒序更新 row[j] = row[j] + row[j-1] 倒序確保row[j-1]仍為上一層的值
			for (int j = i; j > 0; j--) {
				row.set(j, row.get(j) + row.get(j - 1));
			}
		}
		return row;
	}
}
