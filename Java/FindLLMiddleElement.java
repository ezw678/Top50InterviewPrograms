// Finding Middle element of linked list in one pass

public class FindLLMiddleElement {

	public static void main(String[] args) {
		ListNode root = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);

		root.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		ListNode temp = findLLMiddleElement(root);
		System.out.println(temp.data);
		// output: 2
	}

	static ListNode findLLMiddleElement(ListNode node) {
		if (node == null)
			return null;

		ListNode fast = node;
		ListNode slow = node;

		while (true) {
			fast = fast.next.next;
			if (fast.next == null || fast.next.next == null) {
				break;
			} else
				slow = slow.next;
		}

		return slow.next;
	}

}

class ListNode {
	int data;
	ListNode next = null;

	ListNode(int data) {
		this.data = data;
	}
}
