package graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleUndirectedDFS {
    private static boolean hasCycle(List<List<Integer>> graph, int i, int parent, boolean[] vis) {
        vis[i] = true;
        for(Integer node : graph.get(i)) {
            if(node == parent) continue;
            if(vis[node]) return true;
            if(hasCycle(graph, node, i, vis)) return true;
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
            if(!vis[i] && hasCycle(graph, i, -1,  vis)) return "Yes";
        }
        return "No";
    }
}
