package entity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class GraphExam implements Graph{
    List<Vertex> vertexs;
    List<Edge>   edges;
    
    public GraphExam() {
        super();
        this.vertexs = new LinkedList<Vertex>();
        this.edges = new LinkedList<Edge>();
    }

    @Override
    public List<Vertex> getAllVertex() {
        return this.vertexs;
    }

    @Override
    public List<Edge> getAllEdge() {
        return this.edges;
    }

    @Override
    public int getVertexSum() {
        return this.vertexs.size();
    }

    @Override
    public int getEdgeSum() {
        return this.edges.size();
    }

    @Override
    public Vertex getVertexByIndex(int index) {
        if(index >= this.vertexs.size()){
            return null;
        }
        return this.vertexs.get(index);
    }
    
    @Override
    public Edge getEdge(Vertex origin, Vertex aim) {
        //return this.getEdge(origin.getId(), aim.getId());
        Iterator<Edge> it = this.edges.iterator();
        while(it.hasNext()){
            Edge e = it.next();
            if(e.getOrigin().equals(origin) && e.getAim().equals(aim)){
                return e;
            }
        }
        return null;
    }

    @Override
    public boolean isNeighbor(Vertex origin, Vertex aim) {
        if(null != this.getEdge(origin, aim)){
            return true;
        }
        return false;
    }

    @Override
    public Edge getMaxWeightEdge() {
        Edge e = this.edges.get(0);
        Iterator<Edge> it = this.edges.iterator();
        while(it.hasNext()){
            Edge tmp = it.next();
            if(tmp.compareTo(e) > 0){
                e = tmp;
            }
        }
        return e;
    }

    @Override
    public Edge getMinWeightEdge() {
        Edge e = this.edges.get(0);
        Iterator<Edge> it = this.edges.iterator();
        while(it.hasNext()){
            Edge tmp = it.next();
            if(tmp.compareTo(e) < 0){
                e = tmp;
            }
        }
        return e;
    }

    @Override
    public boolean addVertex(Vertex v) {
        if(this.vertexs.contains(v)) return false;
        return this.vertexs.add(v);
    }

    @Override
    public boolean addEdge(Edge e) {
        if(this.edges.contains(e)) return false;
        if(!this.vertexs.contains(e.getOrigin())) return false;
        if(!this.vertexs.contains(e.getAim())) return false;
        
        return this.edges.add(e);
    }

    @Override
    public int getIndexOfVertex(Vertex vertex) {
        return this.vertexs.indexOf(vertex);
    }

}
