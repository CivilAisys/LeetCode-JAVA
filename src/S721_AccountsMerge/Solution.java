package S721_AccountsMerge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Solution {

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		// 用來記錄每個電子郵件對應的使用者名稱
		Map<String, String> emailToName = new HashMap<>();
		// 並查集的 parent 結構，用來記錄每個電子郵件的父節點
		Map<String, String> parent = new HashMap<>();
		// 用來存放合併結果的 unions 結構，根節點對應所有相關的電子郵件
		Map<String, TreeSet<String>> unions = new HashMap<>();

		// 1. 初始化每個電子郵件的並查集，並把名稱對應到電子郵件
		for (List<String> account : accounts) {
			String name = account.get(0); // 第一個元素是使用者名稱
			for (int i = 1; i < account.size(); i++) { // 從第二個元素開始是電子郵件
				String email = account.get(i);
				parent.putIfAbsent(email, email); // 將每個電子郵件初始化為它自己的父節點
				emailToName.put(email, name); // 電子郵件對應名稱，之後要用
				// 把該帳戶的所有電子郵件都 union 到一起（帳戶內的電子郵件應該屬於同一個集合）
				union(parent, account.get(1), email);
			}
		}

		// 2. 使用 find 將所有的電子郵件歸類到它們的根節點下
		for (String email : parent.keySet()) {
			String root = find(parent, email); // 找到當前電子郵件的根節點
			// 如果這個根節點還沒在 unions 裡面，初始化一個 TreeSet (自動字典順序排序)
			unions.putIfAbsent(root, new TreeSet<>());
			// 將這個電子郵件加入對應根節點的集合中
			unions.get(root).add(email);
		}

		// 3. 最後組裝結果：根據每個根節點，將其所有電子郵件集合轉換為結果格式
		List<List<String>> result = new ArrayList<>();
		for (String root : unions.keySet()) {
			List<String> emails = new ArrayList<>(unions.get(root));
			emails.add(0, emailToName.get(root)); // 把帳戶名稱放在電子郵件前面
			result.add(emails); // 加入結果
		}

		return result;
	}

	// 並查集中的 find 操作，找到某個電子郵件的根節點，並壓縮路徑
	private String find(Map<String, String> parent, String email) {
		// 如果這個電子郵件不是自己的父節點，就繼續尋找它的父節點
		if (!parent.get(email).equals(email)) {
			// 路徑壓縮：讓這個電子郵件直接指向它的根節點，這樣可以加速之後的查找
			parent.put(email, find(parent, parent.get(email)));
		}
		return parent.get(email); // 返回根節點
	}

	// 並查集中的 union 操作，將兩個電子郵件合併到同一個集合中
	private void union(Map<String, String> parent, String email1, String email2) {
		String root1 = find(parent, email1); // 找到 email1 的根節點
		String root2 = find(parent, email2); // 找到 email2 的根節點
		if (!root1.equals(root2)) {
			// 如果兩個電子郵件的根節點不同，將它們合併
			parent.put(root1, root2); // 把 root1 的根設為 root2，這樣就合併了
		}
	}
}
