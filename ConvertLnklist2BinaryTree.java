// write a program to convert a linked list to a binary tree.

import java.util.Queue;
import java.util.LinkedList;

public class ConvertLnklist2BinaryTree {

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

    TreeNode root = convertLL2BT(head);
    printLevelOrder(root);
    // output: 1 2 3 4 5 6 7 8 9

    TreeNode root2 = convertLL2BTRecursive(head);
    printLevelOrder(root2);
    // output: 1 2 3 4 5 6 7 8 9
  }

  // solution 1
  static TreeNode convertLL2BT(ListNode node) {
    if (node == null) return null;

    ListNode temp = node;
    TreeNode root = new TreeNode(temp.data);
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    temp = temp.next;
    while (!q.isEmpty()) {
      TreeNode parent = q.poll();

      if (temp == null) break;

      if (temp != null) {
        TreeNode left = new TreeNode(temp.data);
        parent.left = left;
        q.add(left);
        temp = temp.next;
      }

      if (temp != null) {
        TreeNode right = new TreeNode(temp.data);
        parent.right = right;
        q.add(right);
        temp = temp.next;
      }
    }

    return root;
  }

  // solution 2
  static TreeNode convertLL2BTRecursive(ListNode node) {
    if (node == null) return null;

    ListNode temp = node;
    int len = findLLLength(temp);

    int [] arr = new int [len];
    for (int i = 0; i < len; i++) {
      arr[i] = temp.data;
      temp = temp.next;
    }

    return buildeBT(arr, 0);
  }

  static TreeNode buildeBT(int [] arr, int index) {
    TreeNode root = null;

    if (index < arr.length) {
      root = new TreeNode(arr[index]);

      root.left = buildeBT(arr, 2 * index + 1);
      root.right = buildeBT(arr, 2 * index + 2);
    }

    return root;
  }

  static int findLLLength(ListNode node) {
    if (node == null) return 0;

    return 1 + findLLLength(node.next);
  }

  static void printLevelOrder(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    TreeNode curr = new TreeNode();
    while (!q.isEmpty()) {
      curr = q.poll();
      System.out.print(curr.data + " ");

      if (curr.left != null)
        q.add(curr.left);

      if (curr.right != null)
        q.add(curr.right);
    }

    System.out.println();
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

class TreeNode {
  int data;
  TreeNode left = null;
  TreeNode right = null;

  TreeNode () {}

  TreeNode(int data) {
    this.data = data;
  }
}
