package S12_IntegerToRoman;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

	public String intToRoman(int num) {
		StringBuilder result = new StringBuilder();
		// 初始化羅馬字母對應之值 使用 LinkedHashMap來保證遍歷key時是照順序的
		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("M", 1000);
		map.put("CM", 900);
		map.put("D", 500);
		map.put("CD", 400);
		map.put("C", 100);
		map.put("XC", 90);
		map.put("L", 50);
		map.put("XL", 40);
		map.put("X", 10);
		map.put("IX", 9);
		map.put("V", 5);
		map.put("IV", 4);
		map.put("I", 1);

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			int repeatTime = num / value; // 重複次數

			result.append(key.repeat(repeatTime)); // 依照重複次數串接字串
			num %= value; // 取餘數
		}

		return result.toString();
	}
}
