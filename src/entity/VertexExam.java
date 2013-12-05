package entity;

import graph.Vertex;

public class VertexExam implements Vertex{
    int identity;
    public VertexExam(int identity) {
        super();
        this.identity = identity;
    }

    @Override
    public boolean equals(Object obj) {
        if(!this.getClass().equals(obj.getClass())){
            return false;
        }
        return this.identity == ((VertexExam)obj).identity;
    }

    @Override
    public String toString() {
        return "[Vertex:"+this.identity+"]";
    }
}
