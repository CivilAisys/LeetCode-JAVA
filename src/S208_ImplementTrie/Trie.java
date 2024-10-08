package S208_ImplementTrie;

public class Trie {

	// 定義 TrieNode
	private static class TrieNode {

		private TrieNode[] children;  // 子節點的引用
		private boolean isEndOfWord;  // 是否是單詞的結尾

		public TrieNode() {
			children = new TrieNode[26];  // 每個節點最多有26個子節點，對應於字母 'a' 到 'z'
			isEndOfWord = false;  // 初始時，不是單詞的結尾
		}
	}

	private TrieNode root;  // 字典樹的根節點

	public Trie() {
		root = new TrieNode();  // 初始化根節點
	}

	public void insert(String word) {
		TrieNode node = root; // 初始化從根結點開始
		// 處理單詞中的每個字符
		for (char ch : word.toCharArray()) {
			int index = ch - 'a'; // 計算字符在children陣列中的索引
			if (node.children[index] == null) {
				node.children[index] = new TrieNode(); // 子節點不存在  初始化
			}
			node = node.children[index]; // 將node移動到下一個節點
		}
		node.isEndOfWord = true; // 標記該節點為單詞結尾
	}

	public boolean search(String word) {
		TrieNode node = searchPrefix(word);
		return node != null && node.isEndOfWord; // 確保該節點為單詞結尾
	}

	public boolean startsWith(String prefix) {
		return searchPrefix(prefix) != null;
	}

	private TrieNode searchPrefix(String prefix) {
		TrieNode node = root;
		for (char ch : prefix.toCharArray()) {
			int index = ch - 'a';
			if (node.children[index] == null) {
				return null;
			}
			node = node.children[index];
		}
		return node;
	}

}
