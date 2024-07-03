// Write a program to sort a linked list

import java.util.Arrays;

public class SortLinkedList {

  public static void main(String[] args) {
    ListNode head = new ListNode(120);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(33);
    ListNode n4 = new ListNode(230);
    ListNode n5 = new ListNode(59);
    ListNode n6 = new ListNode(6);
    ListNode n7 = new ListNode(7);
    ListNode n8 = new ListNode(88);
    ListNode n9 = new ListNode(1);

    head.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;
    n7.next = n8;
    n8.next = n9;

    ListNode temp = head;
    temp = sortLinkedList(temp);
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    // output: 1 2 6 7 33 59 88 120 230

    System.out.println();

    head.setData(120);
    n2.setData(2);
    n3.setData(33);
    n4.setData(230);
    n5.setData(59);
    n6.setData(6);
    n7.setData(7);
    n8.setData(88);
    n9.setData(1);

    temp = head;
    temp = sortLinkedList2(temp);
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    // output: 1 2 6 7 33 59 88 120 230

    System.out.println();

    head.setData(120);
    n2.setData(2);
    n3.setData(33);
    n4.setData(230);
    n5.setData(59);
    n6.setData(6);
    n7.setData(7);
    n8.setData(88);
    n9.setData(1);

    temp = head;
    temp = sortLinkedList4(temp);
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    // output: 1 2 6 7 33 59 88 120 230

    System.out.println();

    head.setData(120);
    n2.setData(2);
    n3.setData(33);
    n4.setData(230);
    n5.setData(59);
    n6.setData(6);
    n7.setData(7);
    n8.setData(88);
    n9.setData(1);

    temp = head;
    temp = sortLinkedList3(temp);
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    // output: 1 2 6 7 33 59 88 120 230

    System.out.println();
  }

  // solution 1
  static ListNode sortLinkedList (ListNode node) {
    if (node == null || node.next == null) return node;

    ListNode curr = node;

    int len = findLLLength(node);
    int [] arr = new int [len];
    for (int i = 0; i < len; i++) {
      arr[i] = curr.data;
      curr = curr.next;
    }

    Arrays.sort(arr);

    ListNode head = null;
    ListNode tail = null;
    for (int i = 0; i < len; i++) {
      ListNode temp = new ListNode(arr[i]);
      if (head == null) {
        head = temp;
        tail = temp;
      } else  {
        tail.next = temp;
        tail = tail.next;
      }
    }

    return head;
  }

  static int findLLLength(ListNode node) {
    if (node == null) return 0;

    return 1 + findLLLength(node.next);
  }

  // solution 2 (buble sort)
  static ListNode sortLinkedList2 (ListNode node) {
    if (node == null || node.next == null) return node;

    ListNode head = node;
    ListNode curr = node;

    while (curr != null) {
      ListNode forward = curr.next;
      while (forward != null) {
        if (curr.data > forward.data) {
          int temp = curr.data;
          curr.data = forward.data;
          forward.data = temp;
        }
        forward = forward.next;
      }
      curr = curr.next;
    }

    return head;
  }

  // solution 3 (insertion sort)
  static ListNode sortLinkedList3 (ListNode node) {
    if (node == null || node.next == null) return node;

    ListNode head = node;
    ListNode curr = node;

    while (curr != null) {
      ListNode forward = curr.next;

      if (forward == null) break;

      if (curr.data < forward.data) {
        curr = curr.next;
        continue;
      } else {
        curr.next = forward.next;
        head = insert(head, forward);
      }
    }

    return head;
  }

  static ListNode insert(ListNode head, ListNode forward) {
    ListNode temp = head;

    if (forward.data < temp.data) {
      forward.next = temp;
      head = forward;
      // return head;
    } else {
      while (temp.next != null && temp.next.data < forward.data) {
        temp = temp.next;
      }

      forward.next = temp.next;
      temp.next = forward;
    }

    return head;
  }

  // solution 4 (quick sort)
  static ListNode sortLinkedList4 (ListNode node) {
    if (node == null || node.next == null) return node;

    ListNode start = node;
    ListNode end = getLastNode(start);
    sortLinkedList4 (start, end);

    return start;
  }

  static void sortLinkedList4 (ListNode start, ListNode end) {
    if (end.next != null) {
      if (start == null || start == end || (start == end.next && start.data > end.data) || start == end.next.next) {
        return;
      }
    } else {
      if (start == null || start == end || start == end.next) {
        return;
      }
    }

    if (start.next == end) {
      if (start.data > end.data)
        swapData(start, end);

      return;
    }

    ListNode p_node = partition(start, end);

    sortLinkedList4(start, p_node);
    sortLinkedList4(p_node.next.next, end);
  }

  static ListNode partition (ListNode start, ListNode end) {
    int pivot = end.data;

    ListNode p_node = new ListNode();
    ListNode prev = new ListNode();

    p_node.next = start;
    prev.next = p_node;
    ListNode temp = start;
    while (temp != end) {
      if (temp.data < pivot) {
        prev = p_node;
        p_node = p_node.next;
        if (p_node != temp) {
          if (p_node.data > temp.data) {
            swapData(p_node, temp);
          }
        }
      }
      temp = temp.next;
    }

    if (p_node.next.data > pivot) {
      swapData(p_node.next, end);
    }
    prev = p_node;

    return prev;
  }

  static void swapData (ListNode node1, ListNode node2) {
    int temp = node1.data;
    node1.data = node2.data;
    node2.data = temp;
  }

  static ListNode getLastNode(ListNode node) {
    ListNode temp = node;

    while (temp.next != null) {
      temp = temp.next;
    }

    return temp;
  }

}

class ListNode {
  int data;
  ListNode next = null;

  ListNode () {}

  ListNode(int data) {
    this.data = data;
  }

  void setData(int data) {
    this.data = data;
  }
}
