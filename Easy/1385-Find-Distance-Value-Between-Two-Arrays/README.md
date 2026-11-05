# 1385. Find the Distance Value Between Two Arrays

## Approach

Use **Brute Force with Nested Loops** to check whether each element in `arr1` satisfies the distance condition against every element in `arr2`.

An element `arr1[i]` is valid if its absolute difference from every element in `arr2` is strictly greater than `d`.

If any element in `arr2` has an absolute difference less than or equal to `d`, the current element is invalid.

The `valid` boolean variable tracks whether the current element satisfies the condition.

## Algorithm

1. Initialize `count = 0` to store the number of valid elements.
2. Iterate through every element of `arr1`.
3. For each element, initialize `valid = true`.
4. Iterate through every element of `arr2`.
5. Calculate the absolute difference:

   ```java
   Math.abs(arr1[i] - arr2[j])
   ```

6. If the difference is less than or equal to `d`:
   - Mark the current element as invalid.
   - Break the inner loop because no further checks are needed.
7. If the element remains valid after checking all elements of `arr2`, increment `count`.
8. Return `count`.

## Time Complexity

**O(n × m)**

- The outer loop iterates through `arr1`, which contains `n` elements.
- The inner loop iterates through `arr2`, which contains `m` elements.
- Each comparison takes constant time.

Overall: **O(n × m)**.

## Space Complexity

**O(1)**

Only a few variables (`count`, `valid`, `i`, and `j`) are used. No additional data structures are required.

## Concepts

- Brute Force
- Nested Loops
- Arrays
- Absolute Difference
- Boolean Flag
- Early Termination (`break`)
