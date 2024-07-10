class ListNode:
    def __init__(self, data: int = 0):
        self.data: int = data
        self.next: ListNode = None

    def add_next(self, node: "ListNode"):
        self.next = node


head = ListNode()
node1 = ListNode(1)
node2 = ListNode(2)
node3 = ListNode(3)
node4 = ListNode(4)
node5 = ListNode(5)
node6 = ListNode(6)

head.add_next(node1)
node1.add_next(node2)
node2.add_next(node3)
node3.add_next(node4)
node4.add_next(node5)
node5.add_next(node6)
