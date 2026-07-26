# 525. Contiguous Array

## Approach
1. Treat every `0` as `-1` and every `1` as `+1`.
2. Maintain a running prefix sum (`Sum`) while traversing the array.
3. Use a `HashMap` to store the first index where each prefix sum occurs.
4. Initialize the map with `(0, -1)` to handle subarrays starting from index `0`.
5. For each element:
   - If it is `0`, decrement the prefix sum.
   - If it is `1`, increment the prefix sum.
6. If the current prefix sum already exists in the map:
   - The subarray between the previous index and the current index has an equal number of `0`s and `1`s.
   - Calculate its length and update the maximum length.
7. If the prefix sum is seen for the first time, store its index in the map.
8. Return the maximum length found.

This works because when the same prefix sum appears again, the net sum between those two indices is `0`, meaning the subarray contains an equal number of `0`s and `1`s.

## Algorithm
1. Create a `HashMap<Integer, Integer>` to store:
   - **Key:** Prefix Sum
   - **Value:** First index where the prefix sum occurs.
2. Insert `(0, -1)` into the map.
3. Initialize:
   - `Sum = 0`
   - `maxLength = 0`
4. Traverse the array:
   - If `nums[i] == 0`, decrement `Sum`.
   - Otherwise, increment `Sum`.
5. Check if `Sum` exists in the map:
   - If yes:
     - Calculate `length = i - map.get(Sum)`.
     - Update `maxLength`.
   - Otherwise:
     - Store `(Sum, i)` in the map.
6. Return `maxLength`.

## Time Complexity
- Single traversal of the array: **O(n)**
- HashMap insertion and lookup: **O(1)** (average)

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the input array.

## Space Complexity
- HashMap stores at most one entry for each unique prefix sum.

**Overall Space Complexity:**  
**O(n)**

## Concepts
- Arrays
- Prefix Sum
- HashMap
- Running Sum
- Longest Subarray
