# 216. Combination Sum III

## Approach
1. Use **Backtracking** to find combinations of exactly `k` distinct numbers from `1` to `9` whose sum is equal to `n`.
2. Maintain a `current` list to store the numbers selected for the current combination.
3. Start selecting numbers from `1`.
4. For every number from `start` to `9`:
   - Add the number to `current`.
   - Add it to the running `sum`.
   - Recursively search for the next number using `i + 1`.
5. Using `i + 1` ensures that:
   - The same number cannot be selected again.
   - Numbers are selected in increasing order.
6. After the recursive call, remove the last element to **backtrack**.
7. If `current.size() == k`:
   - If `sum == n`, add the combination to `result`.
   - Otherwise, discard the combination.
8. If `sum > n`, stop exploring that path because adding more positive numbers can only increase the sum.

## Algorithm
1. Create:
   - `result` to store valid combinations.
   - `current` to store the current combination.
2. Start backtracking with:
   - `start = 1`
   - `sum = 0`
3. In the recursive function:
   - If `sum > n`, return.
   - If `current.size() == k`:
     - If `sum == n`, add a copy of `current` to `result`.
     - Return.
4. Loop from `start` to `9`:
   - Add `i` to `current`.
   - Call:
     - `backtrack(i + 1, current, sum + i, k, n, result)`
   - Remove the last element from `current`.
5. Return `result`.

## Time Complexity
There are only `9` possible numbers, and each number can either be selected or skipped.

The backtracking explores combinations of these numbers.

**Overall Time Complexity:**  
**O(2⁹ × k)**

Since `9` is a constant, this can effectively be considered **O(1)** with respect to the input size.

The `k` factor accounts for copying a valid combination into the result.

## Space Complexity
- Recursion depth: **O(k)**
- `current` list: **O(k)**
- Result stores all valid combinations.

**Auxiliary Space Complexity:**  
**O(k)**

**Overall Space Complexity (including output):**  
**O(k × number of valid combinations)**

## Concepts
- Arrays
- Backtracking
- Recursion
- Depth-First Search (DFS)
- Combinatorial Search
- Running Sum
- Pruning
- Include/Exclude Pattern
