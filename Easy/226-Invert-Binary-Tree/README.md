# 226. Invert Binary Tree

## Approach

1. Use **Recursion (Depth-First Search)** to invert the binary tree.
2. For every node:

   * Swap its left and right children.
3. After swapping:

   * Recursively invert the left subtree.
   * Recursively invert the right subtree.
4. Continue this process until all nodes have been processed.
5. The base case occurs when the current node is `null`.
6. Return the root of the inverted tree.

## Algorithm

1. If `root` is `null`:

   ```java
   return null;
   ```
2. Store the left child in a temporary variable:

   ```java
   TreeNode temp = root.left;
   ```
3. Swap the left and right children:

   ```java
   root.left = root.right;
   root.right = temp;
   ```
4. Recursively invert the left subtree:

   ```java
   root.left = invertTree(root.left);
   ```
5. Recursively invert the right subtree:

   ```java
   root.right = invertTree(root.right);
   ```
6. Return the current root:

   ```java
   return root;
   ```

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
* Tree Manipulation
* Divide and Conquer
* Recursive Functions
