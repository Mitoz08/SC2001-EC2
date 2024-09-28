import AdjacencyMatrix.AdjacencyMatrix;
import GraphCreation.GraphGenerator;
import AdjacencyList.AdjacencyList;
import Dijkstra.Dijkstra;

public class Main {
    public static void main(String[] args) {
        for (int i=1; i<=5; i++) {
            AdjacencyList list = new AdjacencyList(5);
            AdjacencyMatrix matrix = new AdjacencyMatrix(5);
            GraphGenerator.Generate(5, 7, list, matrix);
            Dijkstra test = new Dijkstra();
            int[] array = new int[5];
            long startTime = System.nanoTime();
            array = test.Dijkstra(list, 0);
            long endTime = System.nanoTime();
            long timeTaken = (endTime - startTime) / 1000;
            matrix.print();
            System.out.println("The time taken for Dijkstra is " + timeTaken + " microseconds");
        }
    }
}
