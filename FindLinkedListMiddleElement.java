// Write a program to find the middle element of a linked list

public class FindLinkedListMiddleElement {

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

    ListNode temp = findLinkedListMiddleElement(head);
    if (temp != null)
      System.out.println(temp.data);
    else
      System.out.println(temp);

    // output: 5
  }

  static ListNode findLinkedListMiddleElement(ListNode node) {
    if (node == null || node.next == null) return node;

    ListNode slow = node;
    ListNode fast = node;

    while (fast != null) {
      if (fast.next != null)
        fast = fast.next.next;
      else
        break;
      slow = slow.next;
    }

    return slow;
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
