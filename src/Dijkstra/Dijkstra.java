package Dijkstra;

import AdjacencyList.AdjacencyList;
import AdjacencyList.LinkedList;
import AdjacencyList.ListNode;
import AdjacencyMatrix.AdjacencyMatrix;
import java.util.PriorityQueue;


public class Dijkstra {

    public int[] Dijkstra(AdjacencyList list, int source){
        int[] dis = new int[list.getMaxVertex()];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        for (int i=0; i<list.getMaxVertex(); i++){
            dis[i] = 1001;
        }
        dis[source] = 0;
        pq.add(new Pair(source,0));
        while (!pq.isEmpty()){
            Pair curPair = pq.remove();
            int curNode = curPair.node;
            int weight = curPair.weight;

            LinkedList temp = new LinkedList();
            temp = list.getAdjacencyList(curNode);

            ListNode node = new ListNode();
            node = temp.getHead();
            while (node != null){
                int neighbor = node.tVertex;
                int curWeight = node.weight;
                if (weight + curWeight < dis[neighbor]){
                    dis[neighbor] = weight + curWeight;
                    pq.add(new Pair(neighbor, dis[neighbor]));
                }
                node = node.nextNode;
            }

        }
        return dis;
    }
    public int[] Dijkstra(AdjacencyMatrix matrix, int source){
        int[] dis = new int[matrix.getMaxVertex()];
        for (int i=0; i< matrix.getMaxVertex(); i++){
            dis[i] = 1001;
        }
        dis[source] = 0;


        return dis;
    }
}
