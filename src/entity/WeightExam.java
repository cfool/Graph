package entity;

import graph.Weight;

public class WeightExam implements Weight{
    int weight;
    private static int INFINITY = Integer.MAX_VALUE;
    private static int ZERO = 0;
    
    public WeightExam(int weight) {
        super();
        this.weight = weight;
    }

    @Override
    public int compareTo(Weight o) {
        return this.weight - ((WeightExam)o).weight;
    }


    @Override
    public boolean equals(Object obj) {
        if(!this.getClass().equals(obj.getClass())){
            return false;
        }
        return this.weight == ((WeightExam)obj).weight;
    }


    @Override
    public String toString() {
        return "[Weight:"+this.weight+"]";
    }


    @Override
    public Weight getInfinity() {
        return new WeightExam(INFINITY);
    }

    @Override
    public Weight add(Weight w) {
        if(!w.getClass().equals(this.getClass())) return null;
        return new WeightExam(this.weight + ((WeightExam)w).weight);
    }

    @Override
    public boolean append(Weight w) {
        if(!w.getClass().equals(this.getClass())) return false;
        this.weight += ((WeightExam)w).weight;
        return true;
    }

    @Override
    public Weight getZero() {
        return new WeightExam(ZERO);
    }        
}
