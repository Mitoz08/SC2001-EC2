package Dijkstra;

import AdjacencyList.AdjacencyList;
import AdjacencyList.LinkedList;
import AdjacencyList.ListNode;
import AdjacencyMatrix.AdjacencyMatrix;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class Dijkstra {

    public int[] Dijkstra(AdjacencyList list, int source){
        int[] dis = new int[list.getMaxVertex()];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        for (int i=0; i<list.getMaxVertex(); i++){
            dis[i] = Integer.MAX_VALUE; //Assign MAX INTEGER
        }
        dis[source] = 0;
        pq.add(new Pair(source,0));
        while (!pq.isEmpty()){
            Pair curPair = pq.remove();
            int curNode = curPair.node;
            int weight = curPair.weight;

            LinkedList temp = new LinkedList();
            temp = list.getAdjacencyList(curNode); //Finding initial vertex

            ListNode node = new ListNode();
            node = temp.getHead();
            while (node != null){ //Stop until there is no more neighbours
                int neighbor = node.tVertex;
                int curWeight = node.weight;
                if (weight + curWeight < dis[neighbor]){
                    dis[neighbor] = weight + curWeight;
                    pq.add(new Pair(neighbor, dis[neighbor]));
                }
                node = node.nextNode; //Finding the next neighbour
            }

        }
        return dis;
    }
    public int[] Dijkstra(AdjacencyMatrix matrix, int source){
        int[] dis = new int[matrix.getMaxVertex()];
        for (int i=0; i< matrix.getMaxVertex(); i++){
            dis[i] = Integer.MAX_VALUE; //Assign MAX INTEGER
        }
        dis[source] = 0; //INITIALISE distance of source vertex
        ArrayList<Pair> pq = new ArrayList<>(); //Using a sorted list to add a 2-tuple (initial vertex, Weight of edge)
        pq.add(new Pair(source, 0)); //"Enqueue" into a priority queue
        while (!pq.isEmpty()){
            Pair curPair = pq.remove(0); //remove the element from the top of the priority queue
            int curNode = curPair.node;
            int weight  = curPair.weight;

            for (int l=0; l< matrix.getMaxVertex(); l++){
                int curWeight = matrix.getWeight(curNode,l);
                if (weight + curWeight < dis[l] && curWeight != -1){ //check if there is an edge and if going through that edge is indeed shorter
                    dis[l] = weight + curWeight;
                    add(pq, new Pair(l,dis[l])); //"Enqueue" into a priority queue while by inserting it in ascending order
                }
            }

        }
        return dis;
    }
    private void add(ArrayList<Pair> pq, Pair newPair) {
        int i = 0;
        // Find the correct position to insert the new pair
        while (i < pq.size() && pq.get(i).weight < newPair.weight) {
            i++;
        }
        // Insert the new pair at the correct position
        pq.add(i, newPair); //basic inserting of element into an array, inserts the new element and shifts everything to the right
    }
}
