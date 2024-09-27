package AdjacencyMatrix;

import GraphCreation.Edge;

import java.util.Arrays;

public class AdjacencyMatrix {

    // Private attributes

    private int[][] Matrix;
    private int maxVertex;
    private int numEdges;

    // Constructor

    public AdjacencyMatrix(int maxVertex) {
        this.Matrix = new int[maxVertex][maxVertex];
        for (int[] list: this.Matrix){
            for (int i = 0; i < maxVertex; i++)
                list[i] = -1;
        }
        this.maxVertex = maxVertex;
        this.numEdges = 0;
    }

    // Getter

    public int getMaxVertex() {return maxVertex;}
    public int getNumEdges() {return numEdges;}

    // Method

    public void addEdge(Edge edge) {
        this.Matrix[edge.getVertex1()][edge.getVertex2()] = edge.getWeight();
        this.Matrix[edge.getVertex2()][edge.getVertex1()] = edge.getWeight();
        numEdges++;
    }

    public int getWeight(int iVertex, int tVertex) {
        return this.Matrix[iVertex][tVertex];
    }

    public void print() {
        for (int[] list : this.Matrix){
            System.out.println(Arrays.toString(list));
        }
    }
}
