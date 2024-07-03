// write a program to find the 3rd element from the tail of a singly linked list. You need to
// solve this problem without iterating twice.

public class Find3rdElementFromEnd {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    ListNode n6 = new ListNode(6);
    ListNode n7 = new ListNode(7);
    ListNode n8 = new ListNode(8);
    ListNode n9 = new ListNode(9);

    head.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;
    n7.next = n8;
    n8.next = n9;

    ListNode temp = find3rdElementFromEnd(head);
    if (temp != null)
      System.out.println(temp.data);
    else
      System.out.println(temp);

    // output: 7
  }

  static ListNode find3rdElementFromEnd(ListNode node) {
    if (node == null || node.next == null || node.next.next == null) return null;

    ListNode p1 = node;
    ListNode p2 = node.next.next;

    while (p2.next != null) {
      p1 = p1.next;
      p2 = p2.next;
    }

    return p1;
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
