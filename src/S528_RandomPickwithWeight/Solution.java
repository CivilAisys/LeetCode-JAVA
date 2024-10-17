package S528_RandomPickwithWeight;

import java.util.Random;

public class Solution {

	private int[] prefixSums;
	private int totalSum;
	private Random random;

	// 初始化時計算前綴和陣列
	public Solution(int[] w) {
		prefixSums = new int[w.length];
		prefixSums[0] = w[0]; // prefix[i] 其中 i 代表的為第i個元素前面的總和(包含i)

		// 構建前綴和陣列
		for (int i = 1; i < w.length; i++) {
			prefixSums[i] = prefixSums[i - 1] + w[i];
		}
		totalSum = prefixSums[prefixSums.length - 1];
		random = new Random();
	}

	public int pickIndex() {
		// 生成 [1, totalSum] 之間的隨機數 從1 開始是因為權重至少為1
		int target = random.nextInt(totalSum) + 1;
		// 二分搜索  找第一個大於等於target的索引
		int low = 0;
		int high = prefixSums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (prefixSums[mid] >= target) {
				high = mid - 1; // 找第一個  故向左搜尋可能的結果
			} else {
				low = mid + 1; // mid < target 向右搜尋
			}
		}

		return low;
	}
}
