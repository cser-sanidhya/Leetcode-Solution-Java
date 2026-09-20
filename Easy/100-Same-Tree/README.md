# 100. Same Tree

## Approach

1. Use **Recursion (Depth-First Search)** to compare both trees simultaneously.
2. For two trees to be identical:

   * Their root values must be equal.
   * Their left subtrees must be identical.
   * Their right subtrees must be identical.
3. Handle the base cases first:

   * If both nodes are `null`, they are identical.
   * If one node is `null` and the other is not, the trees are different.
4. Compare the values of the current nodes.
5. Recursively compare:

   * Left subtree of both trees.
   * Right subtree of both trees.
6. Return `true` only if all comparisons are successful.

## Algorithm

1. If both nodes are `null`:

   ```java
   return true;
   ```
2. If one node is `null` and the other is not:

   ```java
   return false;
   ```
3. If the node values are different:

   ```java
   return false;
   ```
4. Recursively compare the left subtrees:

   ```java
   isSameTree(p.left, q.left)
   ```
5. Recursively compare the right subtrees:

   ```java
   isSameTree(p.right, q.right)
   ```
6. Return:

   ```java
   isSameTree(p.left, q.left) &&
   isSameTree(p.right, q.right);
   ```
7. If all recursive calls return `true`, the trees are identical.

## Time Complexity

Each node of both trees is visited once.

**Overall Time Complexity:**
**O(n)**

where:

* `n` = number of nodes in the trees.

## Space Complexity

The recursion stack depends on the height of the trees.

**Auxiliary Space Complexity:**
**O(h)**

where:

* `h` = height of the tree.

For a balanced tree:

**O(log n)**

For a skewed tree:

**O(n)**

## Concepts

* Binary Tree
* Recursion
* Depth-First Search (DFS)
* Tree Traversal
* Structural Comparison
* Divide and Conquer
* Recursive Functions
