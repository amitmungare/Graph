import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgoMST {

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1, 10));
        graph[0].add(new Edge(0,3, 30));
        graph[0].add(new Edge(0,2, 15));

        graph[1].add(new Edge(1,0, 10));
        graph[1].add(new Edge(1,0, 10));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
    }

    public static void main(String[] args) {

        int v=4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        primsAlgo(graph, v);

    }

    //ElogE
    private static void primsAlgo(ArrayList<Edge>[] graph, int vv) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();  //non-mst
        boolean vis[] = new boolean[vv]; //mst
        pq.add(new Pair(0,0));
        int cost=0;

        while (!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node]=true;
                cost+= curr.dist;//cost

                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    if(!vis[e.dest]){
                        pq.add(new Pair(e.dest, e.weight));
                    }
                }
            }
        }

        System.out.println("min cost for MST- "+cost);
    }

}
