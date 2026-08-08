# 40. Combination Sum II

## Approach
1. Sort the array so that duplicate elements are placed together.
2. Use the **Backtracking** technique to generate all unique combinations whose sum equals the target.
3. Maintain a list `current` to store the current combination.
4. At each index, there are two choices:
   - **Take** the current element.
   - **Skip** the current element.
5. If the current element is taken:
   - Add it to the current combination.
   - Reduce the target by its value.
   - Move to the next index because each element can be used **only once**.
6. After returning from recursion, remove the last element (Backtracking).
7. Before exploring the "Skip" choice, skip all consecutive duplicate elements to avoid generating duplicate combinations.
8. If the target becomes `0`, add the current combination to the result.
9. If the target becomes negative or all elements have been processed, stop exploring that path.

Sorting and skipping duplicates ensure that each valid combination appears only once in the result.

## Algorithm
1. Sort the `candidates` array.
2. Create:
   - `result` to store all valid combinations.
   - `current` to store the current combination.
3. Call:
   - `helper(0, candidates, target, current, result)`
4. In the recursive function:
   - If `target == 0`:
     - Add a copy of `current` to `result`.
     - Return.
   - If `target < 0` or `index == candidates.length`:
     - Return.
   - **Take** the current candidate:
     - Add `candidates[index]` to `current`.
     - Recur with:
       - `index + 1`
       - `target - candidates[index]`
   - **Backtrack**:
     - Remove the last element from `current`.
   - Skip all duplicate candidates:
     - While the next candidate is the same as the current one, increment `index`.
   - **Skip** the current candidate:
     - Recur with:
       - `index + 1`
       - Same `target`
5. Return `result`.

## Time Complexity
- Every candidate has two choices:
  - Include it.
  - Exclude it.
- In the worst case, the recursion explores an exponential number of combinations.

**Overall Time Complexity:**  
**O(2ⁿ × n)**

where:
- `n` = number of candidates.

The extra factor of `n` comes from copying each valid combination into the result.

## Space Complexity
- Recursive call stack: **O(n)**
- Temporary combination list (`current`): **O(n)**
- Result stores all valid combinations.

**Auxiliary Space Complexity:**  
**O(n)**

**Overall Space Complexity (including output):**  
**O(n × 2ⁿ)**

## Concepts
- Arrays
- Sorting
- Backtracking
- Recursion
- Depth-First Search (DFS)
- Duplicate Handling
- Combinatorial Search
- Include/Exclude Pattern
