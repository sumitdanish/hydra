package com.practice.ds.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CycleDetection {

  public static void main(String[] args) throws FileNotFoundException {
    CycleGraph cycleGraph = new CycleGraph("cyle.txt");
    System.out.println(cycleGraph.cycleCount(0));
  }
}

class CycleGraph {

  private Map<Integer, LNode> graph;
  private Set<Integer> visited;

  public CycleGraph(String fileName) throws FileNotFoundException {
    Scanner sc = new Scanner(new File(fileName));
    graph = new HashMap<>();
    visited = new HashSet<>();
    while (sc.hasNext()) {
      String[] s = sc.next().split(",");
      Integer src = Integer.parseInt(s[0]);
      Integer dest = Integer.parseInt(s[1]);
      addEdge(src, dest);
    }
  }

  private void addEdge(Integer src, Integer dest) {
    if (!graph.containsKey(src)) {
      graph.put(src, new LNode(dest));
      return;
    }
    graph.put(src, createList(graph.get(src), dest));
  }

  public boolean isCycle(int src) {
    if (visited.contains(src)) {
      return true;
    }
    visited.add(src);
    LNode ln = graph.get(src);
    while (ln != null) {
      if (isCycle(ln.getData())) {
        return true;
      }
      ln = ln.getNext();
    }
    return false;
  }

  public Integer cycleCount(int src) {
    if (visited.contains(src)) {
      return 1;
    }
    Integer path = 0;
    visited.add(src);
    LNode ln = graph.get(src);
    while (ln != null) {
      path += cycleCount(ln.getData());
      ln = ln.getNext();
    }
    return path;
  }

  private LNode createList(LNode lNode, Integer dest) {
    LNode node = new LNode(dest);
    if (lNode == null) {
      lNode = node;
      return lNode;
    }
    lNode.setLNode(createList(lNode.getNext(), dest));
    return lNode;
  }
}
