class TreeNode:
    def __init__(self, data: int = 0):
        self.data: int = data
        self.left: TreeNode = None
        self.right: TreeNode = None

    def add_left(self, left: "TreeNode"):
        self.left = left

    def add_right(self, right: "TreeNode"):
        self.right = right


root = TreeNode(0)
node1 = TreeNode(1)
node2 = TreeNode(2)

root.add_left(node1)
root.add_right(node2)

node11 = TreeNode(3)
node12 = TreeNode(4)

node1.add_left(node11)
node1.add_right(node12)

node21 = TreeNode(5)
node22 = TreeNode(6)

node2.add_left(node21)
node2.add_right(node22)

node111 = TreeNode(7)
node112 = TreeNode(8)

node11.add_left(node111)
node11.add_right(node112)

node221 = TreeNode(9)
node22.add_left(node221)

node222 = TreeNode(10)
node22.add_right(node222)
