# 560. Subarray Sum Equals K

## Approach
1. Use a `HashMap` to store the frequency of each prefix sum encountered while traversing the array.
2. Initialize the map with `(0, 1)` to handle subarrays that start from index `0`.
3. Maintain a running prefix sum (`sum`).
4. For each element in the array:
   - Add the current element to `sum`.
   - Check if `(sum - k)` exists in the map.
     - If it does, it means there are one or more previous prefix sums such that the subarray between them has a sum equal to `k`.
     - Add the frequency of `(sum - k)` to the answer.
   - Store the current prefix sum in the map by increasing its frequency.
5. Continue until the entire array is traversed.
6. Return the total count of subarrays whose sum equals `k`.

This approach works because if:

```
Current Prefix Sum - Previous Prefix Sum = k
```

then the subarray between those two prefix sums has a sum equal to `k`.

## Algorithm
1. Create a `HashMap<Integer, Integer>` to store:
   - **Key:** Prefix Sum
   - **Value:** Frequency of that prefix sum.
2. Insert `(0, 1)` into the map.
3. Initialize:
   - `sum = 0`
   - `count = 0`
4. Traverse the array:
   - Update `sum += num`.
   - If `(sum - k)` exists in the map:
     - Add its frequency to `count`.
   - Update the frequency of `sum` using:
     - `map.put(sum, map.getOrDefault(sum, 0) + 1)`
5. Return `count`.

## Time Complexity
- Single traversal of the array: **O(n)**
- HashMap lookup and insertion: **O(1)** (average)

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the input array.

## Space Complexity
- The `HashMap` stores the frequency of prefix sums encountered during traversal...

**Overall Space Complexity:**  
**O(n)**

## Concepts
- Arrays
- Prefix Sum
- HashMap
- Running Sum
- Frequency Counting
- Subarray
