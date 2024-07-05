package S179_LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public String largestNumber(int[] nums) {

		// 將整數數組轉換成字符串數組
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}

		// 自定義比較器排序
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				String order1 = a + b;
				String order2 = b + a;
				return order2.compareTo(order1); // 降序排列
			}
		});

		// 若排序後的最大數字是0，則整個數組的數字都是0
		if (strs[0].equals("0")) {
			return "0";
		}

		// 將排序好的字符串數組連接成字串
		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			sb.append(str);
		}

		return sb.toString();
	}
}
