# Minimum Moves to Clean a Classroom

## Approach
1. Model the classroom as a graph where:
   - `S` = Starting position
   - `L` = Litter to be collected
   - `R` = Recharge station
   - `X` = Obstacle
2. Assign a unique ID to every litter cell and use a **bitmask** to track collected litter.
3. Use **Breadth-First Search (BFS)** because every move has equal cost (1 move).
4. A state consists of:
   - Current row `r`
   - Current column `c`
   - Remaining energy
   - Collected litter mask
5. When moving:
   - Energy decreases by 1.
   - Moving onto `L` updates the mask.
   - Moving onto `R` restores energy to the maximum value.
6. Use a 4D visited array to avoid revisiting the same state:
   - Position
   - Remaining energy
   - Collected litter mask
7. The first time we reach a state where all litter has been collected, the current BFS level gives the minimum number of moves.

Since BFS explores states level by level, the first valid solution is guaranteed to be optimal.

## Algorithm
1. Find:
   - Starting position `(S)`
   - All litter positions `(L)`
2. Assign each litter a unique ID.
3. Compute:
   - `targetMask = (1 << litterCount) - 1`
4. Create:
   - `visited[row][col][energy][mask]`
5. Start BFS with:
   - Position = Start cell
   - Energy = Initial energy
   - Mask = 0
6. While the queue is not empty:
   - Process all states in the current BFS level.
7. For each state:
   - If `mask == targetMask`
     - Return current moves.
   - If energy is 0
     - Skip expansion.
8. Explore all 4 directions:
   - Ignore invalid cells.
   - Ignore obstacles (`X`).
9. Update:
   - Energy = currentEnergy − 1
   - Mask if litter is collected.
10. If cell is `R`:
    - Restore energy to maximum.
11. If state is unvisited:
    - Mark visited.
    - Add to queue.
12. After processing a BFS level:
    - Increment moves.
13. If no solution exists:
    - Return `-1`.

## Time Complexity

Let:

- `m` = number of rows
- `n` = number of columns
- `E` = maximum energy
- `L` = number of litter cells

### Number of States

Each state is:

- Position → `m × n`
- Energy → `E + 1`
- Litter mask → `2^L`

Total states:

**O(m × n × E × 2^L)**

Each state explores at most 4 directions.

**Overall Time Complexity:**  

**O(m × n × E × 2^L)**

## Space Complexity

### Visited Array

Stores:

`visited[m][n][E + 1][2^L]`

### BFS Queue

Can hold the same order of states.

**Overall Space Complexity:**  

**O(m × n × E × 2^L)**

## Concepts
- Breadth-First Search (BFS)
- Graph Traversal
- State Space Search
- Bitmasking
- Multi-State BFS
- Shortest Path
- Queue
- Simulation
- Grid Traversal
- Energy Management
- Dynamic State Representation
