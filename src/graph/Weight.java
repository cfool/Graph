package graph;

public interface Weight extends Comparable<Weight>{
    public Weight getInfinity();
    public Weight getZero();
    public Weight add(Weight w);
    public boolean append(Weight w);
}
