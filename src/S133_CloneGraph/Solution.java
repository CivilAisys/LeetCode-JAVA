package S133_CloneGraph;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Node, Node> visited = new HashMap<>();

    /**
     * 使用 map來記錄已經複製過的節點 並使用dfs
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // 節點已經被訪問過  直接返回克隆節點
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val); // 創建新的節點
        visited.put(node, cloneNode); // 加入到map中

        // 遍歷所有鄰居
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}
