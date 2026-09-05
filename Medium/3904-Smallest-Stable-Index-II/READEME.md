# 3904. First Stable Index II

## Approach
1. We need to find the first index `i` such that:

   `max(nums[0...i]) - min(nums[i...n-1]) <= k`

2. Instead of storing both prefix maximums and suffix minimums:
   - Store only the suffix minimum values in an array `rightMin`.
   - Maintain the prefix maximum using a variable `leftMax` during traversal.
3. Build `rightMin`:
   - `rightMin[i]` stores the minimum element from index `i` to the end.
4. Traverse the array from left to right:
   - Update `leftMax`.
   - Calculate:
     
     `instability = leftMax - rightMin[i]`
     
   - If `instability <= k`, return the current index.
5. If no valid index exists, return `-1`.

This optimization reduces the space usage by avoiding a separate prefix maximum array.

## Algorithm
1. Let:
   - `n = nums.length`
2. Create:
   - `rightMin[n]`
3. Initialize:
   - `rightMin[n - 1] = nums[n - 1]`
4. Build the suffix minimum array:
   - For `i = n - 2` down to `0`:
     - `rightMin[i] = min(rightMin[i + 1], nums[i])`
5. Initialize:
   - `leftMax = 0`
6. Traverse from left to right:
   - Update:
     - `leftMax = max(leftMax, nums[i])`
   - Compute:
     - `instability = leftMax - rightMin[i]`
   - If:
     - `instability <= k`
       - Return `i`
7. If no index satisfies the condition:
   - Return `-1`

## Time Complexity

### Building Suffix Minimum Array
- One traversal: **O(n)**

### Finding the First Stable Index
- One traversal: **O(n)**

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the array.

## Space Complexity
- Suffix minimum array of size `n`.

**Overall Space Complexity:**  
**O(n)**

## Concepts
- Arrays
- Suffix Minimum
- Prefix Maximum
- Preprocessing
- Greedy Checking
- Linear Traversal
- Optimization
