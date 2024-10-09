package S211_WordDictionary;

public class WordDictionary {

	// 字典樹節點
	private static class TrieNode {

		TrieNode[] children = new TrieNode[26]; // 每個節點有26個子節點，對應26個字母
		boolean isEndOfWord = false; // 標記這個節點是否是單詞的結尾
	}

	private TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode node = root;
		for (char ch : word.toCharArray()) {
			int index = ch - 'a'; // 計算索引
			if (node.children[index] == null) {
				node.children[index] = new TrieNode();
			}
			node = node.children[index];
		}
		node.isEndOfWord = true;
	}

	public boolean search(String word) {
		return searchInNode(word, root);
	}

	private boolean searchInNode(String word, TrieNode node) {
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (ch == '.') {
				//當前字符為 '.' 遍歷所有子節點
				for (TrieNode child : node.children) {
					if (child != null && searchInNode(word.substring(i + 1), child)) {
						return true;
					}
				}
				return false;
			} else {
				// 普通字母  查找是否有對應子節點
				int index = ch - 'a';
				if (node.children[index] == null) {
					return false;
				}
				node = node.children[index];
			}
		}
		return node.isEndOfWord;
	}

}
