package test;

import java.util.Iterator;
import java.util.List;

import algorithm.Dijkstra;
import algorithm.Mst;
import entity.EdgeExam;
import entity.GraphExam;
import entity.VertexExam;
import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class Test {
    public static void main(String[] args) {
        Graph g = new GraphExam();

        g.addVertex(new VertexExam(0));
        g.addVertex(new VertexExam(1));
        g.addVertex(new VertexExam(2));
        g.addVertex(new VertexExam(3));
        g.addVertex(new VertexExam(4));
        g.addVertex(new VertexExam(5));

        g.addEdge(new EdgeExam(0,1,6));
        g.addEdge(new EdgeExam(1,0,6));

        g.addEdge(new EdgeExam(0,2,3));
        g.addEdge(new EdgeExam(2,0,3));

        g.addEdge(new EdgeExam(1,2,2));
        g.addEdge(new EdgeExam(2,1,2));

        g.addEdge(new EdgeExam(1,3,5));
        g.addEdge(new EdgeExam(3,1,5));

        g.addEdge(new EdgeExam(2,3,3));
        g.addEdge(new EdgeExam(3,2,3));

        g.addEdge(new EdgeExam(3,4,2));
        g.addEdge(new EdgeExam(4,3,2));

        g.addEdge(new EdgeExam(2,4,4));
        g.addEdge(new EdgeExam(4,2,4));

        g.addEdge(new EdgeExam(3,5,3));
        g.addEdge(new EdgeExam(5,3,3));

        g.addEdge(new EdgeExam(4,5,5));
        g.addEdge(new EdgeExam(5,4,5));

        g.addEdge(new EdgeExam(0,0,0));
        g.addEdge(new EdgeExam(1,1,0));
        g.addEdge(new EdgeExam(2,2,0));
        g.addEdge(new EdgeExam(3,3,0));
        g.addEdge(new EdgeExam(4,4,0));
        g.addEdge(new EdgeExam(5,5,0));
        
        try{
            Dijkstra dij = new Dijkstra(g);
            List<Vertex> path = dij.getShortestPath(new VertexExam(0), new VertexExam(1));
            if(path == null){
                System.out.println("Error");
                return;
            }
            Iterator<Vertex> it = path.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
            
            List<Edge> mst = Mst.getMst(g);

            Iterator<Edge> it1 = mst.iterator();
            while(it1.hasNext()){
                System.out.println(it1.next());
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }    
}
