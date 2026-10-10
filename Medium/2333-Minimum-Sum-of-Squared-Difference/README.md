# 2333. Minimum Sum of Squared Difference

## Approach
1. Use a **Greedy Approach + Frequency Counting** to minimize the sum of squared differences.
2. Calculate the absolute difference between corresponding elements of `nums1` and `nums2`.
3. Store the maximum difference in `maxDiff`.
4. If `maxDiff == 0`, all elements are already equal, so return `0`.
5. Create a frequency array `count` where `count[d]` stores the number of elements having an absolute difference of `d`.
6. Calculate the total number of available operations:
   - `k = k1 + k2`
7. Process differences from the largest value down to `1`:
   - If enough operations are available, reduce all differences of the current value by `1`.
   - Transfer their frequencies to the next smaller difference.
   - Otherwise, reduce as many differences as possible and stop.
8. Since squaring larger differences contributes more to the sum, reducing the largest differences first helps minimize the result.
9. Calculate the final sum of squared differences using the frequency array.
10. Return the minimum sum.

## Algorithm
1. Initialize:
   ```java
   int n = nums1.length;
   long k = (long) k1 + k2;
   int maxDiff = 0;
   ```
2. Traverse both arrays and find the maximum absolute difference:
   ```java
   maxDiff = Math.max(
       maxDiff,
       Math.abs(nums1[i] - nums2[i])
   );
   ```
3. If `maxDiff == 0`, return `0`.
4. Create a frequency array:
   ```java
   long[] count = new long[maxDiff + 1];
   ```
5. Count the frequency of every absolute difference:
   ```java
   int diff = Math.abs(nums1[i] - nums2[i]);
   count[diff]++;
   ```
6. Traverse differences from `maxDiff` down to `1`.
7. If `count[d] == 0`, skip that difference.
8. If `k >= count[d]`:
   - Use `count[d]` operations to reduce every difference by `1`.
   - Decrease `k` by `count[d]`.
   - Transfer the frequency to `count[d - 1]`.
9. Otherwise:
   - Use the remaining operations to reduce some differences.
   - Update:
     ```java
     count[d - 1] += k;
     count[d] -= k;
     k = 0;
     ```
   - Stop processing further differences.
10. Calculate the final sum:
    ```java
    minSumSquare += count[d] * (long) d * d;
    ```
11. Return `minSumSquare`.

## Time Complexity

- Finding the maximum difference: **O(n)**
- Building the frequency array: **O(n)**
- Reducing differences: **O(maxDiff)**
- Calculating the final sum: **O(maxDiff)**

**Overall Time Complexity:**  
**O(n + maxDiff)**

where:
- `n` = length of the arrays.
- `maxDiff` = maximum absolute difference between corresponding elements.

## Space Complexity

The frequency array stores the count of each possible difference.

**Overall Space Complexity:**  
**O(maxDiff)**

## Concepts
- Arrays
- Greedy
- Frequency Counting
- Absolute Difference
- Mathematical Optimization
- Squared Differences
- Long Data Type
- Space-Time Optimization
