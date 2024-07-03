// Print out all leaves of a binary tree

import java.util.Stack;

public class PrintAllLeaves {
  static TreeNode root;

  public static void main(String[] args) {
    root = new TreeNode(0);
    root.addLeft(new TreeNode(1));
    root.addRight(new TreeNode(2));
    root.left().addLeft(new TreeNode(3));
    root.right().addLeft(new TreeNode(4));
    root.right().addRight(new TreeNode(5));

    printAllLeaves(root);
    // output: 3 4 5
  }

  static void printAllLeaves (TreeNode node) {
    if (node == null) return;

    if (node.left() == null && node.right() == null)
      System.out.print(node.data() + " ");

    printAllLeaves(node.left());
    printAllLeaves(node.right());
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
