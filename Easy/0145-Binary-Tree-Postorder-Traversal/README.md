# 145. Binary Tree Postorder Traversal

## Approach

1. Use an **Iterative Depth-First Search (DFS)** approach with a stack.
2. Postorder traversal follows the order:

   * Left Subtree
   * Right Subtree
   * Root
3. Instead of directly generating postorder, generate nodes in:

   * Root
   * Right
   * Left
4. This can be achieved using a stack:

   * Pop a node and add its value to the result.
   * Push its left child first.
   * Push its right child second.
5. Since the stack is LIFO, the right child is processed before the left child.
6. The resulting order becomes:

   * Root → Right → Left
7. Reverse the result list at the end.
8. After reversal, the order becomes:

   * Left → Right → Root (Postorder Traversal)
9. Return the final result list.

## Algorithm

1. Create an empty list `result`.
2. If `root` is `null`, return `result`.
3. Create a stack using `Deque<TreeNode>`.
4. Push the root node onto the stack.
5. While the stack is not empty:

   * Pop the top node.
   * Add its value to `result`.
6. If the node has a left child:

   * Push it onto the stack.
7. If the node has a right child:

   * Push it onto the stack.
8. Repeat until the stack becomes empty.
9. Reverse the `result` list:

   ```java
   Collections.reverse(result);
   ```
10. Return `result`.

## Time Complexity

Each node is pushed onto the stack once and popped once.

Reversing the result list also takes linear time.

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
* Postorder Traversal
* Depth-First Search (DFS)
* Iterative Traversal
* Stack
* Deque
* List Reversal
* Tree Traversal
