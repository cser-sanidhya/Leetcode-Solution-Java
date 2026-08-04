# 78. Subsets

## Approach
1. Use the **Backtracking** technique to generate all possible subsets.
2. Maintain a list `currentSubset` to store the elements of the current subset.
3. At every index, there are two choices:
   - **Take** the current element.
   - **Skip** the current element.
4. Recursively explore both choices.
5. When the index reaches the end of the array, add a copy of the current subset to the result list.
6. Before exploring the "Skip" choice, remove the last added element (Backtracking) to restore the previous state.
7. Continue until all possible subsets are generated.

This approach explores every possible combination of elements, resulting in all subsets (the power set).

## Algorithm
1. Create:
   - `result` to store all subsets.
   - `currentSubset` to store the current subset.
2. Call the recursive function:
   - `generateSubsets(0, nums, currentSubset, result)`
3. In the recursive function:
   - If `index == nums.length`:
     - Add a copy of `currentSubset` to `result`.
     - Return.
   - **Take** the current element:
     - Add `nums[index]` to `currentSubset`.
     - Recur for the next index.
   - **Backtrack**:
     - Remove the last element from `currentSubset`.
   - **Skip** the current element:
     - Recur for the next index.
4. Return `result`.

## Time Complexity
- Every element has **2 choices**:
  - Include it.
  - Exclude it.
- Total number of subsets = **2ⁿ**.
- Copying each subset takes up to **O(n)** time.

**Overall Time Complexity:**  
**O(n × 2ⁿ)**

where:
- `n` = number of elements in the input array.

## Space Complexity
- Recursive call stack: **O(n)**
- Temporary subset (`currentSubset`): **O(n)**
- Result stores all subsets: **O(n × 2ⁿ)**

**Auxiliary Space Complexity:**  
**O(n)**

**Overall Space Complexity (including output):**  
**O(n × 2ⁿ)**

## Concepts
- Arrays
- Backtracking
- Recursion
- Power Set
- Depth-First Search (DFS)
- Include/Exclude Pattern.
