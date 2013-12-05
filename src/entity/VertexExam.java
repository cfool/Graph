package entity;

import graph.Vertex;

public class VertexExam implements Vertex{
    int id;
    
    public VertexExam(int id) {
        super();
        this.id = id;
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
    
}
