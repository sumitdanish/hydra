package com.practice.ds.array;

public class MaxMinHeap {

  public static void main(String[] args) {
    int arrA[] = {3, 2, 1, 7, 8, 4, 10, 16, 120};
    MinHeap minHeap = new MinHeap(arrA.length);
    minHeap.insert(3);
    minHeap.insert(2);
    minHeap.insert(1);
    minHeap.insert(7);
    minHeap.insert(8);
    minHeap.insert(5);
    minHeap.insert(10);
    minHeap.insert(16);
    minHeap.insert(120);
    minHeap.minHeap();
    minHeap.printHeap();
  }
}


class MinHeap {

  private int size;
  private int[] heap;
  private int index;

  public MinHeap(int size) {
    this.size = size;
    index = 0;
    heap = new int[size];
  }

  private int parent(int i) {
    return (i - 1) / 2;
  }

  private int left(int i) {
    return (2 * i) + 1;
  }

  private int right(int i) {
    return (2 * i) + 2;
  }

  public void minHeap() {
    for (int i = (size - 1) / 2; i >= 0; i--) {
      heapify(i);
    }
  }

  private void heapify(int i) {
    int left = left(i);
    int right = right(i);
    if (left >= size || right >= size) {
      return;
    }
    if (heap[left] > heap[i] || heap[right] > heap[i]) {
      if (heap[left] > heap[i]) {
        int temp = heap[i];
        heap[i] = heap[left];
        heap[left] = temp;
        heapify(left);
      }
      if (heap[right] > heap[i]) {
        int temp = heap[i];
        heap[i] = heap[right];
        heap[right] = temp;
        heapify(right);
      }
    }
  }

  public void insert(int val) {
    if (index >= size) {
      return;
    }
    heap[index] = val;
    int current = index;
    while (heap[current] > heap[parent(current)]) {
      int temp = heap[parent(current)];
      heap[parent(current)] = heap[current];
      heap[current] = temp;
      current = parent(current);
    }
    index++;
  }

  public int extract() {
    int val = heap[0];
    heap[0] = heap[--index];
    heapify(0);
    return val;
  }

  public void printHeap() {
    for (int i = 0; i < (index / 2); i++) {
      System.out.print("Parent : " + heap[i]);
      if (left(i) < index)
        System.out.print(" Left : " + heap[left(i)]);
      if (right(i) < index)
        System.out.print(" Right :" + heap[right(i)]);
      System.out.println();
    }
  }
}
