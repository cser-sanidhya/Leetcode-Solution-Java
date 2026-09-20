# 102. Binary Tree Level Order Traversal

## Approach

1. Use **Breadth-First Search (BFS)** with a queue to traverse the tree level by level.
2. Start by adding the root node to the queue.
3. While the queue is not empty:

   * Determine the number of nodes currently in the queue.
   * This represents all nodes belonging to the current level.
4. Process exactly those nodes:

   * Remove each node from the queue.
   * Add its value to the current level list.
   * Add its left and right children to the queue if they exist.
5. After processing all nodes of the current level:

   * Add the level list to the result.
6. Repeat until all levels have been processed.
7. Return the final list containing nodes level by level.

## Algorithm

1. Create an empty list:

   ```java
   List<List<Integer>> result = new ArrayList<>();
   ```
2. If `root` is `null`, return `result`.
3. Create a queue:

   ```java
   Queue<TreeNode> queue = new LinkedList<>();
   ```
4. Add the root node to the queue.
5. While the queue is not empty:

   * Get the current level size:

     ```java
     int size = queue.size();
     ```
   * Create:

     ```java
     List<Integer> currentLevel = new ArrayList<>();
     ```
6. Process all nodes of the current level:

   ```java
   for (int i = 0; i < size; i++)
   ```
7. Remove a node from the queue:

   ```java
   TreeNode node = queue.poll();
   ```
8. Add its value to `currentLevel`.
9. If the left child exists:

   ```java
   queue.add(node.left);
   ```
10. If the right child exists:

    ```java
    queue.add(node.right);
    ```
11. After processing the entire level:

    ```java
    result.add(currentLevel);
    ```
12. Continue until the queue becomes empty.
13. Return `result`.

## Time Complexity

Each node is visited exactly once.

**Overall Time Complexity:**
**O(n)**

where:

* `n` = number of nodes in the binary tree.

## Space Complexity

The queue can store all nodes of a level at once.

**Auxiliary Space Complexity:**
**O(w)**

where:

* `w` = maximum width of the binary tree.

In the worst case:

**O(n)**

## Concepts

* Binary Tree
* Breadth-First Search (BFS)
* Queue
* Level Order Traversal
* Tree Traversal
* Iterative Traversal
* Graph Traversal
