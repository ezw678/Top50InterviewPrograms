// Write a program to find the start of loop in a linked list

public class FindLinkedListLoopStart {

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

    ListNode temp = findLinkedListLoopStart(head);
    if (temp != null)
      System.out.println("loop start: " +  temp.data);
    // output: 3
    else
      System.out.println("loop start (not cylic): " +  temp);
  }

  static ListNode findLinkedListLoopStart(ListNode node) {
    if (node == null) return node;

    ListNode slow = node;
    ListNode fast = node;

    boolean isCylic = false;
    while (fast != null) {
      slow = slow.next;
      if (fast.next != null)
        fast = fast.next.next;
      else
        return null;
      if (slow == fast) {
        slow = node;
        isCylic = true;
        break;
      }
    }

    if (!isCylic) return null;

    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
      if (slow == fast)
        return slow;
    }

    return null;
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
