# 98. Validate Binary Search Tree

## Approach

1. Use **Recursion (Depth-First Search)** with range constraints to validate the BST property.
2. For every node:

   * All values in its left subtree must be smaller than the current node.
   * All values in its right subtree must be greater than the current node.
3. Maintain a valid range `(min, max)` for each node.
4. Initially:

   ```java
   min = Long.MIN_VALUE
   max = Long.MAX_VALUE
   ```
5. For each node:

   * Its value must lie strictly between `min` and `max`.
6. Recursively validate:

   * Left subtree with range `(min, node.val)`
   * Right subtree with range `(node.val, max)`
7. If any node violates its allowed range, the tree is not a valid BST.
8. If all nodes satisfy their constraints, the tree is a valid BST.

## Algorithm

1. Call:

   ```java
   validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
   ```
2. In the recursive function:

   * If the current node is `null`:

     ```java
     return true;
     ```
3. Check whether the node value is within the valid range:

   ```java
   if (node.val <= min || node.val >= max)
       return false;
   ```
4. Recursively validate the left subtree:

   ```java
   validate(node.left, min, node.val);
   ```
5. Recursively validate the right subtree:

   ```java
   validate(node.right, node.val, max);
   ```
6. Return:

   ```java
   validate(node.left, min, node.val) &&
   validate(node.right, node.val, max);
   ```
7. If all recursive calls return `true`, the tree is a valid BST.

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

* Binary Search Tree (BST)
* Binary Tree
* Recursion
* Depth-First Search (DFS)
* Tree Traversal
* Range Validation
* Divide and Conquer
* Recursive Functions
