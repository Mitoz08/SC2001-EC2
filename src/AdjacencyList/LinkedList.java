package AdjacencyList;


class ListNode {
    public int tVertex;         // Terminal vertex
    public int weight;          // Weight of edge
    public ListNode nextNode;   // Next node

    public ListNode(int tVertex, int weight){
        this.tVertex = tVertex;
        this.weight = weight;
        this.nextNode = null;
    }
}

public class LinkedList {

    // Private attribute

    private int mainVertex;      // Initial vertex to identify the list
    private int numEdges;        // Current number of edges
    private ListNode head;       // Head node
    private ListNode tail;       // Tail node for quick adding

    // Constructor

    public LinkedList(int mainVertex) {
        this.mainVertex = mainVertex;
        this.numEdges = 0;
        this.head = null;
        this.tail = null;
    }

    // Getter

    public int getMainVertex() {return mainVertex;}
    public int getNumEdges() {return numEdges;}

    // Methods

    public void addNode(int tVertex, int weight) {
        ListNode add = new ListNode(tVertex,weight);
        if (head == null){
            head = add;
            tail = add;
        } else {
            tail.nextNode = add;
            tail = tail.nextNode;
        }
        numEdges++;
    }

    public int getWeight(int tVertex) {
        ListNode cur = head;
        while (cur != null){
            if (cur.tVertex == tVertex) return cur.weight;
            cur = cur.nextNode;
        }
        return -1; // Return -1 if not found
    }

    public void print() {
        ListNode cur = head;

        System.out.printf("Vertex %d: ",this.mainVertex);
        while (cur != null){
            System.out.printf("(%d, %d) ",cur.tVertex,cur.weight);
            cur = cur.nextNode;
            if (cur == null) break;
            System.out.print("--> ");
        }
        System.out.println();
    }

}
