package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[V];
        queue.add(0);
        vis[0] = true;
        while(!queue.isEmpty()) {
            Integer front = queue.poll();
            result.add(front);
            for(Integer node : adj.get(front)) {
                if(!vis[node]) {
                    queue.add(node);
                    vis[node] = true;
                }
            }
        }
        return result;
    }
}
