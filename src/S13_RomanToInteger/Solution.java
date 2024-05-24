package S13_RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int romanToInt(String s) {
		int result = 0;
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		// 替換原字串內容
		s = s.replace("IV", "IIII").replace("IX", "VIIII");
		s = s.replace("XL", "XXXX").replace("XC", "LXXXX");
		s = s.replace("CD", "CCCC").replace("CM", "DCCCC");

		for (char c : s.toCharArray()) {
			result += map.get(c);
		}
		return result;
	}
}
