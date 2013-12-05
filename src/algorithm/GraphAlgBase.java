package algorithm;

import graph.Graph;
import graph.Weight;

public class GraphAlgBase {

    Weight  graph[][];
    Graph   base;
    public GraphAlgBase() {
        super();
        this.graph = null;
        this.base = null;
        // TODO Auto-generated constructor stub
    }
    public GraphAlgBase(Graph graph){
        this.init(graph);
    }
    public boolean init(Graph graph){
        this.graph = graph.toVector();
        this.base = graph;
        return true;
    }
}
