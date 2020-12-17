package com.practice.ds.graph;

import static java.lang.Integer.MAX_VALUE;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class KCoreOfGraph {

  public static void main(String[] args) throws FileNotFoundException {
    KGraph kGraph = new KGraph("kcore.txt", 3);
    //kGraph.bfs();
    System.out.println(kGraph.getDegreeMap());

    /*LNode ln = kGraph.getGraph().get(0);
    while (ln != null) {
      System.out.print(ln.getData() + ",");
      ln = ln.getNext();
    }*/
  }
}

class KGraph {

  private Map<Integer, LNode> graph;
  private Map<Integer, Integer> degreeMap;
  private Set<Integer> visited;
  private Pair pair = new Pair(0, MAX_VALUE);
  private int k;
  int min = MAX_VALUE;
  int deg = MAX_VALUE;

  public KGraph(String filName, int k) throws FileNotFoundException {
    Scanner sc = new Scanner(new File(filName));
    graph = new HashMap<>();
    degreeMap = new HashMap<>();
    visited = new HashSet<>();
    this.k = k;
    while (sc.hasNext()) {
      String[] s = sc.next().split(",");
      addEdge(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
      addEdge(Integer.parseInt(s[1]), Integer.parseInt(s[0]));
    }
  }

  private void addEdge(int src, int dest) {
    if (!graph.containsKey(src)) {
      graph.put(src, new LNode(dest));
    } else {
      graph.put(src, createLNode(graph.get(src), dest));
    }
    int d = 1;
    if (degreeMap.containsKey(src)) {
      d = degreeMap.get(src) + 1;
    }
    degreeMap.put(src, d);
  }

  private void getMinDegNode() {
    for (Map.Entry<Integer, Integer> map : degreeMap.entrySet()) {
      if (deg > map.getValue()) {
        deg = map.getValue();
        min = map.getKey();
      }
    }
  }

  public void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    getMinDegNode();
    queue.add(min);
    visited.add(min);

    while (!queue.isEmpty()) {
      int v = queue.poll();
      int c = 0;
      LNode ln = graph.get(v);
      visited.add(v);
      boolean f = false;
      if (degreeMap.get(v) < k) {
        degreeMap.remove(v);
        f = true;
      }
      while (ln != null) {
        if (!visited.contains(ln.getData())) {
          c++;
          int y = degreeMap.get(ln.getData());
          y--;
          degreeMap.put(ln.getData(), y);
          visited.add(ln.getData());
          queue.add(ln.getData());
        }
        ln = ln.getNext();
      }
      if (!f) {
        degreeMap.put(v, degreeMap.get(v) - c);
      }
    }

  }

  public Map<Integer, LNode> getGraph() {
    return graph;
  }

  private LNode createLNode(LNode lNode, int dest) {
    LNode ln = new LNode(dest);
    if (lNode == null) {
      lNode = ln;
      return lNode;
    } else {
      lNode.setLNode(createLNode(lNode.getNext(), dest));
      return lNode;
    }
  }

  public Pair getPair() {
    return pair;
  }

  public Map<Integer, Integer> getDegreeMap() {
    return degreeMap;
  }
}

class Pair {

  private int minDegree;
  private int node;

  Pair(int node, int minDegree) {
    this.node = node;
    this.minDegree = minDegree;
  }

  public int getMinDegree() {
    return minDegree;
  }

  public int getNode() {
    return node;
  }
}
