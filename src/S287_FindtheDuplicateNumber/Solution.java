package S287_FindtheDuplicateNumber;

public class Solution {

	// 使用雙指針  將nums視作鏈表  索引視作節點 nums[i]視為該節點的指向 此為Floyd判圈算法
	public int findDuplicate(int[] nums) {
		// 使用快慢指針找到相遇點 意即鏈表中的環
		int slow = nums[0];
		int fast = nums[0];
		// 找到環 但不代表找到的是重覆的數字
		do {
			slow = nums[slow]; // 走一步
			fast = nums[nums[fast]]; // 走兩步
		} while (slow != fast);

		slow = nums[0];  // 將慢指針重置到起點
		while (slow != fast) {
			slow = nums[slow];  // 慢指針每次走一步
			fast = nums[fast];  // 快指針每次走一步
		}

		return slow;  // 當兩個指針再次相遇時，這個位置就是重複數字
	}
}
