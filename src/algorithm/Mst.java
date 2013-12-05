package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class Mst{
    
    public static List<Edge> getMst(Graph graph){
        List<Edge> allEdge = graph.getAllEdge();
        List<Edge> result = new ArrayList<Edge>(graph.getVertexSum() - 1);
        List<Vertex>  inside = new LinkedList<Vertex>();
        List<Vertex>  outside = graph.getAllVertex();
        
        Collections.sort(allEdge);
        
        Iterator<Edge> ite = allEdge.iterator();
        while(ite.hasNext()){
            Edge e = ite.next();
            if(e.getOrigin().equals(e.getAim())){
                continue;
            }
            inside.add(e.getOrigin());
            inside.add(e.getAim());
            outside.remove(e.getOrigin());
            outside.remove(e.getAim());
            result.add(e);
            break;
        }
        
        while(!outside.isEmpty()){
            int presize = outside.size();
            Iterator<Edge> it = allEdge.iterator();
            while(it.hasNext()){
                Edge edge = it.next();
                if(inside.contains(edge.getOrigin()) && outside.contains(edge.getAim())){
                    inside.add(edge.getAim());
                    outside.remove(edge.getAim());
                    result.add(edge);
                    break;
                }
                else if(inside.contains(edge.getAim()) && outside.contains(edge.getOrigin())){
                    inside.add(edge.getOrigin());
                    outside.remove(edge.getOrigin());
                    result.add(edge);
                    break;
                }         
            }
            if(presize == outside.size()){//no mst
                return null;
            }
        }
        return result;
    }
}
