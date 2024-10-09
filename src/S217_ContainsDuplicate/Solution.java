package S217_ContainsDuplicate;

import java.util.HashSet;

public class Solution {

	public boolean containsDuplicate(int[] nums) {
		// 使用HashSet 來排除重複
		HashSet<Integer> set = new HashSet<>();

		// 遍歷數組中元素
		for (int num : nums) {
			// 元素存在set中 代表重複
			if (set.contains(num)) {
				return true;
			}
			set.add(num);
		}

		return false;
	}
}
