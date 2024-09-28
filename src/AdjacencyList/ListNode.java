package AdjacencyList;

public class ListNode {
    public int tVertex;         // Terminal vertex
    public int weight;          // Weight of edge
    public ListNode nextNode;   // Next node

    public ListNode(int tVertex, int weight){
        this.tVertex = tVertex;
        this.weight = weight;
        this.nextNode = null;
    }
    public ListNode(){

    }
}
