package com.practice.ds.array;

public class MaxMinHeap {
  public static void main(String[] args) {
    int arrA [] = {3,2,1,7,8,4,10,16,12};
    MinHeap minHeap = new MinHeap(arrA);
    minHeap.createHeap();
    for (int i=0;i<=arrA.length;i++){
      System.out.print(minHeap.extract()+" ,");
    }
  }
}


class MinHeap{
  private int[] mxH;
  private int currentSIze;
  private int[] original = null;

  public MinHeap(int[] original) {
    this.original = original;
    mxH = new int[original.length+1];
    currentSIze=0;
    mxH[0] = Integer.MIN_VALUE;
  }

  public void createHeap(){
    for (int i=0;i<original.length;i++){
      insert(original[i]);
    }
  }

  private void insert(int val) {
      if (currentSIze == original.length){
        return;
      }
      currentSIze++;
      int idx = currentSIze;
      mxH[idx] = val;
      bubbleUp(idx);
  }

  private void bubbleUp(int idx){
    int parent = idx/2;
    int currentIndex = idx;
    while (currentIndex > 0 && mxH[currentIndex] > mxH[parent]){
      int temp = mxH[currentIndex];
      mxH[currentIndex] = mxH[parent];
      mxH[parent] = temp;
      currentIndex = parent;
      parent = parent/2;
    }
  }

  private void heapify(int idx) {
    int left = 2*idx;
    int right = 2*idx+1;
    int largest = idx;
    if (left < mxH.length && mxH[left] > mxH[idx]){
      largest = left;
    }
    if (right < mxH.length && mxH[right] > mxH[largest]){
      largest = right;
    }
    if (largest != idx){
      int temp = mxH[idx];
      mxH[idx] = mxH[largest];
      mxH[largest] = temp;
      heapify(largest);
    }
  }


  public int extract(){
    int val = mxH[0];
    mxH[0] = mxH[currentSIze];
    mxH[currentSIze] = 0;
    heapify(0);
    currentSIze--;
    return val;
  }
}
