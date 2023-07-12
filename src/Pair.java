public class Pair implements Comparable<Pair>{
    int node;
    int dist;

    public Pair(int n, int d) {
        this.node = n;
        this.dist = d;
    }

    @Override
    public int compareTo(Pair p2){
        return this.dist - p2.dist;
    }
}
