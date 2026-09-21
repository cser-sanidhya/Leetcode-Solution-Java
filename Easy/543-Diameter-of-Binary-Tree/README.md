# 543. Diameter of Binary Tree

## Approach

1. Use **Depth-First Search (DFS)** to calculate the height of each subtree.
2. For every node:

   * Compute the height of its left subtree.
   * Compute the height of its right subtree.
3. The longest path passing through the current node is:

   ```java
   leftHeight + rightHeight
   ```
4. Update the global `diameter` variable whenever a larger path is found.
5. Return the height of the current node to its parent:

   ```java
   Math.max(leftHeight, rightHeight) + 1
   ```
6. Continue recursively until all nodes have been processed.
7. The final value stored in `diameter` represents the maximum number of edges in any path between two nodes.

## Algorithm

1. Create a global variable:

   ```java
   int diameter = 0;
   ```
2. Call:

   ```java
   height(root);
   ```
3. In the `height()` function:

   * If the node is `null`:

     ```java
     return 0;
     ```
4. Recursively calculate:

   ```java
   int left = height(root.left);
   int right = height(root.right);
   ```
5. Update the diameter:

   ```java
   diameter = Math.max(diameter, left + right);
   ```
6. Return the height of the current node:

   ```java
   return Math.max(left, right) + 1;
   ```
7. After DFS completes:

   ```java
   return diameter;
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
* Depth-First Search (DFS)
* Recursion
* Tree Height
* Diameter of Tree
* Postorder Traversal
* Divide and Conquer
* Recursive Functions
