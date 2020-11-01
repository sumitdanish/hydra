package com.practice.ds.graph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Graph {

  public static void main(String[] args) throws FileNotFoundException {
    GraphStructure gs = new GraphStructure("g1.txt");
    Map<Integer, LNode> getStructure = gs.getGraph();
    LNode ln = getStructure.get(6);
    print(ln);
  }

  private static void print(LNode ln) {
    if (ln == null) {
      return;
    }
    System.out.print(ln.getData() + " ->");
    print(ln.getNext());
  }
}

class GraphStructure {

  private Map<Integer, LNode> graphList;
  private Set<Integer> isVisited;

  public GraphStructure(String fileName) throws FileNotFoundException {
    graphList = new HashMap<>();
    isVisited = new HashSet<>();
    Scanner sc = new Scanner(new FileInputStream(new File(fileName)));
    while (sc.hasNext()) {
      String[] s = sc.next().split(",");
      Integer src = Integer.valueOf(s[0]);
      Integer dest = Integer.valueOf(s[1]);
      addEdge(src, dest);
    }
  }

  private void addEdge(Integer src, Integer dest) {
    if (!graphList.containsKey(src)) {
      LNode ln = createGraphNodeList(null, src);
      LNode ln1 = createGraphNodeList(ln, dest);
      graphList.put(src, ln1);
      return;
    }
    LNode ln = createGraphNodeList(graphList.get(src), dest);
    graphList.put(src, ln);
  }

  private LNode createGraphNodeList(LNode next, int data) {
    LNode l = new LNode(data);
    if (next == null) {
      next = l;
      return next;
    } else {
      next.setLNode(createGraphNodeList(next.getNext(), data));
    }
    return next;
  }

  public Map<Integer, LNode> getGraph() {
    return this.graphList;
  }

}

class LNode {

  private int data;
  private LNode next;

  public LNode(int data) {
    this.data = data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public void setLNode(LNode next) {
    this.next = next;
  }

  public int getData() {
    return this.data;
  }

  public LNode getNext() {
    return this.next;
  }
}
