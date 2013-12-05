package graph;

import java.util.List;

public interface Graph {
    public List<Vertex> getAllVertex();
    public List<Edge>   getAllEdge();
    
    public int getVertexSum();
    public int getEdgeSum();
    
    public Vertex getVertexByIndex(int index); //index must be less than Vertex sum
    public int getIndexOfVertex(Vertex vertex);
    
    //public Edge getEdge(int origin, int aim);
    public Edge getEdge(Vertex origin, Vertex aim);
    
    public boolean isNeighbor(Vertex origin, Vertex aim);

    public Edge   getMaxWeightEdge();
    public Edge   getMinWeightEdge();
    
    public boolean addVertex(Vertex v);
    public boolean addEdge(Edge e);
}
