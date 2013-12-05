package entity;

import graph.Edge;
import graph.Vertex;
import graph.Weight;

public class EdgeExam implements Edge {
    WeightExam weight;
    VertexExam origin;
    VertexExam aim;
    
    public EdgeExam(VertexExam origin, VertexExam aim, WeightExam weight) {
        super();
        this.weight = weight;
        this.origin = origin;
        this.aim = aim;
    }
    
    public EdgeExam(int origin, int aim, int weight){
        this.weight = new WeightExam(weight);
        this.origin = new VertexExam(origin);
        this.aim = new VertexExam(aim);
    }
    
    
    
    @Override
    public boolean equals(Object obj) {
        if(!this.getClass().equals(obj.getClass())){
            return false;
        }
        EdgeExam edge = (EdgeExam)obj;
        return this.weight.equals(edge.weight) && this.origin.equals(edge.origin) && this.aim.equals(edge.aim);
    }

    @Override
    public String toString() {
        return "Edge: "+this.origin.toString()+" -> "+this.aim.toString()+":"+this.weight.toString();
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight.compareTo(o.getWeight());
    }

    @Override
    public Vertex getOrigin() {
        return this.origin;
    }

    @Override
    public Vertex getAim() {
        return this.aim;
    }

    @Override
    public Weight getWeight() {
        return this.weight;
    }

}
