package S268_MissingNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public int missingNumber(int[] nums) {
		Set<Integer> numSet = new HashSet<>();
		// 加入set中
		for (int num : nums) {
			numSet.add(num);
		}

		// 從0 到 n檢查缺失的數字
		for (int i = 0; i <= nums.length; i++) {
			if (!numSet.contains(i)) {
				return i;
			}
		}
		// 理論上不會到這裡
		return -1;
	}

	// 使用位運算 異或運算具有交換律和結合律 可以不考慮順序
	public int missingNumber1(int[] nums) {
		// 初始化 missing 為 n 缺失的可能是最大值 所以missing初始化需要為nums.length
		int missing = nums.length;

		// 遍歷數組，將索引 i 和數組中的元素 nums[i] 進行異或
		for (int i = 0; i < nums.length; i++) {
			// 使用兩次異或是為了將索引i和nums[i] 同時納入異或運算  這樣出現兩次的數字會被互相抵銷
			missing ^= i ^ nums[i];
		}

		// 異或結束後，missing 就是缺失的數字
		return missing;
	}
}
