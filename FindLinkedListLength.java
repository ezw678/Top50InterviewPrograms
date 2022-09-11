// write a program in Java to find the length of a singly linked list in one pass,
// i.e. in just one iteration of a singly linked list.

public class FindLinkedListLength {

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

    System.out.println(findLinkedListLength(head));
    System.out.println(findLinkedListLength2(head));
    // output: 8
  }

  static int findLinkedListLength(ListNode node) {
    if (node == null) return 0;

    int count = 0;
    ListNode temp = node;
    while (temp != null) {
      count++;
      temp = temp.next;
    }

    return count;
  }

  static int findLinkedListLength2(ListNode node) {
    if (node == null) return 0;

    return 1 + findLinkedListLength2(node.next);
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
