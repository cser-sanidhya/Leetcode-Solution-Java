# 128. Longest Consecutive Sequence

## Approach
1. Handle the edge case where the array is empty by returning `0`.
2. Assume each element in the array is the starting point of a consecutive sequence.
3. For every element:
   - Set it as the current number.
   - Initialize the current sequence length to `1`.
4. Repeatedly search the entire array for the next consecutive number (`current + 1`).
5. If the next number is found:
   - Update the current number.
   - Increase the sequence length.
6. Continue until no consecutive number is found.
7. Update the maximum sequence length after checking every starting element.
8. Return the longest consecutive sequence length.

This brute-force approach checks every possible starting point and repeatedly searches the entire array for the next consecutive number.

## Algorithm
1. If the array is empty, return `0`.
2. Initialize:
   - `maxSequence = 1`
3. Traverse the array using index `i`.
4. For each element:
   - Set:
     - `current = nums[i]`
     - `currentSequence = 1`
5. Repeatedly:
   - Search the entire array for `current + 1`.
   - If found:
     - Update `current`.
     - Increment `currentSequence`.
   - Otherwise, stop searching for that sequence.
6. Update:
   - `maxSequence = Math.max(maxSequence, currentSequence)`
7. Return `maxSequence`.

## Time Complexity
- Outer loop: **O(n)**
- Inner search loop: **O(n)**
- The `while` loop may execute up to **O(n)** times in the worst case.

**Overall Time Complexity:**  
**O(n³)**

where:
- `n` = length of the input array.

## Space Complexity
- Only a few variables (`current`, `currentSequence`, `maxSequence`, and `found`) are used.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Arrays
- Brute Force
- Nested Loops
- Linear Search
- Consecutive Sequence
