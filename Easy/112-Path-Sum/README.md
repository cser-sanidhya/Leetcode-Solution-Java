# 112. Path Sum

## Approach

1. Use **Recursion (Depth-First Search)** to explore all root-to-leaf paths.
2. At each node:

   * Subtract the node's value from the remaining `targetSum`.
3. Continue recursively for the left and right subtrees.
4. When a leaf node is reached:

   * Check whether the remaining sum becomes `0`.
5. If the remaining sum is `0`, a valid root-to-leaf path exists.
6. Otherwise, continue searching in other paths.
7. Return `true` if either the left or right subtree contains a valid path.
8. Return `false` if no such path exists.

## Algorithm

1. If the current node is `null`:

   ```java
   return false;
   ```
2. Subtract the current node value from `targetSum`:

   ```java
   targetSum -= root.val;
   ```
3. Check if the current node is a leaf node:

   ```java
   root.left == null && root.right == null
   ```
4. If it is a leaf:

   ```java
   return targetSum == 0;
   ```
5. Recursively search the left subtree:

   ```java
   hasPathSum(root.left, targetSum);
   ```
6. Recursively search the right subtree:

   ```java
   hasPathSum(root.right, targetSum);
   ```
7. Return:

   ```java
   hasPathSum(root.left, targetSum) ||
   hasPathSum(root.right, targetSum);
   ```
8. If either recursive call returns `true`, a valid path exists.

## Time Complexity

Each node is visited at most once.

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
* Root-to-Leaf Path
* Backtracking
* Recursive Functions
* Path Sum
