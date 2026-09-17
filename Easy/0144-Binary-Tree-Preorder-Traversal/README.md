# 144. Binary Tree Preorder Traversal

## Approach

1. Use an **Iterative Depth-First Search (DFS)** approach with a stack.
2. Preorder traversal follows the order:

   * Root
   * Left Subtree
   * Right Subtree
3. Start by pushing the root node onto the stack.
4. While the stack is not empty:

   * Pop the top node.
   * Add its value to the result list.
5. Since a stack follows **LIFO (Last In, First Out)** order:

   * Push the right child first.
   * Push the left child second.
6. This ensures that the left child is processed before the right child.
7. Continue until all nodes have been visited.
8. Return the preorder traversal list.

## Algorithm

1. Create an empty list `result`.
2. If `root` is `null`, return `result`.
3. Create a stack using `Deque<TreeNode>`.
4. Push the root node onto the stack.
5. While the stack is not empty:

   * Pop the top node.
   * Add its value to `result`.
6. If the node has a right child:

   * Push it onto the stack.
7. If the node has a left child:

   * Push it onto the stack.
8. Repeat until the stack becomes empty.
9. Return `result`.

## Time Complexity

Each node is pushed onto the stack once and popped once.

**Overall Time Complexity:**
**O(n)**

where:

* `n` = number of nodes in the binary tree.

## Space Complexity

The stack can store up to the height of the tree.

**Auxiliary Space Complexity:**
**O(h)**

where:

* `h` = height of the tree.

In the worst case (skewed tree):

**O(n)**

In the best case (balanced tree):

**O(log n)**

## Concepts

* Binary Tree
* Preorder Traversal
* Depth-First Search (DFS)
* Iterative Traversal
* Stack
* Deque
* Tree Traversal
