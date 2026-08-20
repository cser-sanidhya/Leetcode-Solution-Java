# 3069. Distribute Elements Into Two Arrays I

## Approach
1. Create two arrays:
   - `arr1` to store the first sequence.
   - `arr2` to store the second sequence.
2. Place:
   - `nums[0]` into `arr1`.
   - `nums[1]` into `arr2`.
3. Maintain:
   - `i` as the last index used in `arr1`.
   - `j` as the last index used in `arr2`.
4. Traverse the remaining elements of `nums`.
5. For each element:
   - If the last element of `arr1` is greater than the last element of `arr2`, append the current element to `arr1`.
   - Otherwise, append it to `arr2`.
6. After processing all elements, append all elements of `arr2` to the end of `arr1`.
7. Return `arr1`, which now contains the final result array.

The idea is to distribute elements based on the comparison of the most recently added elements in both arrays.

## Algorithm
1. Let `n = nums.length`.
2. Create:
   - `arr1 = new int[n]`
   - `arr2 = new int[n]`
3. Initialize:
   - `arr1[0] = nums[0]`
   - `arr2[0] = nums[1]`
   - `i = 0`
   - `j = 0`
4. Traverse from `k = 2` to `n - 1`:
   - If `arr1[i] > arr2[j]`:
     - Increment `i`
     - Store `nums[k]` in `arr1[i]`
   - Else:
     - Increment `j`
     - Store `nums[k]` in `arr2[j]`
5. Append all elements of `arr2` to the end of `arr1`:
   - Traverse from `0` to `j`
   - Increment `i`
   - Copy `arr2[k]` into `arr1[i]`
6. Return `arr1`.

## Time Complexity
- Distributing elements: **O(n)**
- Merging `arr2` into `arr1`: **O(n)**

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the input array.

## Space Complexity
- Two additional arrays of size `n` are created:
  - `arr1`
  - `arr2`

**Overall Space Complexity:**  
**O(n)**

## Concepts
- Arrays
- Simulation
- Array Traversal
- Conditional Distribution
- Array Merging
- Greedy Decision Making
