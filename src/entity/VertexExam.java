package entity;

import graph.Vertex;

public class VertexExam implements Vertex{
    int id;
    int identity;
    public VertexExam(int identity) {
        super();
        this.identity = identity;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if(!this.getClass().equals(obj.getClass())){
            return false;
        }
        return this.id == ((VertexExam)obj).id;
    }

    @Override
    public String toString() {
        return "[Vertex:"+this.id+"]";
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
    
}
