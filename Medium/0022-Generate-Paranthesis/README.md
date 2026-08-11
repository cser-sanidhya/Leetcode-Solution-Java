# 22. Generate Parentheses

## Approach
1. Use **Backtracking** to generate all valid combinations of parentheses.
2. Maintain two counters:
   - `open` → number of `(` used.
   - `close` → number of `)` used.
3. Add an opening parenthesis when `open < n`.
4. Add a closing parenthesis only when `close < open`.
   - This ensures that we never have more closing parentheses than opening parentheses.
5. When `open == n` and `close == n`, a complete valid combination has been created.
6. Add the current string to `result`.
7. After each recursive call, remove the last character using `deleteCharAt()` to **backtrack** and explore another possibility.

## Algorithm
1. Create:
   - `result` to store all valid combinations.
   - `current` as a `StringBuilder` to build the current combination.
2. Call:
   - `generateParentheses(current, 0, 0, n, result)`
3. In the recursive function:
   - If `open == n && close == n`:
     - Add `current.toString()` to `result`.
     - Return.
4. If `open < n`:
   - Add `'('`.
   - Recursively call with `open + 1`.
   - Remove the last character to backtrack.
5. If `close < open`:
   - Add `')'`.
   - Recursively call with `close + 1`.
   - Remove the last character to backtrack.
6. Continue until all valid combinations are generated.
7. Return `result`.

## Time Complexity
The number of valid combinations is the **nth Catalan number**:

**Cₙ = 1/(n+1) × (2n choose n)**

Each valid combination contains `2n` characters.

**Overall Time Complexity:**  
**O(Cₙ × n)**

where:
- `Cₙ` = nth Catalan number
- `n` = number of pairs of parentheses

It is often described as exponential because the number of valid combinations grows very rapidly.

## Space Complexity
- Recursion depth: **O(n)**
- `StringBuilder`: **O(n)**
- Result stores all valid combinations: **O(Cₙ × n)**

**Auxiliary Space Complexity:**  
**O(n)**

**Overall Space Complexity (including output):**  
**O(Cₙ × n)**

## Concepts
- Backtracking
- Recursion
- StringBuilder
- Catalan Numbers
- Valid Parentheses
- Constraint-Based Recursion
- Depth-First Search (DFS)
