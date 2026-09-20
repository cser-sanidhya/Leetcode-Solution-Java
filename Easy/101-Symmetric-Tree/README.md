# 101. Symmetric Tree

## Approach

1. Use **Recursion (Depth-First Search)** to check whether the tree is a mirror of itself.
2. Two nodes are mirror images if:

   * Their values are equal.
   * The left child of one node matches the right child of the other.
   * The right child of one node matches the left child of the other.
3. Create a helper function `isMirror(left, right)` to compare two subtrees.
4. Handle the base cases:

   * If both nodes are `null`, they are symmetric.
   * If only one node is `null`, they are not symmetric.
5. Compare the values of the current nodes.
6. Recursively compare:

   * `left.left` with `right.right`
   * `left.right` with `right.left`
7. If all mirror comparisons return `true`, the tree is symmetric.
8. Start the process by comparing the left and right subtrees of the root.

## Algorithm

1. Call:

   ```java
   isMirror(root.left, root.right);
   ```
2. In the helper function:

   * If both nodes are `null`:

     ```java
     return true;
     ```
3. If one node is `null` and the other is not:

   ```java
   return false;
   ```
4. If the node values are different:

   ```java
   return false;
   ```
5. Recursively compare the outer children:

   ```java
   isMirror(left.left, right.right)
   ```
6. Recursively compare the inner children:

   ```java
   isMirror(left.right, right.left)
   ```
7. Return:

   ```java
   isMirror(left.left, right.right) &&
   isMirror(left.right, right.left);
   ```
8. The result determines whether the tree is symmetric.

## Time Complexity

Each node is visited once during the mirror comparison.

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
* Mirror Tree
* Structural Comparison
* Divide and Conquer
* Recursive Functions
