// Write a program to reverse a singly linked list in Java. You can use iteration and recursion
// to solve this problem, but you should reverse a linked list in place.

public class ReverseLnkedList {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    ListNode n6 = new ListNode(6);
    ListNode n7 = new ListNode(7);
    ListNode n8 = new ListNode(8);

    head.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;
    n7.next = n8;

    head = reverseLnkedList(head);

    ListNode temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    // output: 8 7 6 5 4 3 2 1

    System.out.println();

    head = reverseLnkedList2(head);

    temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    // output: 1 2 3 4 5 6 7 8

    System.out.println();

    head = reverseLnkedList3(head);

    temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    // output: 8 7 6 5 4 3 2 1

  }

  // solution 1
  static ListNode reverseLnkedList(ListNode node) {
    if (node == null || node.next == null)
      return node;

    ListNode prev = node;
    ListNode curr = null;
    ListNode temp = node.next;
    prev.next = null;

    while (temp != null) {
      curr = temp;
      temp = temp.next;
      curr.next = prev;
      prev = curr;
    }

    return curr;
  }

  // solution 2
  static ListNode reverseLnkedList2(ListNode node) {
    if (node == null || node.next == null)
      return node;

    ListNode prev = node;
    ListNode curr = node.next;
    ListNode temp = node.next.next;
    prev.next = null;

    while (temp != null) {
      curr.next = prev;
      prev = curr;
      curr = temp;
      temp = temp.next;
    }

    curr.next = prev;
    return curr;
  }

  // solution 3
  static ListNode reverseLnkedList3(ListNode node) {
    if (node == null || node.next == null) return node;

    ListNode prev = node;
    ListNode curr = node;
    ListNode temp = node.next;
    prev.next = null;

    return reverseLnkedList3 (prev, curr, temp);
  }

  static ListNode reverseLnkedList3 (ListNode prev, ListNode curr, ListNode temp) {
    if (temp == null) return curr;

    curr = temp;
    temp = temp.next;
    curr.next = prev;
    prev = curr;

    return reverseLnkedList3(prev, curr, temp);
  }

}

class ListNode {
  int data;
  ListNode next = null;

  ListNode () {}

  ListNode(int data) {
    this.data = data;
  }
}
