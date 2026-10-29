# 3841. Palindrome Path Queries in a Tree

## Approach

The goal is to determine whether the characters along the path between two nodes can be rearranged to form a palindrome. The solution also supports character updates at individual nodes.

We combine **Euler Tour, Lowest Common Ancestor (LCA), Bitmasking, and a Fenwick Tree** to answer queries efficiently.

1. Build an adjacency list to represent the tree.
2. Perform an Euler Tour to calculate each node's entry time (`tin`), subtree exit time (`tout`), depth, and parent.
3. Build a binary lifting table `up` to answer LCA queries efficiently.
4. Represent each character using a bitmask: `1 << (chars[u] - 'a')`.
5. Use a Fenwick Tree with XOR operations to maintain subtree character masks.
6. For an `update` query:
   - Calculate the XOR difference between the old and new character masks.
   - Apply the difference to the node's subtree using a range XOR update.
   - Update the stored character.
7. For a palindrome query between nodes `u` and `v`:
   - Find their Lowest Common Ancestor.
   - Combine the prefix XOR masks of both nodes and the LCA's character mask.
   - Check whether at most one bit is set. If so, the path characters can be rearranged into a palindrome.

## Algorithm

1. Convert the input string into a character array.
2. Build the undirected adjacency list from `edges`.
3. Calculate `LOG`, the number of binary lifting levels required.
4. Run `buildEulerTour()`:
   - Assign entry times to nodes.
   - Record each node's parent and depth.
   - Calculate subtree exit times in reverse traversal order.
5. Run `buildLCA()` to populate the binary lifting table.
6. Initialize the Fenwick Tree and apply a range XOR update for each node's subtree using its character mask.
7. Process each query:
   - **Update query:**
     - Calculate `delta = oldMask ^ newMask`.
     - Apply `rangeXor(tin[u], tout[u], delta)`.
     - Store the new character in `chars[u]`.
   - **Palindrome query:**
     - Find `ancestor = lca(u, v)`.
     - Compute the path mask:

     ```java
     int mask = bit.query(tin[u])
              ^ bit.query(tin[v])
              ^ (1 << (chars[ancestor] - 'a'));
     ```

     - Check the palindrome condition:

     ```java
     (mask & (mask - 1)) == 0
     ```

     This is true when the mask contains zero or one set bit, meaning at most one character has an odd frequency.
8. Store the Boolean result of each palindrome query and return the result list.

## Time Complexity

Let `n` be the number of tree nodes and `q` be the number of queries.

- Building the graph and Euler Tour: O(n).
- Building the LCA table: O(n log n).
- Initializing subtree masks with Fenwick updates: O(n log n).
- Each character update: O(log n).
- Each palindrome query: O(log n), dominated by the LCA calculation.

Overall Time Complexity: **O(n log n + q log n)**

## Space Complexity

- Adjacency list: O(n).
- Euler Tour arrays and binary lifting table: O(n log n).
- Fenwick Tree: O(n).
- Character array and query results: O(n + q).

Overall Space Complexity: **O(n log n + q)**, including stored query results.

## Concepts

- Tree Traversal
- Euler Tour
- Lowest Common Ancestor (LCA)
- Binary Lifting
- Bitmasking
- Bitwise XOR
- Fenwick Tree (Binary Indexed Tree)
- Range XOR Updates
- Palindrome Permutation Checking
- Efficient Query Processing
