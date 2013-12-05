package algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import graph.Weight;

public class Dijkstra {
    Graph graph;
    Weight vGraph[][];
    Weight maxWeight;
    Weight zeroWeight;
    
    public Dijkstra(Graph graph) throws Exception{
        if(!initGraph(graph))
            throw new Exception();
    }
    
    private boolean initGraph(Graph graph){
        this.graph = graph;
        this.maxWeight = null;
        this.zeroWeight = null;
        return initVGraph(graph);
    }
    
    private boolean initVGraph(Graph graph){
        int vertexsum = graph.getVertexSum();
        vGraph = new Weight[vertexsum][vertexsum];
        
        for(int i = 0; i < vertexsum; ++i)
            for(int j = 0; j < vertexsum; ++j)
                vGraph[i][j] = null;
        
        Iterator<Edge> it = graph.getAllEdge().iterator();
        while(it.hasNext()){
            Edge e = it.next();
            int origin = graph.getIndexOfVertex(e.getOrigin());
            int aim = graph.getIndexOfVertex(e.getAim());
            vGraph[origin][aim] = e.getWeight();
            if(null == this.maxWeight) this.maxWeight = e.getWeight().getInfinity();
            if(null == this.zeroWeight) this.zeroWeight = e.getWeight().getZero();
        }
        
        return true;
    }
    
    public List<Vertex> getShortestPath(Vertex origin, Vertex aim){
        if(this.zeroWeight == null){ // if zeroWeight == null, there is no edge.
            return null;
        }
        List<Vertex> result = new LinkedList<Vertex>();

        Weight dist[] = new Weight[this.vGraph.length];
        int prev[] = new int[this.vGraph.length];
        dijkstra(origin, dist, prev);
        
        int i = this.graph.getIndexOfVertex(aim);
        int oriIdx = this.graph.getIndexOfVertex(origin);
        while(i != oriIdx){
            result.add(0,graph.getVertexByIndex(i));
            i = prev[i];
        }
        result.add(0, origin);
        return result;
    }
    
    public boolean dijkstra(Vertex origin, Weight[] dist, int[] prev) {
        if(this.zeroWeight == null) return false;
        int v = graph.getIndexOfVertex(origin);
        if (v < 0) return false;
        int n = graph.getVertexSum();
        boolean[] s = new boolean[n];
        // 初始化
        for (int i = 0; i < n; i++) {
            s[i] = false;
            if(vGraph[v][i] == null){
                dist[i] = this.maxWeight;
                prev[i] = -1;
            }else{
                dist[i] = vGraph[v][i];
                prev[i] = v;
            }
        }
        dist[v] = this.zeroWeight;
        s[v] = true;
        
        //
        for (int i = 0; i < n; i++) {
            Weight temp = this.maxWeight;
            int u = v;
            for (int j = 0; j < n; j++) {
                if ((!s[j]) && (dist[j].compareTo(temp) < 0)) {
                    u = j;
                    temp = dist[j];
                }
            }
            s[u] = true; // 找到了第一个并入S的节点
            for (int j = 0; j < n; j++) {
                if ((!s[j]) && (vGraph[u][j] != null)) {
                    Weight newWeight = dist[u].add(vGraph[u][j]);
                    if (newWeight.compareTo(dist[j]) < 0) {
                        dist[j] = newWeight;
                        prev[j] = u;
                    }
                }
            }
        }
        return true;
    }
}
