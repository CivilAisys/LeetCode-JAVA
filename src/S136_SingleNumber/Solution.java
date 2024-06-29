package S136_SingleNumber;

public class Solution {

	/**
	 * 一個數與自身異或的結果是0，即 a ^ a = 0。
	 * 一個數與0異或的結果是這個數本身，即 a ^ 0 = a。
	 * 異或操作具有交換性和結合性，即 a ^ b ^ c = a ^ c ^ b。
	 */
	public int singleNumber(int[] nums) {
		int result = 0;
		for (int num : nums) {
			result ^= num;
		}
		return result;
	}
}
