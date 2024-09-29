import AdjacencyMatrix.AdjacencyMatrix;
import GraphCreation.GraphGenerator;
import AdjacencyList.AdjacencyList;
import Dijkstra.Dijkstra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File csvFile = new File("Dijkstra.csv");
        PrintWriter out = new PrintWriter(csvFile);

        out.println("maxVertex, repeat, timeTaken");

        for (int maxVertex=5; maxVertex<=10; maxVertex+=5) {
            for (int repeat = 1; repeat <= 10; repeat++) {
                AdjacencyList list = new AdjacencyList(maxVertex);
                AdjacencyMatrix matrix = new AdjacencyMatrix(maxVertex);
                GraphGenerator.Generate(maxVertex, 2*maxVertex, list, matrix);
                Dijkstra test = new Dijkstra();
                long startTime = System.nanoTime();
                test.Dijkstra(list,0);
                long endTime = System.nanoTime();
                long timeTaken = (endTime-startTime)/1000; //in microseconds
                out.printf("%d, %d, %d\n", maxVertex, repeat, timeTaken);
            }
        }
        out.close();
    }
}
