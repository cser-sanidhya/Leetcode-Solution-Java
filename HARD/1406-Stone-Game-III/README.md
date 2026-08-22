# 1406. Stone Game III

## Approach
1. Use **Dynamic Programming (DP)** to determine the maximum score difference a player can achieve from each position.
2. Let `dp[i]` represent:
   - The maximum score difference (current player's score − opponent's score) starting from index `i`.
3. At each position, the player can take:
   - 1 stone
   - 2 stones
   - 3 stones
4. Calculate the sum of stones taken and subtract the opponent's best possible result from the remaining stones.
5. Choose the move that maximizes the score difference.
6. Fill the DP array from right to left so that future states are already computed.
7. After computing `dp[0]`:
   - If `dp[0] > 0`, Alice wins.
   - If `dp[0] < 0`, Bob wins.
   - Otherwise, the game ends in a tie.

The key idea is that both players play optimally, so each player tries to maximize their advantage while minimizing the opponent's.

## Algorithm
1. Let:
   - `n = stoneValue.length`
2. Create:
   - `dp = new int[n + 1]`
3. Traverse from:
   - `i = n - 1` down to `0`
4. For each position:
   - Initialize:
     - `sum = 0`
     - `best = Integer.MIN_VALUE`
5. Try taking 1, 2, or 3 stones:
   - For `j = i` to `min(i + 2, n - 1)`:
     - Add current stone:
       - `sum += stoneValue[j]`
     - Compute score difference:
       - `sum - dp[j + 1]`
     - Update:
       - `best = max(best, sum - dp[j + 1])`
6. Store:
   - `dp[i] = best`
7. After filling DP:
   - If `dp[0] > 0` → return `"Alice"`
   - If `dp[0] < 0` → return `"Bob"`
   - Otherwise → return `"Tie"`

## Time Complexity
- For each index, we try at most 3 choices.
- There are `n` positions.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = number of stones.

## Space Complexity
- DP array of size `n + 1`.

**Overall Space Complexity:**  
**O(n)**

## Concepts
- Dynamic Programming
- Game Theory
- Minimax Thinking
- Bottom-Up DP
- Optimal Strategy
- Arrays
- Score Difference Technique
