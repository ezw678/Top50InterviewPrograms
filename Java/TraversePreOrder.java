// Pre-order traversal of binary trees

import java.util.Stack;

public class TraversePreOrder {
  static TreeNode root;

  public static void main(String[] args) {
    root = new TreeNode(0);
    root.addLeft(new TreeNode(1));
    root.addRight(new TreeNode(2));
    root.left().addLeft(new TreeNode(3));
    root.right().addLeft(new TreeNode(4));
    root.right().addRight(new TreeNode(5));

    preOrderTraversal(root);
    System.out.println();
    preOrderTraversal2(root);
    // output: 0 1 3 2 4 5
  }

  static void preOrderTraversal(TreeNode node) {
    if (node == null) return;

    System.out.print(node.data() + " ");
    preOrderTraversal(node.left());
    preOrderTraversal(node.right());
  }

  static void preOrderTraversal2(TreeNode node) {
    if (node == null) return;

    Stack<TreeNode> stack = new Stack<>();
    stack.push (node);

    TreeNode temp;
    while (!stack.isEmpty()) {
      temp = stack.pop();
      System.out.print(temp.data() + " ");

      if (temp.right() != null)
        stack.push(temp.right());

      if (temp.left() != null)
        stack.push(temp.left());
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
