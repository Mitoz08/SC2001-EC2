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
        boolean[] visited = new boolean[list.getMaxVertex()];
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

            if (visited[curNode]) continue; // If vertex already checked, skip. Basically ignoring duplicate
            visited[curNode] = true;

            ListNode node = list.getAdjacencyList(curNode).getHead();
            while (node != null){ //Stop until there is no more neighbours

                int neighbor = node.tVertex;
                int curWeight = node.weight;

                if (visited[neighbor]) { // If shortest distance is already found there is no need to check again
                    node = node.nextNode;
                    continue;
                }

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
        boolean[] visited = new boolean[matrix.getMaxVertex()];
        for (int i=0; i< matrix.getMaxVertex(); i++){
            dis[i] = Integer.MAX_VALUE; //Assign MAX INTEGER
        }
        dis[source] = 0; //INITIALISE distance of source vertex
        ArrayList<Pair> pq = new ArrayList<>(); //Using a sorted list to add a 2-tuple (initial vertex, Weight of edge)
        pq.add(new Pair(source, 0)); //"Enqueue" into a priority queue
        while (!pq.isEmpty()){
            Pair curPair = pq.remove(pq.size()-1); //remove the element from the top of the priority queue, we arrange the array in descending order so that we can remove the shortest distance in constant time
            int curNode = curPair.node;
            int weight  = curPair.weight;

            if (visited[curNode]) continue; // If vertex already checked, skip. Basically ignoring duplicate
            visited[curNode] = true;

            for (int l=0; l< matrix.getMaxVertex(); l++){

                if (visited[l]) continue;   // If shortest distance is already found there is no need to check again
                                            // Ignores edge (l,l) too as set to true previously

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
        // Find the correct position to insert the new pair, we want to sort it in DESCENDING ORDER
        while (i < pq.size() && pq.get(i).weight > newPair.weight) {
            i++;
        }
        // Insert the new pair at the correct position
        pq.add(i, newPair); //basic inserting of element into an array, inserts the new element and shifts everything to the right
    }
}
