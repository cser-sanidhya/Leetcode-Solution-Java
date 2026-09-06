# 115. Distinct Subsequences

## Approach
1. Use **Dynamic Programming (DP)** to count how many distinct subsequences of `s` equal `t`.
2. Let:
   - `dp[i][j]` represent the number of ways to form the first `j` characters of `t` using the first `i` characters of `s`.
3. Base Cases:
   - An empty string `t` can always be formed from any prefix of `s`.
     - `dp[i][0] = 1`
   - A non-empty `t` cannot be formed from an empty `s`.
     - `dp[0][j] = 0`
4. For each character:
   - Ignore the current character of `s`:
     - `dp[i][j] = dp[i-1][j]`
   - If the current characters match:
     - Add ways obtained by using this character:
       - `dp[i][j] += dp[i-1][j-1]`
5. The final answer is stored in:
   - `dp[m][n]`

The key idea is that for every matching character, we have two choices:
- Use it.
- Skip it.

## Algorithm
1. Let:
   - `m = s.length()`
   - `n = t.length()`
2. Create:
   - `dp[m + 1][n + 1]`
3. Initialize:
   - `dp[0][0] = 1`
4. Fill first column:
   - For `i = 1` to `m`
     - `dp[i][0] = 1`
5. Traverse the DP table:
   - For `i = 1` to `m`
     - For `j = 1` to `n`
6. First skip the current character:
   - `dp[i][j] = dp[i - 1][j]`
7. If:
   - `s.charAt(i - 1) == t.charAt(j - 1)`
8. Add matching contribution:
   - `dp[i][j] += dp[i - 1][j - 1]`
9. Return:
   - `dp[m][n]`

## Time Complexity
- DP table size:
  - `(m + 1) × (n + 1)`
- Each cell is computed once.

**Overall Time Complexity:**  
**O(m × n)**

where:
- `m` = length of `s`
- `n` = length of `t`

## Space Complexity
- DP table of size:
  - `(m + 1) × (n + 1)`

**Overall Space Complexity:**  
**O(m × n)**

## Concepts
- Dynamic Programming
- Strings
- Subsequences
- 2D DP
- Counting Problems
- State Transition
- Combinatorics
