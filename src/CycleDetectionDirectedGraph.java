import java.util.ArrayList;

public class CycleDetectionDirectedGraph {

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,0));
    }

    public static void main(String[] args) {

        int v=4;
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);

        boolean vis[] = new boolean[v];
        boolean rs[] = new boolean[v];

        boolean isCycle = false;
        for (int i=0; i<vis.length; i++){
            if(!vis[i])
                if(cycleDetection(graph, vis, i, rs)){
                    isCycle=true;
                    break;
                }
        }
        System.out.println(isCycle);

    }

    private static boolean cycleDetection(ArrayList<Edge>[] graph, boolean[] vis,int curr, boolean[] rs) {

        rs[curr]=true;
        vis[curr]=true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(rs[e.dest])return true;
            else if(!vis[e.dest]){
                if(cycleDetection(graph, vis, e.dest, rs))return true;
            }
        }
        rs[curr]=false;
        return false;
    }


}
