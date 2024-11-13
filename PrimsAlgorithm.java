package java_pr;

import java.util.*;

public class PrimsAlgorithm {
    
    // Method to find the minimum spanning tree using Prim's algorithm
    public static void primsMST(int[][] graph) {
        int n = graph.length;
        
        // Array to store the minimum distance to add each node to MST
        int[] minDist = new int[n];
        // Array to keep track of the parent node for each node in the MST
        int[] parent = new int[n];
        // Boolean array to check if a node is included in the MST
        boolean[] visited = new boolean[n];
        
        // Initialize the minimum distances with infinity
        Arrays.fill(minDist, Integer.MAX_VALUE);
        // Start from the first node (index 0), so distance is 0
        minDist[0] = 0;
        parent[0] = -1; // Starting node has no parent
        
        // Loop to construct the MST with n - 1 edges
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum distance node that is not yet included in MST
            int u = findMinNode(minDist, visited);
            
            // Mark this node as included in the MST
            visited[u] = true;
            
            // Update distances of adjacent nodes
            for (int v = 0; v < n; v++) {
                // If there's an edge and the node is not visited
                // and the edge weight is less than the current minimum distance
                if (graph[u][v] != 0 && !visited[v] && graph[u][v] < minDist[v]) {
                    minDist[v] = graph[u][v];
                    parent[v] = u; // Update parent to keep track of MST edges
                }
            }
        }
        
        // Print the MST
        printMST(parent, graph);
    }
    
    // Helper method to find the node with the minimum distance that is not yet visited
    private static int findMinNode(int[] minDist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for (int v = 0; v < minDist.length; v++) {
            if (!visited[v] && minDist[v] < min) {
                min = minDist[v];
                minIndex = v;
            }
        }
        
        return minIndex;
    }
    
    // Helper method to print the MST
    private static void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        int totalWeight = 0;
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            totalWeight += graph[i][parent[i]];
        }
        System.out.println("Total Weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        // Graph represented as an adjacency matrix
        int[][] graph = {
            {0, 2, 0, 6},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            };

        primsMST(graph);
    }
}

