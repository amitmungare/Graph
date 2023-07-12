import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test {



    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }

    public static void printGraph(ArrayList<Edge> graph[]){
        for (int g=0; g< graph.length; g++){
            System.out.print(g+" : ");
            for(int i=0; i<graph[g].size(); i++){
                Edge e = graph[g].get(i);
                System.out.print(e.dest+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int v=7;
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

//        printGraph(graph);

        boolean[] vis = new boolean[v];

//        for(int i=0; i<v; i++){
//            allPaths(graph, vis, 0, "0",5);
//        }

    }

    private static void allPaths(ArrayList<Edge>[] graph, boolean[] vis, int curr, String path, int trg) {

        if(curr==trg){
            System.out.println(path);
            return;
        }
        for(int i=0; i<graph[curr].size(); i++){
            vis[curr]=true;
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) allPaths(graph, vis, e.dest, path+" "+e.dest, trg);
            vis[curr]=false;
        }

    }

    private static void bfs(ArrayList<Edge>[] graph, boolean[] vis, int ii) {

        Queue<Integer> q = new LinkedList<>();
        q.add(ii);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }


    private static void dfs(ArrayList<Edge>[] graph, boolean[] vis, int curr) {
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) dfs(graph, vis, e.dest);
        }
    }


}
