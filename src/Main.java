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

        AdjacencyList list = new AdjacencyList(1);
        AdjacencyMatrix matrix = new AdjacencyMatrix(1);
        GraphGenerator.Generate(1,list, matrix);
        Dijkstra test = new Dijkstra();
        test.Dijkstra(list,0);
        test.Dijkstra(matrix,0);


        // Parameters
        int[] VertexParameter = new int[] {/* Start */ 1_000, /* End */ 10_000, /* Increment */ 100};
        int Repetition = 20;

        File csvFile;
        PrintWriter out;

//        csvFile = new File("Dijkstra.csv");
//        out = new PrintWriter(csvFile);
//
//        out.println("maxVertex, totalEdges, repeat, AdjacencyList, AdjacencyMatrix");
//
//
//        for (int maxVertex=VertexParameter[0]; maxVertex<=VertexParameter[1]; maxVertex+=VertexParameter[2]) {
//            long[] timeAverage = new long[2];
//            for (int repeat = 1; repeat <= Repetition; repeat++) {
//                long[] timeTaken = new long[2];
//                int[][] output = new int[2][maxVertex];
//                list = new AdjacencyList(maxVertex);
//                matrix = new AdjacencyMatrix(maxVertex);
//                int totalEdge = GraphGenerator.Generate(maxVertex, list, matrix);
//                test = new Dijkstra();
//
//                // Testing Adjacency List
//                timeTaken[0] = System.nanoTime();
//                output[0] = test.Dijkstra(list,0);
//                timeTaken[0] = (System.nanoTime() - timeTaken[0])/1000;
//                timeAverage[0] += timeTaken[0];
//
//                // Testing Adjacency Matrix
//                timeTaken[1] = System.nanoTime();
//                output[1] = test.Dijkstra(matrix,0);
//                timeTaken[1] = (System.nanoTime() - timeTaken[1])/1000;
//                timeAverage[1] += timeTaken[1];
//
//                // Checking answer
//                for (int i = 0; i < maxVertex; i++) {
//                    if (output[0][i] != output[1][i]) System.out.println("Different");
//                }
//
//                out.printf("%d, %d, %d, %d, %d", maxVertex, totalEdge , repeat, timeTaken[0],timeTaken[1]);
//                if (repeat != Repetition) out.println();
//            }
//            timeAverage[0] /= Repetition;
//            timeAverage[1] /= Repetition;
//            out.printf(",%d,%d\n",timeAverage[0],timeAverage[1]);
//            System.out.println("This is the " + maxVertex + " case" );
//        }
//        out.close();
//
//        csvFile = new File("Dijkstra1.csv");
//        out = new PrintWriter(csvFile);
//
//        out.println("maxVertex, totalEdges, repeat, AdjacencyList, AdjacencyMatrix");

        int maxVertex = 1000;
//        for (int numberOfEdges = 9500; numberOfEdges <= 499500; numberOfEdges += 10000){
//            long[] timeAverage = new long[2];
//            for (int repeat = 1; repeat <= Repetition; repeat++) {
//                long[] timeTaken = new long[2];
//                int[][] output = new int[2][maxVertex];
//                list = new AdjacencyList(maxVertex);
//                matrix = new AdjacencyMatrix(maxVertex);
//                int totalEdge = GraphGenerator.Generate(maxVertex, numberOfEdges, list, matrix);
//                test = new Dijkstra();
//
//                // Testing Adjacency List
//                timeTaken[0] = System.nanoTime();
//                output[0] = test.Dijkstra(list,0);
//                timeTaken[0] = (System.nanoTime() - timeTaken[0])/1000;
//                timeAverage[0] += timeTaken[0];
//
//                // Testing Adjacency Matrix
//                timeTaken[1] = System.nanoTime();
//                output[1] = test.Dijkstra(matrix,0);
//                timeTaken[1] = (System.nanoTime() - timeTaken[1])/1000;
//                timeAverage[1] += timeTaken[1];
//
//                // Checking answer
//                for (int i = 0; i < maxVertex; i++) {
//                    if (output[0][i] != output[1][i]) System.out.println("Different");
//                }
//
//                out.printf("%d, %d, %d, %d, %d", maxVertex, totalEdge , repeat, timeTaken[0],timeTaken[1]);
//                if (repeat != Repetition) out.println();
//            }
//            timeAverage[0] /= Repetition;
//            timeAverage[1] /= Repetition;
//            out.printf(",%d,%d\n",timeAverage[0],timeAverage[1]);
//            System.out.println("This is the " + maxVertex + " case" );
//        }
//
//        out.close();

        csvFile = new File("Dijkstra2.csv");
        out = new PrintWriter(csvFile);

        out.println("maxVertex, totalEdges, repeat, AdjacencyList, AdjacencyMatrix");

        maxVertex = 10000;
        for (int numberOfEdges = 995_000; numberOfEdges <= 49_995_000; numberOfEdges += 1_000_000){
            long[] timeAverage = new long[2];
            for (int repeat = 1; repeat <= Repetition; repeat++) {
                long[] timeTaken = new long[2];
                int[][] output = new int[2][maxVertex];
                list = new AdjacencyList(maxVertex);
                matrix = new AdjacencyMatrix(maxVertex);
                int totalEdge = GraphGenerator.Generate(maxVertex, numberOfEdges, list, matrix);
                test = new Dijkstra();

                // Testing Adjacency List
                timeTaken[0] = System.nanoTime();
                output[0] = test.Dijkstra(list,0);
                timeTaken[0] = (System.nanoTime() - timeTaken[0])/1000;
                timeAverage[0] += timeTaken[0];

                // Testing Adjacency Matrix
                timeTaken[1] = System.nanoTime();
                output[1] = test.Dijkstra(matrix,0);
                timeTaken[1] = (System.nanoTime() - timeTaken[1])/1000;
                timeAverage[1] += timeTaken[1];

                // Checking answer
                for (int i = 0; i < maxVertex; i++) {
                    if (output[0][i] != output[1][i]) System.out.println("Different");
                }

                out.printf("%d, %d, %d, %d, %d", maxVertex, totalEdge , repeat, timeTaken[0],timeTaken[1]);
                if (repeat != Repetition) out.println();
            }
            timeAverage[0] /= Repetition;
            timeAverage[1] /= Repetition;
            out.printf(",%d,%d\n",timeAverage[0],timeAverage[1]);
            System.out.println("    wThis is the " + maxVertex + " case " + numberOfEdges);
        }

        out.close();
    }
}
