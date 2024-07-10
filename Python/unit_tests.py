import unittest

from top50 import reverse_linked_list_recursive
from list_node import ListNode


class TestReverseLinkedList(unittest.TestCase):
    def setUp(self):
        self.node1 = ListNode(1)
        self.node2 = ListNode(2)
        self.node3 = ListNode(3)
        self.node4 = ListNode(4)
        self.node1.add_next(self.node2)
        self.node2.add_next(self.node3)
        self.node3.add_next(self.node4)

    def test_reverse_empty_list(self):
        self.assertIsNone(reverse_linked_list_recursive(None))

    def test_reverse_single_node_list(self):
        head = ListNode(1)
        reversed_head = reverse_linked_list_recursive(head)
        self.assertEqual(reversed_head.data, 1)
        self.assertIsNone(reversed_head.next)

    def test_reverse_multi_node_list(self):
        reversed_head = reverse_linked_list_recursive(self.node1)
        self.assertEqual(reversed_head.data, 4)
        self.assertEqual(reversed_head.next.data, 3)
        self.assertEqual(reversed_head.next.next.data, 2)
        self.assertEqual(reversed_head.next.next.next.data, 1)
        self.assertIsNone(reversed_head.next.next.next.next)


if __name__ == "__main__":
    unittest.main()
