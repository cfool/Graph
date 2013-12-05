package entity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import graph.Weight;

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
    public Vertex getVertexById(int id) {
        Iterator<Vertex> it = this.vertexs.iterator();
        while(it.hasNext()){
            Vertex v = it.next();
            if(v.getId() == id){
                return v;
            }
        }
        return null;
    }
    

    @Override
    public Edge getEdge(int origin, int aim) {
        Iterator<Edge> it = this.edges.iterator();
        while(it.hasNext()){
            Edge e = it.next();
            if(e.getOrigin().getId() == origin && e.getAim().getId() == aim){
                return e;
            }
        }
        
        return null;
    }

    @Override
    public Edge getEdge(Vertex origin, Vertex aim) {
        return this.getEdge(origin.getId(), aim.getId());
    }

    @Override
    public boolean isNeighbor(Vertex origin, Vertex aim) {
        if(null != this.getEdge(origin.getId(), aim.getId())){
            return true;
        }
        return false;
    }

    @Override
    public Weight[][] toVector() {
        int size = this.vertexs.size();
        Weight result[][] = new Weight[size][size];
        for(int i = 0; i < size; ++i)
            for(int j = 0; j < size; ++j){
                Edge e = this.getEdge(i, j);
                if(e == null){
                    result[i][j] = null;
                }else{
                    result[i][j] = e.getWeight();
                }                
            }
        return result;
    }

    @Override
    public Weight getEdgeWeight(Edge e) {
        if(this.edges.contains(e)){
            return e.getWeight();
        }
        return null;
    }

    @Override
    public Weight getEdgeWeight(Vertex origin, Vertex aim) {
        Edge e = this.getEdge(origin, aim);
        if(null == e){
            return null;
        }
        return e.getWeight();
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
        v.setId(this.vertexs.size());
        return this.vertexs.add(v);
    }

    @Override
    public boolean addEdge(Edge e) {
        if(this.edges.contains(e)) return false;
        if(!this.vertexs.contains(e.getOrigin())) return false;
        if(!this.vertexs.contains(e.getAim())) return false;
        
        return this.edges.add(e);
    }

}
