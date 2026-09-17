# 94. Binary Tree Inorder Traversal

## Approach

1. Use an **Iterative Depth-First Search (DFS)** approach with a stack.
2. Inorder traversal follows the order:

   * Left Subtree
   * Root
   * Right Subtree
3. Start from the root node and keep moving to the left child.
4. Push every visited node onto the stack while moving left.
5. When there is no left child:

   * Pop the top node from the stack.
   * Add its value to the result list.
6. Move to the right child of the popped node.
7. Repeat the process until both:

   * The current node becomes `null`.
   * The stack becomes empty.
8. Return the inorder traversal list.

## Algorithm

1. Create an empty list `result`.
2. If `root` is `null`, return `result`.
3. Create a stack using `Deque<TreeNode>`.
4. Initialize:

   ```java
   TreeNode current = root;
   ```
5. While `current != null` or the stack is not empty:

   * Move as far left as possible:

     ```java
     while (current != null) {
         stack.push(current);
         current = current.left;
     }
     ```
6. Pop the top node from the stack.
7. Add its value to `result`.
8. Move to its right child:

   ```java
   current = current.right;
   ```
9. Continue until all nodes are processed.
10. Return `result`.

## Time Complexity

Each node is pushed onto the stack once and popped once.

**Overall Time Complexity:**
**O(n)**

where:

* `n` = number of nodes in the binary tree.

## Space Complexity

The stack stores nodes along the current path from the root to a leaf.

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
* Inorder Traversal
* Depth-First Search (DFS)
* Iterative Traversal
* Stack
* Deque
* Tree Traversal
