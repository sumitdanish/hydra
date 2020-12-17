package com.practice.ds.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class AllPossiblePath {


  public static void main(String[] args) {
    try {
      Graph1 graph1 = new Graph1("g2.txt");
     // LNode1 ln = graph1.getGraph().get(0);
      //print(ln);
      System.out.println();
       //System.out.println(allPossiblePath(graph1.getGraph(), 0, 4, 0));
      //bfsAllPath(graph1.getGraph(), 0, 4);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static void print(LNode1 ln) {
    if (ln == null) {
      return;
    }
    System.out.print(ln.getData() + " ->");
    print(ln.getNext());
  }

  private static void bfsAllPath(Map<Integer, LNode1> graph, int src, int dest) {
    Queue<Integer> queue = new LinkedList<>();
    int path = 0;
    queue.add(src);
    while (!queue.isEmpty()) {
      int vertex = queue.remove();
      if (vertex == dest) {
        path++;
      }
      LNode1 lNode1 = graph.get(vertex);
      while (lNode1 != null) {
        queue.add(lNode1.getData());
        lNode1 = lNode1.getNext();
      }
    }

    System.out.println(path);
  }

  private static int allPossiblePath(Map<Integer, LNode1> graph, int src, int dest, int path) {
    if (src == dest) {
      path++;
    } else {
      LNode1 ln = graph.get(src);
      while (ln != null) {
        path = allPossiblePath(graph, ln.getData(), dest, path);
        ln = ln.getNext();
      }
    }
    return path;
  }
}


class Graph1 {

  private Map<Integer, LNode1> graph;

  public Graph1(String fileName) throws FileNotFoundException {
    graph = new HashMap<>();
    Scanner sc = new Scanner(new File(fileName));
    while (sc.hasNext()) {
      String[] s = sc.next().split(",");
      int src = Integer.parseInt(s[0]);
      int dest = Integer.parseInt(s[1]);
      addEdge(src, dest);
    }
  }

  private void addEdge(int src, int dest) {
    if (!graph.containsKey(src)) {
      LNode1 lnSrc = new LNode1(dest);
      // LNode1 lnDest = createNode(dest, lnSrc);
      graph.put(src, lnSrc);
      return;
    }
    LNode1 list = createNode(dest, graph.get(src));
    graph.put(src, list);
    return;
  }

  private LNode1 createNode(int data, LNode1 node) {
    LNode1 ln = new LNode1(data);
    if (node == null) {
      node = ln;
      return node;
    }
    node.setNext(createNode(data, node.getNext()));
    return node;
  }

  public Map<Integer, LNode1> getGraph() {
    return graph;
  }
}

class LNode1 {

  private int data;
  private LNode1 next;

  public LNode1(int data) {
    this.data = data;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public LNode1 getNext() {
    return next;
  }

  public void setNext(LNode1 next) {
    this.next = next;
  }
}
