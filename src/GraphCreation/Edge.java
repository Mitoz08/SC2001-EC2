package GraphCreation;

public class Edge {

    // Private attributes
    private int vertex1;
    private int vertex2;
    private int weight;

    // Constructors

    public Edge(int vertex1, int vertex2,int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    // Getter

    public int getVertex1() { return vertex1; }
    public int getVertex2() { return vertex2; }
    public int getWeight() { return weight; }

    // Setter

    public void setVertex1(int vertex1) { this.vertex1 = vertex1;}
    public void setVertex2(int vertex2) { this.vertex2 = vertex2;}
    public void setWeight(int weight) { this.weight = weight;}
}
