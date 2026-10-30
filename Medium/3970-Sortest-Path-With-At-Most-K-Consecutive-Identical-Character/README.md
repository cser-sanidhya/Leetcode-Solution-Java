# 3970. Shortest Path With At Most K Consecutive Identical Character

## Approach

The goal is to find the minimum cost path from node `0` to node `n - 1`, while ensuring that the number of consecutive nodes having the same label does not exceed `k`.

We use **Dijkstra's Algorithm with State Expansion**, where each state consists of the current node and the number of consecutive nodes sharing the same label.

1. Build a directed adjacency list containing destination nodes and edge weights.
2. Maintain a 2D distance array `dist[node][count]`, where:
   - `node` represents the current vertex.
   - `count` represents the number of consecutive nodes with the same label.
3. Initialize `dist[0][1] = 0` because the starting node contributes one to the consecutive count.
4. Use a PriorityQueue to process states in increasing order of path cost.
5. For every neighboring node:
   - If its label matches the current node's label, increment the consecutive count.
   - Otherwise, reset the count to `1`.
6. Skip the transition if the updated count exceeds `k`.
7. Relax the distance if a cheaper path is found.
8. When the destination node is removed from the priority queue with its minimum cost, return that cost.
9. If the destination cannot be reached, return `-1`.

## Algorithm

1. Create an adjacency list using `ArrayList<int[]>`.
2. Add each directed edge with its destination and weight.
3. Initialize `dist` with dimensions `n × (k + 1)` and fill it with `Long.MAX_VALUE`.
4. Set the initial state:

   ```java
   dist[0][1] = 0;
   pq.offer(new long[]{0, 0, 1});
   ```

5. Process states using Dijkstra's Algorithm:
   - Extract the state with the minimum cost.
   - Retrieve `cost`, `u`, and `count`.
   - Skip outdated states if `cost != dist[u][count]`.
6. If `u == n - 1`, return the current cost.
7. Explore all outgoing edges:
   - Calculate `nextCount` based on whether the current and next node labels match.
   - Skip if `nextCount > k`.
   - Calculate `newCost = cost + weight`.
   - If `newCost` is smaller than the existing distance, update the distance and insert the new state into the priority queue.
8. Return `-1` if no valid path reaches the destination.

## Time Complexity

Let `n` be the number of vertices, `E` be the number of edges, and `k` be the maximum allowed consecutive count.

- Building the adjacency list: O(n + E).
- Initializing the distance array: O(nk).
- There are at most O(nk) states.
- Each state processes its outgoing edges, resulting in at most O(Ek) edge relaxations.
- PriorityQueue operations take O(log(nk)) per insertion or removal.

Overall Time Complexity: **O(nk + Ek log(nk))**

## Space Complexity

- Adjacency list: O(n + E).
- Distance array: O(nk).
- PriorityQueue: O(nk) states in the worst case.

Overall Space Complexity: **O(n + E + nk)**

## Concepts

- Dijkstra's Algorithm
- PriorityQueue (Min Heap)
- Graph Representation
- Shortest Path
- State Expansion
- Dynamic Programming on Graph States
- Distance Relaxation
- Greedy Algorithm
