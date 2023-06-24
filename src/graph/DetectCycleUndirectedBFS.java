package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ParentChild {
    int child;
    int parent;
    ParentChild(int child, int parent) {
        this.child = child;
        this.parent = parent;
    }
}
public class DetectCycleUndirectedBFS {
    private static boolean hasCycle(List<List<Integer>> graph, int i, boolean[] vis) {
        Queue<ParentChild> queue = new LinkedList<>();
        queue.add(new ParentChild(i, -1));
        vis[i] = true;
        while(!queue.isEmpty()) {
            ParentChild parentChild = queue.poll();
            int child = parentChild.child;
            int parent = parentChild.parent;
            for(Integer node : graph.get(child)) {
                if(!vis[node]) {
                    queue.add(new ParentChild(node, child));
                } else if(parent != node) {
                    return true;
                }
            }
        }
        return false;
    }
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
        }
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; ++i) {
            if(!vis[i] && hasCycle(graph, i, vis)) return "Yes";
        }
        return "No";
    }
}
