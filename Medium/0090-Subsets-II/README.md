# 90. Subsets II

## Approach
1. Sort the array so that all duplicate elements are placed next to each other.
2. Use the **Backtracking** technique to generate all possible subsets.
3. Maintain a list `currentSubset` to store the current subset.
4. At every index, there are two choices:
   - **Take** the current element.
   - **Skip** the current element.
5. After exploring the "Take" choice, backtrack by removing the last element.
6. Before exploring the "Skip" choice, skip all consecutive duplicate elements to avoid generating duplicate subsets.
7. When the index reaches the end of the array, add a copy of the current subset to the result.
8. Continue until every valid unique subset has been generated.

Sorting combined with skipping duplicate elements ensures that each subset is generated exactly once.

## Algorithm
1. Sort the input array using `Arrays.sort(nums)`.
2. Create:
   - `result` to store all unique subsets.
   - `currentSubset` to store the current subset.
3. Call:
   - `generateSubsets(0, nums, currentSubset, result)`
4. In the recursive function:
   - If `index == nums.length`:
     - Add a copy of `currentSubset` to `result`.
     - Return.
   - **Take** the current element:
     - Add `nums[index]` to `currentSubset`.
     - Recur for the next index.
   - **Backtrack**:
     - Remove the last element from `currentSubset`.
   - Skip all consecutive duplicate elements:
     - While the next element is the same as the current one, increment `index`.
   - **Skip** the current element:
     - Recur for the next index.
5. Return `result`.

## Time Complexity
- Every element has two choices: include or exclude.
- In the worst case (when there are no duplicates), all possible subsets are generated.
- Total subsets = **2ⁿ**.
- Copying each subset takes up to **O(n)** time.

**Overall Time Complexity:**  
**O(n × 2ⁿ)**

where:
- `n` = number of elements in the input array.

> Duplicate elements reduce the actual number of recursive calls, but the worst-case complexity remains **O(n × 2ⁿ)**.

## Space Complexity
- Recursive call stack: **O(n)**
- Temporary subset (`currentSubset`): **O(n)**
- Result stores all unique subsets.

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
- Power Set
