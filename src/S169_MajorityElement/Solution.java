package S169_MajorityElement;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> countMap = new HashMap<>();
		int majority = nums.length / 2;

		for (int num : nums) {
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
			// 當計數大於majority時  代表找到解答
			if (countMap.get(num) > majority) {
				return num;
			}
		}
		// 由於題目假設數組中總是存在多數元素，這裡永遠不會到達
		throw new IllegalArgumentException("No majority element found");
	}
}
