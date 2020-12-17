package com.practice.ds.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class TransitiveClosure {

  public static void main(String[] args) throws FileNotFoundException {
    //transitiveClosureUsingFloydAlgo("tr.txt");
    TransitiveGraph tr = new TransitiveGraph("tr.txt");
    tr.transitive();
    tr.pintGraph();
    Map<Integer, LNode> map = tr.getGraph();
    printGraph(map.get(0));
  }

  private static void transitiveClosureUsingFloydAlgo(String fileName) throws FileNotFoundException {
    Scanner sc = new Scanner(new File(fileName));
    int vertex = sc.nextInt();
    boolean[][] graph = new boolean[vertex][vertex];
    while (sc.hasNext()) {
      String[] s = sc.next().split(",");
      graph[Integer.parseInt(s[0])][Integer.parseInt(s[0])] = true;
      graph[Integer.parseInt(s[1])][Integer.parseInt(s[1])] = true;
      graph[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = true;
    }
    System.out.println("Before ......");
    printGraph(graph, vertex);
    for (int i = 0; i < vertex; i++) {
      for (int j = 0; j < vertex; j++) {
        for (int k = 0; k < vertex; k++) {
          graph[i][k] = graph[i][k] || (graph[i][j] && graph[j][k]);
        }
      }
    }
    System.out.println("After operation");
    printGraph(graph, vertex);

  }

  private static void printGraph(boolean[][] graph, int vertex) {
    for (int i = 0; i < vertex; i++) {
      for (int j = 0; j < vertex; j++) {
        System.out.print(graph[i][j] + ",");
      }
      System.out.println();
    }
  }

  private static void printGraph(LNode lNode) {
    if (lNode == null) {
      return;
    }
    System.out.print(lNode.getData() + " -> ");
    printGraph(lNode.getNext());
  }

}

class TransitiveGraph {

  private Map<Integer, LNode> graph;
  private boolean[][] gr = null;
  int vertex;

  public TransitiveGraph(String fileName) throws FileNotFoundException {
    graph = new HashMap<>();
    Scanner sc = new Scanner(new File(fileName));
    vertex = sc.nextInt();
    gr = new boolean[vertex][vertex];
    while (sc.hasNext()) {
      String[] s = sc.next().split(",");
      addEdge(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
    }
  }

  private void dfs(Map<Integer, LNode> map, int src, int dest) {
    gr[src][dest] = true;
    LNode ln = map.get(src);
    while (ln != null) {
      if (!gr[src][ln.getData()]) {
        dfs(map, src, ln.getData());
      }
      ln = ln.getNext();
    }
  }

  public void transitive() {
    for (int i = 0; i < vertex; i++) {
      dfs(graph, i, i);
    }
  }

  public void pintGraph() {
    for (int i = 0; i < vertex; i++) {
      for (int j = 0; j < vertex; j++) {
        System.out.print(gr[i][j] + ",");
      }
      System.out.println();
    }
  }

  private void addEdge(int src, int dest) {
    if (!graph.containsKey(src)) {
      graph.put(src, new LNode(dest));
      return;
    }
    LNode ln = createList(graph.get(src), dest);
    graph.put(src, ln);
  }

  public Map<Integer, LNode> getGraph() {
    return graph;
  }

  private LNode createList(LNode node, int data) {
    LNode ln = new LNode(data);
    if (node == null) {
      node = ln;
      return node;
    }
    node.setLNode(createList(node.getNext(), data));
    return node;
  }
}


