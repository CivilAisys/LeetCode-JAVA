package S16_3SumClosest;

import java.util.Arrays;

public class Solution {

	/**
	 * 同第15題使用雙指針找出最接近的值
	 */
	public int threeSumClosest(int[] nums, int target) {
		int minRange = Integer.MAX_VALUE;//距離預設為最大
		int closetSum = 0; // 最接近的和

		Arrays.sort(nums); // 一定要由小到大排序才有辦法做下面的計算

		for (int i = 0; i < nums.length - 2; i++) { // length - 2 至少有3個數可以做計算
			//雙指針
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				int range = Math.abs(target - sum); //距離需要絕對值

				// 距離為0 直接回傳target
				if (range == 0) {
					return target;
				}
				// 更新距離跟和
				if (range < minRange) {
					minRange = range;
					closetSum = sum;
				}

				// 比較sum 是在target的左側還是右側來決定雙指針的移動
				if (sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}

		return closetSum;
	}
}
