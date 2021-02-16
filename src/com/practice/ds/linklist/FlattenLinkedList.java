package com.practice.ds.linklist;

import java.util.Iterator;
import java.util.Queue;
import sun.awt.image.ImageWatched.Link;

public class FlattenLinkedList {

  public static void main(String[] args) {
    int[] a = {10, 5, 12, 7, 11};
    LinkedList list = null;
    for (int i : a) {
      list = createList(list, i);
    }
    LinkedList child1 = null;
    int[] c = {4, 20, 13};
    for (int i : c) {
      child1 = createList(child1, i);
    }
    int[] c1 = {17, 6};
    LinkedList child2 = null;
    for (int i : c1) {
      child2 = createList(child2, i);
    }
    list.setChild(child1);
    list.getChild().getNext().setChild(new LinkedList(2));
    list.getChild().getNext().getNext().setChild(new LinkedList(16));
    list.getNext().getNext().getNext().setChild(child2);
    flatten1(list);
    print(list);
  }

  private static void flatten(LinkedList list) {
    LinkedList head = list;
    Queue<LinkedList> queue = new java.util.LinkedList<>();
    LinkedList prev = null;
    while (head != null) {
      while (head != null) {
        if (head.getChild() != null) {
          queue.add(head.getChild());
          head.setChild(null);
        }
        prev = head;
        head = head.getNext();
      }
      if (prev != null && !queue.isEmpty()) {
          LinkedList child = queue.poll();
          prev.setNext(child);
          head = prev;
      }
    }
  }

  private static void flatten1(LinkedList list){
    LinkedList temp = list;
    while (temp.getNext() != null){
      temp = temp.getNext();
    }
    LinkedList prevTemp=null;
    LinkedList head = list;
    while (head != temp){
      if (head.getChild() != null){
        temp.setNext(head.getChild());
        prevTemp = head.getChild();
        while (prevTemp.getNext() != null){
          prevTemp = prevTemp.getNext();
        }
        temp = prevTemp;
        head.setChild(null);
      }
      head = head.getNext();
    }
  }

  private static void print(LinkedList linkedList) {
    if (linkedList == null) {
      return;
    }
    System.out.print(linkedList.getData() + ",");
    print(linkedList.getNext());
  }

  private static LinkedList createList(LinkedList list, int data) {
    LinkedList l = new LinkedList(data);
    if (list == null) {
      list = l;
      return list;
    }
    list.setNext(createList(list.getNext(), data));
    return list;
  }
}

class LinkedList {

  private LinkedList next;
  private int data;
  private LinkedList child;

  public LinkedList(int data) {
    this.data = data;
  }

  public LinkedList getNext() {
    return next;
  }

  public void setNext(LinkedList next) {
    this.next = next;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public LinkedList getChild() {
    return child;
  }

  public void setChild(LinkedList child) {
    this.child = child;
  }
}
