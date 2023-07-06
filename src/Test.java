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
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);

        boolean check[] = new boolean[v];

        allPaths(graph, check, "0", 0, 5);

    }

    private static void allPaths(ArrayList<Edge>[] graph, boolean[] check, String path, int curr, int tar) {

        if(curr==tar){
            System.out.println(path);
            return;
        }

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(check[e.dest]==false){
                check[curr]=true;
                allPaths(graph, check, path+" "+e.dest, e.dest, tar);
                check[curr]=false;
            }
        }

    }


}
