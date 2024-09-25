import GraphCreation.GraphGenerator;
import GraphCreation.AdjacencyList.AdjacencyList;

public class Main {
    public static void main(String[] args) {
        AdjacencyList list = new AdjacencyList(5);
        GraphGenerator.Generate(5,7,list);
        list.print();
    }
}