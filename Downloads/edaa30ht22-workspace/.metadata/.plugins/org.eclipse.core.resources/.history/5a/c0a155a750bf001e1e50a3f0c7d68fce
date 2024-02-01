// NOT TO BE PUBLISHED ON GITHUB. DO NOT SHARE LAB SOLUTIONS.
package lab4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/** Helper class for the priority queue in Dijkstras algorithm. */
class PQElement {
  int node;
  int distance;

  public PQElement(int node, int dist) {
    this.node = node;
    this.distance = dist;
  }
}

public class Lab4 {
  /**
   * Computes the shortest distance between start and end in the graph g using Dijkstra's
   * algorithm.
   * This version handles only graphs with integer edge distances.
   * @param g a graph with distance information attached to the edges
   * @param start start vertex
   * @param end end vertex
   * @return shortest distance between start and end
   */
  public static int distance(DistanceGraph g, int start, int end) {
    // Comparator för att hålla kön sorterad på avstånd:
    Comparator<PQElement> cmp = Comparator.comparingInt(e -> e.distance);
    PriorityQueue<PQElement> queue = new PriorityQueue<>(cmp);
    queue.add(new PQElement(start, 0));
    // TODO(D2): slutför Dijkstras algoritm för att hitta kortaste avstånd start->end.
    return -1;
  }

  /**
   * Finds a shortest path between start and end in a graph g Dijkstra's
   * algorithm.
   * The graph can have any distance unit.
   * @param g a graph with distance information attached to the edges
   * @param start start vertex
   * @param end end vertex
   * @return a list containing the nodes on the shortest path from start to end
   */
  public static List<Integer> shortestPath(DistanceGraph g, int start, int end) {
    Comparator<PQElement> cmp = Comparator.comparingInt(e -> e.distance);
    PriorityQueue<PQElement> queue = new PriorityQueue<>(cmp);
    queue.add(new PQElement(start, 0));
    // TODO(D3): slutför algoritmen och returnera vägen från start till end.
    // T.ex. om kortaste vägen mellan nod 0 och 10 är 0->5->2->10 ska listan [0,5,2,10] returneras.
    LinkedList<Integer> answer = new LinkedList<>();
    return answer;
  }
}
