# 39. Combination Sum

## Approach
1. Use the **Backtracking** technique to generate all possible combinations whose sum equals the target.
2. Maintain a list `currentCombination` to store the current combination being formed.
3. Start from the first candidate and recursively explore two choices:
   - **Take** the current candidate.
   - **Skip** the current candidate.
4. If the current candidate is taken:
   - Add it to `currentCombination`.
   - Reduce the target by its value.
   - Stay at the same index because the same element can be used multiple times.
5. After returning from recursion, remove the last element (Backtracking) to restore the previous state.
6. If the current candidate is skipped:
   - Move to the next index.
7. If the target becomes `0`, a valid combination is found. Add a copy of `currentCombination` to the result.
8. If the target becomes negative or all candidates have been processed, stop exploring that path.

This approach explores all valid combinations while using backtracking to efficiently undo choices and explore alternative possibilities.

## Algorithm
1. Create:
   - `result` to store all valid combinations.
   - `currentCombination` to store the current combination.
2. Call:
   - `generateCombination(0, candidates, target, currentCombination, result)`
3. In the recursive function:
   - If `target == 0`:
     - Add a copy of `currentCombination` to `result`.
     - Return.
   - If `target < 0` or `index == candidates.length`:
     - Return.
   - **Take** the current candidate:
     - Add `candidates[index]` to `currentCombination`.
     - Recur with:
       - Same `index`
       - `target - candidates[index]`
   - **Backtrack**:
     - Remove the last element from `currentCombination`.
   - **Skip** the current candidate:
     - Recur with:
       - `index + 1`
       - Same `target`
4. Return `result`.

## Time Complexity
- In the worst case, every candidate can be chosen multiple times, and the recursion explores many possible combinations.
- The worst-case time complexity is exponential.

**Overall Time Complexity:**  
**O(2ᵗ)** *(worst-case exponential)*

where:
- `t` = target value.

> The exact complexity depends on the target value and the candidate numbers, so it is generally expressed as **exponential**.

## Space Complexity
- Recursive call stack: **O(target)** (maximum recursion depth when repeatedly choosing the same candidate).
- Temporary combination list: **O(target)**.
- Result list stores all valid combinations.

**Auxiliary Space Complexity:**  
**O(target)**

**Overall Space Complexity (including output):**  
**O(target + total size of all combinations)**

## Concepts
- Arrays
- Backtracking
- Recursion
- Depth-First Search (DFS)
- Include/Exclude Pattern
- Combinatorial Search
