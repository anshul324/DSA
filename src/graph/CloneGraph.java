package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph {
    private void dfs(Node node, Node clone, Node[] vis) {
        vis[clone.val] = clone;
        for(Node neighbor : node.neighbors) {
            if(vis[neighbor.val] == null) {
                Node newNode = new Node(neighbor.val);
                clone.neighbors.add(newNode);
                dfs(neighbor, newNode, vis);
            } else {
                clone.neighbors.add(vis[neighbor.val]);
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node clone = new Node(node.val);
        Node[] vis = new Node[101];
        Arrays.fill(vis, null);
        dfs(node, clone, vis);
        return clone;
    }
}
