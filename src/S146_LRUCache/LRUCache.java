package S146_LRUCache;

import java.util.HashMap;

public class LRUCache {

	// 定義雙向鍊錶的結點類
	private static class Node {

		int key, value;
		Node prev, next;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private final int capacity; //LRU Cache的容量
	private final HashMap<Integer, Node> map; // 使用hashMap快速查找節點
	private final Node head, tail; // 虛擬頭尾節點

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.head = new Node(0, 0);
		this.tail = new Node(0, 0);
		this.head.next = tail;
		this.tail.prev = head;
	}

	/**
	 * 獲取對應key的值 沒有就回覆-1
	 */
	public int get(int key) {
		if (!map.containsKey(key))
			return -1;

		Node node = map.get(key); // 獲取節點
		remove(node); // 將節點從當前位置移除
		insertToFront(node); // 將節點插入到鏈表頭部
		return node.value;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			remove(map.get(key)); // 移除舊節點
		} else if (map.size() == capacity) {
			// 達到容量上限
			map.remove(tail.prev.key); // 從map中移除最少使用節點
			remove(tail.prev); // 移除尾部節點
		}
		// 創建新節點並放入雙向鏈表和map
		Node node = new Node(key, value);
		insertToFront(node);
		map.put(key, node);
	}

	private void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void insertToFront(Node node) {
		// 節點插入頭部
		node.next = head.next;
		node.prev = head;
		// 原頭部節點後移
		head.next.prev = node;
		head.next = node;
	}
}
