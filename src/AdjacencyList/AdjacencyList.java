package AdjacencyList;

import GraphCreation.Edge;

public class AdjacencyList {

    // Private attributes

    private LinkedList[] List;
    private int maxVertex;
    private int numEdges;

    // Constructor

    public AdjacencyList(int maxVertex) {
        this.List = new LinkedList[maxVertex];
        for (int i = 0; i < maxVertex; i++) {
            this.List[i] = new LinkedList(i);
        }
        this.maxVertex = maxVertex;
        this.numEdges = 0;
    }

    // Getter

    public int getMaxVertex() {return maxVertex;}
    public int getNumEdges() {return numEdges;}

    // Method

    public void addEdge(Edge edge) {
        this.List[edge.getVertex1()].addNode(edge.getVertex2(),edge.getWeight());   // Adds both the direction
        this.List[edge.getVertex2()].addNode(edge.getVertex1(),edge.getWeight());   // Undirected graph
        numEdges++;
    }

    public int getWeight(int iVertex, int tVertex) {
        return this.List[iVertex].getWeight(tVertex);
    }

    public void print() {
        for (LinkedList ll: this.List) {
            ll.print();
        }
    }
}
