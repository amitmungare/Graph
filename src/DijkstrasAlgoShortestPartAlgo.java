import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


//O(E+ElogV)
public class DijkstrasAlgoShortestPartAlgo {

    public static void main(String[] args) {

        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

        boolean[] vis = new boolean[v];
        int[] dist = new int[v];

        for(int i=1; i<v; i++){
            dist[i]=Integer.MAX_VALUE;
        }

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dijkstrasAlgo(graph, vis, dist);
            }
        }

        for (int i=0; i<v; i++){
            System.out.println("0 -> "+i+" - "+dist[i]);
        }
    }

    public static void dijkstrasAlgo(ArrayList<Edge>[] graph, boolean[] vis, int[] dist){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));

        while (!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node]=true;
                for (int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    int u=e.src;
                    int v=e.dest;
                    if(dist[u]+e.weight < dist[v]){
                        dist[v]=dist[u]+e.weight;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,5,5));
        graph[4].add(new Edge(4,3,2));

    }

}
