package com.practice.ds.graph.disjoint;

import java.io.File;
import java.util.Scanner;

public class DisjointBasicOperation {

  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(new File("dis.txt"));
      int x = scanner.nextInt();
      int[] graph = new int[x];
      int[] size = new int[x];
      for (int i = 0; i < x; i++) {
        graph[i] = i;
        size[i] = 1;
      }
      while (scanner.hasNext()) {
        String[] s = scanner.next().split(",");
        int src = Integer.parseInt(s[0]);
        int dest = Integer.parseInt(s[1]);
        //union(src, dest, graph);
        unionWithSize(src, dest, graph, size);
      }
      for (int i = 0; i < x; i++) {
        System.out.println(i + " ->" + graph[i] + ",");
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private static void union(int a, int b, int[] graph) {
    if (find(a, graph) == find(b, graph)) {
      return;
    }
    graph[a] = graph[b];
  }

  private static int find(int a, int[] graph) {
    if (graph[a] == a) {
      return a;
    }
    return find(graph[a], graph);
  }

  private static void unionWithSize(int src, int dest, int[] graph, int[] size) {
    int srcRoot = find(src, graph);
    int destRoot = find(dest, graph);
    if (size[srcRoot] <= size[destRoot]) {
      graph[srcRoot] = graph[destRoot];
      size[destRoot] += size[srcRoot];
    } else {
      graph[destRoot] = graph[srcRoot];
      size[srcRoot] += size[destRoot];
    }
  }
}
