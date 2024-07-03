// Level order traversal of binary trees (breadth first)

import java.util.Queue;
import java.util.LinkedList;

public class TraverseLevelOrder {
  static TreeNode root;

  public static void main(String[] args) {
    root = new TreeNode(0);
    root.addLeft(new TreeNode(1));
    root.addRight(new TreeNode(2));
    root.left().addLeft(new TreeNode(3));
    root.right().addLeft(new TreeNode(4));
    root.right().addRight(new TreeNode(5));
    root.right().right().addRight(new TreeNode(6));
    root.right().right().right().addRight(new TreeNode(12));

    printLevelOrder(root);
    System.out.println();
    printLevelOrder2(root);
    System.out.println();
    // output: 0 1 2 3 4 5 6 12
  }

  static void printLevelOrder(TreeNode node) {
    if (node == null) return;

    int height = getHeight(root);
    for (int i = 1; i <= height; i++) {
      printLevelOrder (node, i);
    }
  }

  static void printLevelOrder(TreeNode node, int level) {
    if (node == null) return;

    TreeNode temp = node;
    if (level == 1)
      System.out.print(temp.data() + " ");
    else {
      printLevelOrder(temp.left(), level - 1);
      printLevelOrder(temp.right(), level - 1);
    }
  }

  static int getHeight(TreeNode node) {
    if (node == null) return 0;

    return 1 + Math.max(getHeight(node.left()), getHeight(node.right()));
  }

  static void printLevelOrder2(TreeNode node) {
    if (node == null) return;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(node);

    TreeNode temp;
    while (!q.isEmpty()) {
      temp = q.poll();
      System.out.print(temp.data() + " ");

      if (temp.left() != null) {
        q.add(temp.left());
      }

      if (temp.right() != null) {
        q.add(temp.right());
      }
    }
  }

}

class TreeNode {
  private int _data;
  private TreeNode _left;
  private TreeNode _right;

  public TreeNode (int data) {
    this._data = data;
    _left = _right = null;
  }

  public int data () {
    return this._data;
  }

  public TreeNode right () {
    return this._right;
  }

  public TreeNode left () {
    return this._left;
  }

  public void addRight (TreeNode node) {
    this._right = node;
  }

  public void addLeft (TreeNode node) {
    this._left = node;
  }
}
