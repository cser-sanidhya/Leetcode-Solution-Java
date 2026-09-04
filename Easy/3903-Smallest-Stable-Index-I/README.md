# 3903. First Stable Index I

## Approach
1. For every index `i`, we need:
   - The maximum value from the beginning of the array up to `i`.
   - The minimum value from `i` to the end of the array.
2. Create:
   - `prefixMax[i]` = maximum element in `nums[0...i]`
   - `suffixMin[i]` = minimum element in `nums[i...n-1]`
3. After building both arrays, check each index:
   - If `prefixMax[i] - suffixMin[i] <= k`
   - Then index `i` is stable.
4. Return the first index that satisfies the condition.
5. If no such index exists, return `-1`.

The preprocessing allows each stability check to be performed in constant time.

## Algorithm
1. Let:
   - `n = nums.length`
2. Create:
   - `prefixMax[n]`
   - `suffixMin[n]`
3. Build `prefixMax`:
   - `prefixMax[0] = nums[0]`
   - For `i = 1` to `n - 1`:
     - `prefixMax[i] = max(prefixMax[i - 1], nums[i])`
4. Build `suffixMin`:
   - `suffixMin[n - 1] = nums[n - 1]`
   - For `i = n - 2` down to `0`:
     - `suffixMin[i] = min(suffixMin[i + 1], nums[i])`
5. Traverse all indices:
   - If:
     - `prefixMax[i] - suffixMin[i] <= k`
   - Return `i`
6. If no index satisfies the condition:
   - Return `-1`

## Time Complexity
### Building Prefix Maximum Array
- One traversal: **O(n)**

### Building Suffix Minimum Array
- One traversal: **O(n)**

### Finding the First Stable Index
- One traversal: **O(n)**

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the array.

## Space Complexity
- `prefixMax` array of size `n`
- `suffixMin` array of size `n`

**Overall Space Complexity:**  
**O(n)**

## Concepts
- Arrays
- Prefix Maximum
- Suffix Minimum
- Preprocessing
- Greedy Checking
- Range Queries
- Linear Traversal
