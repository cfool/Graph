package graph;

import java.util.List;

public interface Graph {
    public List<Vertex> getAllVertex();
    public List<Edge>   getAllEdge();
    
    public int getVertexSum();
    public int getEdgeSum();
    
    public Vertex getVertexById(int id);
    
    public Edge getEdge(int origin, int aim);
    public Edge getEdge(Vertex origin, Vertex aim);
    
    public boolean isNeighbor(Vertex origin, Vertex aim);
    public Weight[][] toVector();
    

    public Weight getEdgeWeight(Edge e);
    public Weight getEdgeWeight(Vertex origin, Vertex aim);
    public Edge   getMaxWeightEdge();
    public Edge   getMinWeightEdge();
    
    //when add a vertex, graph should set a id for this vertex.
    //the id should start from 0.
    public boolean addVertex(Vertex v);
    public boolean addEdge(Edge e);
}
