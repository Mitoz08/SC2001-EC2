import AdjacencyMatrix.AdjacencyMatrix;
import GraphCreation.GraphGenerator;
import AdjacencyList.AdjacencyList;
import Dijkstra.Dijkstra;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        for (int maxVertex=5; maxVertex<=5; maxVertex+=5) {
            for (int repeat = 1; repeat <= 20; repeat++) {
                AdjacencyList list = new AdjacencyList(maxVertex);
                AdjacencyMatrix matrix = new AdjacencyMatrix(maxVertex);
                GraphGenerator.Generate(maxVertex, 2*maxVertex, list, matrix);
                Dijkstra test = new Dijkstra();
                int[] array = test.Dijkstra(list,0);
                System.out.println(Arrays.toString(array));

            }
        }
    }
}
