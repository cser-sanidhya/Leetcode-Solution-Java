# 1872. Stone Game VIII

## Approach
1. In this game, players repeatedly merge the first `x` stones (`x > 1`) into a single stone whose value is the sum of those stones.
2. Instead of simulating every move, use a **Dynamic Programming / Game Theory** observation.
3. First, compute the total prefix sum of all stones.
4. Let `best` represent the maximum score difference the current player can achieve from a given state.
5. Traverse the array from right to left:
   - Remove one stone from the running prefix sum.
   - Decide whether taking the current move gives a better result than the opponent's best response.
6. Update:

   `best = max(best, sum - best)`

7. The value of `best` after processing all valid positions is the answer.

The key insight is that after the first move, the game state can be represented using prefix sums, allowing the problem to be reduced to a simple DP recurrence.

## Algorithm
1. Let:
   - `n = stones.length`
2. Compute the total sum of all stones:
   - `sum = Σ stones[i]`
3. Initialize:
   - `best = sum`
4. Traverse from:
   - `i = n - 1` down to `2`
5. For each position:
   - Remove the current stone:
     - `sum -= stones[i]`
   - Update:
     - `best = Math.max(best, sum - best)`
6. Return:
   - `best`

## Time Complexity
- Computing the total sum: **O(n)**
- Reverse traversal: **O(n)**

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = number of stones.

## Space Complexity
- Only a few integer variables are used.
- No additional arrays or data structures are required.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Dynamic Programming
- Game Theory
- Prefix Sum
- Optimal Strategy
- Minimax Thinking
- Array Traversal
- Mathematical Optimization
