package S278_FirstBadVersion;

public class Solution {

	// 使用二分查找
	public int firstBadVersion(int n) {
		int left = 1;
		int right = n;

		// 二分查找
		while (left < right) {
			int mid = left + (right - left) / 2; // 避免溢出

			if (isBadVersion(mid)) {
				right = mid;  // 如果 mid 是壞版本，縮小範圍到左邊
			} else {
				left = mid + 1;  // 如果 mid 不是壞版本，縮小範圍到右邊
			}
		}
		// 最後 left 和 right 會相等，指向第一個壞版本
		return left;
	}
	// 避免編譯不通過
	private boolean isBadVersion(int mid) {
		return true;
	}

}
