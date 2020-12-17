package com.practice.ds.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class StronglyConnectedComponent {

  public static void main(String[] args) throws FileNotFoundException {
    SCCGraph sccGraph = new SCCGraph("scc.txt");
    sccGraph.getSCC();
  }

}

class SCCGraph {

  private Map<Integer, LNode> graph;
  private Map<Integer, LNode> graphT;
  private Set<Integer> visited;
  Stack<Integer> stack = new Stack<>();
  int v = 0;

  public SCCGraph(String fileName) throws FileNotFoundException {
    Scanner sc = new Scanner(new File(fileName));
    v = sc.nextInt();
    graphT = new HashMap<>();
    graph = new HashMap<>();
    visited = new HashSet<>();
    while (sc.hasNext()) {
      String[] s = sc.next().split(",");
      Integer src = Integer.parseInt(s[0]);
      Integer dest = Integer.parseInt(s[1]);
      addEdge(src, dest);
    }
  }

  private void dfs(Integer src) {
    visited.add(src);
    LNode ln = graph.get(src);
    while (ln != null) {
      if (!visited.contains(ln.getData())) {
        dfs(ln.getData());
      }
      ln = ln.getNext();
    }
    stack.push(src);
  }

  private void dfs1(Integer src) {
    visited.add(src);
    System.out.print(src + ",");
    LNode ln = graphT.get(src);
    while (ln != null) {
      if (!visited.contains(ln.getData())) {
        dfs1(ln.getData());
      }
      ln = ln.getNext();
    }
  }

  private void fill() {
    for (int i = 0; i < v; i++) {
      if (!visited.contains(i)) {
        dfs(i);
      }
    }
  }

  public void getSCC() {
    fill();
    visited.clear();
    while (!stack.isEmpty()) {
      int v = stack.pop();
      if (!visited.contains(v)) {
        dfs1(v);
        System.out.println();
      }
    }
  }


  private void addEdge(Integer src, Integer dest) {
    if (!graph.containsKey(src)) {
      graph.put(src, new LNode(dest));
      graphT.put(dest, new LNode(src));
      return;
    }
    graph.put(src, createList(graph.get(src), dest));
    graphT.put(dest, createList(graphT.get(dest), src));
  }

  public Stack<Integer> getStack() {
    return stack;
  }

  private LNode createList(LNode lNode, Integer dest) {
    LNode ln = new LNode(dest);
    if (lNode == null) {
      lNode = ln;
      return lNode;
    }
    lNode.setLNode(createList(lNode.getNext(), dest));
    return lNode;
  }
}
