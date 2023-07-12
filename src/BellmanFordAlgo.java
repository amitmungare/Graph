import java.util.ArrayList;

public class BellmanFordAlgo {

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1, 2));
        graph[0].add(new Edge(0,2, 4));

        graph[1].add(new Edge(1,2, -4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1, -1));
    }

    public static void main(String[] args) {

        int v=5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        int dist[] = new int[v];
        for(int i=1; i<v; i++){
            dist[i]=Integer.MAX_VALUE;
        }

        bellmanFordAlgo(graph, dist, v);
    }

    private static void bellmanFordAlgo(ArrayList<Edge>[] graph, int[] dist, int vv) {

        for(int k=0; k<vv-1; k++){
            for(int i=0; i<vv; i++){
                for(int j=0; j<graph[i].size(); j++){
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v= e.dest;
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+e.weight<dist[v]){
                        dist[v]=dist[u]+e.weight;
                    }
                }
            }
        }

//        -ve weight cycle (same as the above code)
        for(int i=0; i<vv; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                int u = e.src;
                int v= e.dest;
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+e.weight<dist[v]){
                    System.out.println("-ve weight cycle");
                }
            }
        }

        for (int i=0; i< dist.length; i++){
            System.out.print(dist[i]+" ");
        }

    }

}
