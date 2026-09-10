# 2265. Count Nodes Equal to Average of Subtree

## Approach
1. Use **Postorder DFS Traversal** to process each subtree.
2. For every node, compute:
   - The sum of all values in its subtree.
   - The number of nodes in its subtree.
3. The average of the subtree is:

   `sum / count`

   (using integer division as specified in the problem).
4. If the current node's value equals this average:
   - Increment the answer counter.
5. Return both the subtree sum and subtree node count to the parent.
6. Continue until the entire tree has been processed.

The key idea is that a node's average depends on information from both its left and right subtrees, making **postorder traversal** the ideal approach.

## Algorithm
1. Initialize:
   - `ans = 0`
2. Perform DFS on the root.
3. For each node:
   - Recursively get:
     - Left subtree `{sum, count}`
     - Right subtree `{sum, count}`
4. Compute:
   - `sum = leftSum + rightSum + node.val`
   - `count = leftCount + rightCount + 1`
5. Check:
   - If `node.val == sum / count`
     - Increment `ans`
6. Return:
   - `{sum, count}`
7. After DFS completes:
   - Return `ans`

## Time Complexity
- Every node is visited exactly once.
- Each visit performs constant-time calculations.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = number of nodes in the binary tree.

## Space Complexity
- Recursive call stack depth equals the tree height.

**Overall Space Complexity:**  
**O(h)**

where:
- `h` = height of the tree.

Worst case (skewed tree):

**O(n)**

Balanced tree:

**O(log n)**

## Concepts
- Binary Tree
- Depth First Search (DFS)
- Postorder Traversal
- Recursion
- Tree Aggregation
- Subtree Sum
- Tree Dynamic Programming
