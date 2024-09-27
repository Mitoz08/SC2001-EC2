import AdjacencyMatrix.AdjacencyMatrix;
import GraphCreation.GraphGenerator;
import AdjacencyList.AdjacencyList;

public class Main {
    public static void main(String[] args) {
        AdjacencyList list = new AdjacencyList(5);
        AdjacencyMatrix matrix = new AdjacencyMatrix(5);
        GraphGenerator.Generate(5,7,list,matrix);
        list.print();
        matrix.print();;
    }
}
