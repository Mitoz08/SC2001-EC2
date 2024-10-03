package GraphCreation;

import AdjacencyList.AdjacencyList;
import AdjacencyMatrix.AdjacencyMatrix;

import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentNavigableMap;

public class GraphGenerator {


    public static int Generate(int Vertices, AdjacencyList AdjList, AdjacencyMatrix AdjMatrix) {
        // Add Class Object to the parameter to run addEdge Function
        int totalEdge = 0;
        for (int i = 0; i < Vertices; i++) {
            for (int j = i + 1; j < Vertices; j++) {
                // Create GraphCreation.Edge

                Edge newEdge = new Edge(i, j, randomWeight()); // Generate random weight

                // Run addEdge function on both class
                AdjList.addEdge(newEdge);
                AdjMatrix.addEdge(newEdge);
                totalEdge++;
            }
        }
        return totalEdge;
    }

    public static int Generate(int Vertices, int Edges, AdjacencyList AdjList, AdjacencyMatrix AdjMatrix) {
        // Add Class Object to the parameter to run addEdge Function

        double probability = (double) Edges / (double) (Vertices * (Vertices - 1) / 2);
        int totalEdge = 0;

        Edge newEdge;

        for (int i = 1; i < Vertices; i++) { // Creating a MST
            int randomVertex = (int) (Math.random() * i);
            newEdge = new Edge(i,randomVertex,randomWeight());

            AdjList.addEdge(newEdge);
            AdjMatrix.addEdge(newEdge);

            totalEdge++;
        }

        while (totalEdge < Edges) {
            for ( int i = 0; i < Vertices; i++){
                if (totalEdge >= Edges) break;
                for ( int j = i+1; j < Vertices; j++){
                    if (totalEdge >= Edges) break;
                    if (!(AdjMatrix.getWeight(i,j) < 0)) continue;
                    if (Math.random() < probability){
                        // Create GraphCreation.Edge

                        newEdge = new Edge(i,j,randomWeight()); // Generate random weight

                        // Run addEdge function on both class
                        AdjList.addEdge(newEdge);
                        AdjMatrix.addEdge(newEdge);

                        totalEdge++;
                    }
                }
            }
        }

        // Check for isolated vertex

//        for ( int i = 0; i < Vertices; i++) {
//            if (edgeCount[i] == 0) {
//                // Add a random edge so that it is not isolated
//                int terminalVertex;
//                do {
//                    terminalVertex = (int) (Math.random() * Vertices);
//                } while (terminalVertex == i);
//
//                Edge newEdge = new Edge(i,terminalVertex,randomWeight()); // Generate random weight
//
//                // Run addEdge function on both class
//
//                AdjList.addEdge(newEdge);
//                AdjMatrix.addEdge(newEdge);
//
//                edgeCount[i]++;
//                edgeCount[terminalVertex]++;
//                totalEdge++;
//            }
//        }
        return totalEdge;
    }

    private static int randomWeight(){
        return 1 + (int)(Math.random()*999);
    }
}
