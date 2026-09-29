# 230. Kth Smallest Element in a BST

## Approach

1. Use **Inorder Traversal (DFS)** because inorder traversal of a Binary Search Tree visits nodes in **ascending sorted order**.
2. Maintain a global variable `k` to track how many nodes still need to be visited.
3. Traverse the left subtree first because it contains smaller values.
4. After returning from the left subtree:

   * Decrement `k`.
5. When `k == 0`:

   * The current node is the **kth smallest element**.
   * Store its value in `answer`.
6. Continue recursively with the right subtree if the kth smallest element has not yet been found.
7. Return the stored `answer`.

## Algorithm

1. Store the given `k`:

   ```java
   this.k = k;
   ```
2. Start the inorder traversal:

   ```java
   solve(root);
   ```
3. In the recursive function, if the current node is `null`:

   ```java
   return;
   ```
4. Traverse the left subtree:

   ```java
   solve(root.left);
   ```
5. Process the current node by decrementing:

   ```java
   k--;
   ```
6. If:

   ```java
   k == 0
   ```

   store:

   ```java
   answer = root.val;
   ```
7. Traverse the right subtree:

   ```java
   solve(root.right);
   ```
8. After traversal, return:

   ```java
   answer
   ```

## Time Complexity

In the worst case, the inorder traversal may visit all nodes of the tree.

**Overall Time Complexity:**
**O(n)**

where:

* `n` = number of nodes in the Binary Search Tree.

With early discovery of the kth element, only part of the tree may need to be processed.

## Space Complexity

The recursion stack depends on the height of the tree.

**Auxiliary Space Complexity:**
**O(h)**

where:

* `h` = height of the BST.

For a balanced BST:

**O(log n)**

For a skewed BST:

**O(n)**

## Concepts

* Binary Search Tree (BST)
* Inorder Traversal
* Depth-First Search (DFS)
* Recursion
* Tree Traversal
* Kth Smallest Element
* Sorted Order Property of BST
* Recursive Functions
