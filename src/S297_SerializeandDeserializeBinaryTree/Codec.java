package S297_SerializeandDeserializeBinaryTree;

import java.util.Arrays;
import java.util.LinkedList;

public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serializeHelper(root, sb);
		return sb.toString();
	}

	private void serializeHelper(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("N").append(",");
			return;
		}

		// 前序遍歷 中 -> 左 -> 右
		sb.append(node.val).append(",");
		serializeHelper(node.left, sb);
		serializeHelper(node.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
		return deserializeHelper(nodes);
	}

	private TreeNode deserializeHelper(LinkedList<String> nodes) {
		// 檢查節點是否有直
		if (nodes.isEmpty()) {
			return null;
		}

		// 檢查節點是否為N
		String value = nodes.poll();
		if (value.equals("N")) {
			return null;
		}

		// 遞歸進行前序反序列化
		TreeNode node = new TreeNode(Integer.parseInt(value));
		node.left = deserializeHelper(nodes);
		node.right = deserializeHelper(nodes);
		return node;
	}
}
