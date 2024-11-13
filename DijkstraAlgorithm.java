package java_pr;

import java.util.*;

public class DijkstraAlgorithm {
    
    
    public static void dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n]; 
        Arrays.fill(dist, Integer.MAX_VALUE); 
        dist[source] = 0; 
        
        boolean[] visited = new boolean[n]; 
        
        
        for (int count = 0; count < n - 1; count++) {

            int u = minDistance(dist, visited);
            visited[u] = true; 
            
            
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        
        
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + ": " + dist[i]);
        }
    }
    
    
    private static int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        
        return minIndex;
    }
    
    
    public static void main(String[] args) {
        
        int[][] graph = {
            {0, 1, 4, 0},
            {1, 0, 2, 6},
            {4, 2, 0, 3},
            {0, 6, 3, 0}
        };
        dijkstra(graph, 0); 
    }
}

