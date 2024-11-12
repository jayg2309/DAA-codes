package java_pr;

public class FloydWarshall {
    final static int INF = 99999;
    public static void printSol(int[][] dist, int V){
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(dist[i][j]==INF){
                    System.out.print("INF ");
                }else{
                    System.out.print(dist[i][j]+ " ");
                }
            }
            System.out.println();
        }
    }

    public static void floydwarshall(int[][] dist, int V){
        for(int k=0;k<V;k++){
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    if(dist[i][j]> dist[i][k] + dist[k][j]){
                        dist[i][j]=dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        printSol(dist,V);
    }
    public static void main(String[] args){
        int V = 3;
        int[][] graph = {
            {0, 2,3},
            {1,0,INF},
            {1,INF,0}
        };

        floydwarshall(graph,V);
    }
}

