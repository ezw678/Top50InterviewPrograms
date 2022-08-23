// In-order traversal of binary trees

import java.util.Stack;

public class InOrderTraversal {
  static TreeNode root;

  public static void main(String[] args) {
    root = new TreeNode(0);
    root.addLeft(new TreeNode(1));
    root.addRight(new TreeNode(2));
    root.left().addLeft(new TreeNode(3));
    root.right().addLeft(new TreeNode(4));
    root.right().addRight(new TreeNode(5));

    inOrderTraversal(root);
    System.out.println();
    inOrderTraversal2(root);
    // output: 3 1 0 4 2 5
  }

  static void inOrderTraversal(TreeNode node) {
    if (node == null) return;

    inOrderTraversal(node.left());
    System.out.print(node.data() + " ");
    inOrderTraversal(node.right());
  }

  static void inOrderTraversal2(TreeNode node) {
    if (node == null) return;

    Stack<TreeNode> stack = new Stack<>();

    TreeNode temp = node;
    while (temp != null || !stack.isEmpty()) {
      if (temp != null) {
        stack.push(temp);
        temp = temp.left();
      } else {
        temp = stack.pop();
        System.out.print(temp.data() + " ");
        temp = temp.right();
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
