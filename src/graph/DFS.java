package graph;

import java.util.ArrayList;

public class DFS {
    private void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, ArrayList<Integer> result) {
        if(visited[i]) {
            return;
        }
        visited[i] = true;
        result.add(i);
        for(Integer node : adj.get(i)) {
            dfs(adj, node, visited, result);
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfs(adj, 0, visited, result);
        return result;
    }
}
