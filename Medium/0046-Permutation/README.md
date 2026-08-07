# 46. Permutations

## Approach
1. Use the **Backtracking** technique to generate all possible permutations of the given array.
2. Maintain:
   - `currentList` to store the current permutation being formed.
   - `used[]` array to keep track of which elements have already been included in the current permutation.
3. Traverse every element in the array.
4. For each element:
   - If it has already been used, skip it.
   - Otherwise:
     - Mark it as used.
     - Add it to the current permutation.
     - Recursively generate the remaining permutation.
5. After returning from recursion, backtrack by:
   - Removing the last added element.
   - Marking it as unused.
6. When the size of `currentList` becomes equal to the length of the array, a complete permutation has been formed. Add it to the result.
7. Continue until all possible permutations are generated.

This approach ensures that every element appears exactly once in each permutation.

## Algorithm
1. Create:
   - `result` to store all permutations.
   - `currentList` to store the current permutation.
   - `used[]` initialized to `false`.
2. Call:
   - `backtrack(nums, currentList, used, result)`
3. In the recursive function:
   - If `currentList.size() == nums.length`:
     - Add a copy of `currentList` to `result`.
     - Return.
4. Traverse every element from `0` to `nums.length - 1`:
   - If `used[i]` is `true`, continue to the next element.
   - Mark `used[i] = true`.
   - Add `nums[i]` to `currentList`.
   - Recursively generate the remaining permutation.
   - Backtrack:
     - Remove the last element from `currentList`.
     - Set `used[i] = false`.
5. Return `result`.

## Time Complexity
- There are **n!** possible permutations.
- Creating each permutation requires **O(n)** time to copy it into the result.

**Overall Time Complexity:**  
**O(n × n!)**

where:
- `n` = number of elements in the input array.

## Space Complexity
- Recursive call stack: **O(n)**
- `used[]` array: **O(n)**
- `currentList`: **O(n)**
- Result stores all permutations.

**Auxiliary Space Complexity:**  
**O(n)**

**Overall Space Complexity (including output):**  
**O(n × n!)**

## Concepts
- Arrays
- Backtracking
- Recursion
- Depth-First Search (DFS)
- Permutations
- Boolean Visited Array
