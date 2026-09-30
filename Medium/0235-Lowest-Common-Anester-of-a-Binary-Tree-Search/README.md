# 235. Lowest Common Ancestor of a Binary Search Tree

## Approach

1. Use the **Binary Search Tree (BST) property** to find the Lowest Common Ancestor (LCA).
2. For every node, compare its value with the values of `p` and `q`.
3. If both `p` and `q` are smaller than the current node:

   * The LCA must be in the **left subtree**.
4. If both `p` and `q` are greater than the current node:

   * The LCA must be in the **right subtree**.
5. Otherwise, the current node is the LCA.

   * This happens when `p` and `q` lie on different sides of the current node.
   * It also happens when the current node is equal to either `p` or `q`.
6. Use an iterative approach to move down the tree until the LCA is found.

## Algorithm

1. Start with:

   ```java
   root
   ```
2. While `root` is not `null`:
3. If both `p` and `q` are smaller than `root`:

   ```java
   root = root.left;
   ```
4. Else if both `p` and `q` are greater than `root`:

   ```java
   root = root.right;
   ```
5. Otherwise:

   ```java
   return root;
   ```

   The current node is the Lowest Common Ancestor.
6. If the loop ends without finding an LCA, return `null`.

## Time Complexity

At each step, we move down one level of the BST.

**Overall Time Complexity:**
**O(h)**

where:

* `h` = height of the BST.

For a balanced BST:

**O(log n)**

For a skewed BST:

**O(n)**

## Space Complexity

The solution uses only a few variables and does not use recursion or extra data structures.

**Overall Space Complexity:**
**O(1)**

## Concepts

* Binary Search Tree (BST)
* Lowest Common Ancestor (LCA)
* Iterative Traversal
* BST Properties
* Tree Traversal
* Two-Pointer Comparison
* Constant Space
* Greedy Decision Making
