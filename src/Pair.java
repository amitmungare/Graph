public class Pair implements Comparable<Pair>{
    int node;
    int dist;

    public Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    @Override
    public int compareTo(Pair p2){
        return this.dist - p2.dist;
    }
}
