import java.util.ArrayList;

public class Main {

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,2,2));

        graph[1].add(new Edge(1,2,10));
        graph[1].add(new Edge(1,3,0));

        graph[2].add(new Edge(2,0,2));
        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,-1));

        graph[3].add(new Edge(3,1,0));
        graph[3].add(new Edge(3,2,-1));
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

        int v=4;
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);

        printGraph(graph);

    }
}