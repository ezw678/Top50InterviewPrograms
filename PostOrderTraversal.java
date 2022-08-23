// Post-order traversal of binary tres

import java.util.Stack;

public class PostOrderTraversal {
  static TreeNode root;

  public static void main(String[] args) {
    root = new TreeNode(0);
    root.addLeft(new TreeNode(1));
    root.addRight(new TreeNode(2));
    root.left().addLeft(new TreeNode(3));
    root.right().addLeft(new TreeNode(4));
    root.right().addRight(new TreeNode(5));

    PostOrderTraversal(root);
    System.out.println();
    PostOrderTraversal2(root);
    System.out.println();
    PostOrderTraversal3(root);
    // output: 3 1 4 5 2 0
  }

  static void PostOrderTraversal(TreeNode node) {
    if (node == null) return;

    PostOrderTraversal(node.left());
    PostOrderTraversal(node.right());
    System.out.print(node.data() + " ");
  }

  static void PostOrderTraversal2(TreeNode node) {
    if (node == null) return;

    Stack<TreeNode> stack = new Stack<>();
    stack.push(node);

    TreeNode prev = null;
    TreeNode curr = null;
    while (!stack.isEmpty()) {
      curr = stack.peek();
      if (prev == null || curr == prev.left() || curr == prev.right()) {
        if (curr.left() != null)
          stack.push(curr.left());
        else if (curr.right() != null)
          stack.push(curr.right());
        else {
          stack.pop();
          System.out.print(curr.data() + " ");
        }
      } else if (curr.left() == prev) {
        if (curr.right() != null)
          stack.push(curr.right());
        else {
          stack.pop();
          System.out.print(curr.data() + " ");
        }
      } else if (curr.right() == prev) {
        stack.pop();
        System.out.print(curr.data() + " ");
      }

      prev = curr;
    }
  }

  static void PostOrderTraversal3(TreeNode node) {
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    stack1.push(node);

    TreeNode temp;
    while (!stack1.isEmpty()) {
      temp = stack1.pop();
      stack2.push(temp);

      if (temp.left() != null)
        stack1.push(temp.left());

      if (temp.right() != null)
        stack1.push(temp.right());

    }

    while (!stack2.isEmpty()) {
      temp = stack2.pop();
      System.out.print(temp.data() + " ");
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
