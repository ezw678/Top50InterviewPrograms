// Write a program to check if given linked list has a loop or not. Sometimes a linked list
// get corrupt, and two nodes point to the same node, which forms the loop or cycle in the
// linked list.

public class IsLinkedListCyclic {

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

    n6.next = n3;

    System.out.println(isLinkedListCyclic(head));
    // output: true
  }

  static boolean isLinkedListCyclic(ListNode node) {
    if (node == null) return false;

    ListNode slow = node;
    ListNode fast = node;

    while (fast != null) {
      slow = slow.next;
      if (fast.next != null)
        fast = fast.next.next;
      else
        return false;
      if (slow == fast)
        return true;
    }

    return false;
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
