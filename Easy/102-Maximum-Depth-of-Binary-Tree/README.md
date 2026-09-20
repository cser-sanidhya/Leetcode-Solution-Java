# 104. Maximum Depth of Binary Tree

## Approach

1. Use **Recursion (Depth-First Search)** to compute the depth of the binary tree.
2. The depth of a node depends on the maximum depth of its left and right subtrees.
3. For each node:

   * Recursively calculate the depth of the left subtree.
   * Recursively calculate the depth of the right subtree.
4. Take the maximum of the two depths and add `1` for the current node.
5. The base case occurs when the node is `null`:

   * A null node contributes a depth of `0`.
6. The recursion continues until all nodes have been processed.
7. Return the depth calculated for the root node.

## Algorithm

1. If `root` is `null`:

   ```java
   return 0;
   ```
2. Recursively calculate:

   ```java
   int left = maxDepth(root.left);
   ```
3. Recursively calculate:

   ```java
   int right = maxDepth(root.right);
   ```
4. Compute the maximum depth:

   ```java
   return Math.max(left, right) + 1;
   ```
5. The returned value represents the maximum depth of the binary tree.

## Time Complexity

Each node is visited exactly once.

**Overall Time Complexity:**
**O(n)**

where:

* `n` = number of nodes in the binary tree.

## Space Complexity

The recursion stack depends on the height of the tree.

**Auxiliary Space Complexity:**
**O(h)**

where:

* `h` = height of the binary tree.

For a balanced tree:

**O(log n)**

For a skewed tree:

**O(n)**

## Concepts

* Binary Tree
* Recursion
* Depth-First Search (DFS)
* Tree Traversal
* Divide and Conquer
* Tree Height
* Recursive Functions
