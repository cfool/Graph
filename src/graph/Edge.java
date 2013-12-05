package graph;

public interface Edge extends Comparable<Edge>{
    public Vertex getOrigin();
    public Vertex getAim();
    public Weight getWeight();
}
