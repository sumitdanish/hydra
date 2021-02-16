package com.practice.ds.linklist;

public class SumOfLinkedList {

  public static void main(String[] args) {
    int[] a = {1, 2, 3};
    int[] a1 = {9, 3, 6};
    ListNode ll1 = null;
    ListNode ll2 = null;
    for (int x : a) {
      ll1 = createNode(ll1, x);
    }
    for (int x1 : a1) {
      ll2 = createNode(ll2, x1);
    }
    ListNode sum = listSum(ll1, ll2);
    print(sum);
  }

  private static ListNode listSum(ListNode ll1, ListNode ll2) {
    ListNode l = null;
    int carry = 0;
    ListNode node = null;
    ListNode head = null;
    while (ll1 != null && ll2 != null) {
      int sum = ll1.getData() + ll2.getData() + carry;
      int digit = sum % 10;
      if (node == null){
        node = new ListNode(digit);
        head = node;
      }else{
        node.setNext(new ListNode(digit));
        node = node.next;
      }
      carry = sum / 10;
      ll1 = ll1.getNext();
      ll2 = ll2.getNext();
    }
    while (ll1 != null) {
      int sum = ll1.getData() + carry;
      int digit = sum % 10;
      if (node == null){
        node = new ListNode(digit);
        head = node;
      }else{
        node.setNext(new ListNode(digit));
        node = node.next;
      }
      carry = sum / 10;
      ll1 = ll1.getNext();
    }
    while (ll2 != null) {
      int sum = ll2.getData() + carry;
      int digit = sum % 10;
      if (node == null){
        node = new ListNode(digit);
        head = node;
      }else{
        node.setNext(new ListNode(digit));
        node = node.next;
      }
      carry = sum / 10;
      ll2 = ll2.getNext();
    }
    if (carry > 0) {
      if (node == null){
        if (node == null){
          node = new ListNode(carry);
          head = node;
        }else{
          node.setNext(new ListNode(carry));
          node = node.next;
        }
      }
    }
    return head;
  }

  private static void print(ListNode ll) {
    if (ll == null) {
      return;
    }
    System.out.print(ll.getData() + ",");
    print(ll.getNext());
  }

  private static ListNode createNode(ListNode list, int data) {
    ListNode ll = new ListNode(data);
    if (list == null) {
      list = ll;
      return list;
    }
    list.next = createNode(list.getNext(), data);
    return list;
  }

}

class ListNode {

  public int data;
  public ListNode next;

  public ListNode(int data) {
    this.data = data;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public ListNode getNext() {
    return next;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }
}
