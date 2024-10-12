package S238_ProductofArrayExceptSelf;

public class Solution {

	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];

		// 第一次遍歷：計算前綴乘積
		result[0] = 1;  // 第0個元素的左邊沒有數，乘積為1
		for (int i = 1; i < n; i++) {
			result[i] = result[i - 1] * nums[i - 1];
		}

		// 第二次遍歷：計算後綴乘積，並與前綴乘積相乘
		int rightProduct = 1;  // 初始化右側乘積為1
		for (int i = n - 1; i >= 0; i--) {
			result[i] = result[i] * rightProduct;  // 前綴乘積 * 後綴乘積
			rightProduct *= nums[i];  // 更新右側乘積
		}

		return result;
	}
}
