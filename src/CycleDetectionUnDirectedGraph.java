import java.util.ArrayList;

public class CycleDetectionUnDirectedGraph {

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
//        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
//        graph[2].add(new Edge(2,1));
    }

    public static void main(String[] args) {

        int v=3;
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);

        boolean vis[] = new boolean[v];

        boolean isCycle = false;
        for (int i=0; i<vis.length; i++){
            if(!vis[i])
                if(cycleDetection(graph, vis, i,i)){
                    isCycle=true;
                    break;
                }
        }
        System.out.println(isCycle);

    }

    private static boolean cycleDetection(ArrayList<Edge>[] graph, boolean[] vis,int curr, int par) {

        vis[curr]=true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] && par!=e.dest)return true;
            else if(!vis[e.dest]){
                if(cycleDetection(graph, vis, e.dest, curr))return true;
            }
        }
        return false;
    }

}
