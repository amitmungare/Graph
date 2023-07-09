import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,1));
    }



    public static void main(String[] args) {

        int v=6;
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

        boolean[] check = new boolean[v];
        Stack<Integer> s = new Stack<>();

        for (int i=0; i<v; i++){
            if(!check[i]){
                topologicalSort(graph, i, check,s);
            }
        }

        while (!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }

    }

    private static void topologicalSort(ArrayList<Edge>[] graph, int curr, boolean[] check, Stack<Integer> s) {

        check[curr]=true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!check[e.dest]) topologicalSort(graph, e.dest, check, s);
        }
        s.push(curr);
    }

}
