package com.practice.ds.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class ArticulationPoint {

  public static void main(String[] args) throws FileNotFoundException, NoSuchFieldException, IllegalAccessException {
    ArticulationGraph articulationGraph = new ArticulationGraph("art.txt");
    for (int i=0;i<6;i++){
      articulationGraph.articulationPoint(i);
    }

  }

}

class ArticulationGraph {

  private Map<Integer, LNode> graph;
  private Set<Integer> visited;
  private int[] low;
  private int[] disc;
  private int[] parent;
  private boolean[] ap;
  private int time=0;
  public ArticulationGraph(String fileName) throws FileNotFoundException {
    Scanner sc = new Scanner(new File(fileName));
    graph = new HashMap<>();
    visited = new HashSet<>();
    int v = sc.nextInt();
    low = new int[v];
    disc = new int[v];
    parent = new int[v];
    ap = new boolean[v];
    while (sc.hasNext()) {
      String[] s = sc.next().split(",");
      int src = Integer.parseInt(s[0]);
      int dest = Integer.parseInt(s[1]);
      addEdge(src, dest);
    }
  }

  private void addEdge(int src, int dest) {
    if (!graph.containsKey(src)) {
      graph.put(src, new LNode(dest));
      return;
    }
    graph.put(src, createList(graph.get(src), dest));
  }

  private LNode createList(LNode lNode, int dest) {
    LNode ln = new LNode(dest);
    if (lNode == null) {
      lNode = ln;
      return lNode;
    }
    lNode.setLNode(createList(lNode.getNext(), dest));
    return lNode;
  }

  public void articulationPoint(int src) {
    visited.add(src);
    low[src] = time;
    disc[src] = time;
    LNode ln = graph.get(src);
    int count=0;
    time++;
    while (ln != null) {
      int x = ln.getData();
      if (!visited.contains(x)) {
        parent[ln.getData()] = src;
        count++;
        articulationPoint(x);
        low[src] = min(low[src],low[x]);
        /*if (parent[src] == 0 && count > 1){
          ap[src] = true;
          System.out.print("AP "+src);
        }
        if (parent[src] != 0 && low[src] >= disc[x]){
          ap[src] = true;
          System.out.print("AP "+src);
        }*/
      } else{
        low[src] = min(low[src], disc[x]);
      }
      ln = ln.getNext();
    }
  }

  private int min(int a, int b) {
    return a > b ? b : a;
  }

  public Map<Integer, LNode> getGraph() {
    return graph;
  }
}
