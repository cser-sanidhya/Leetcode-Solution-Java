# 136. Single Number

## Approach
1. Traverse each element of the array.
2. For every element, count how many times it appears by comparing it with every other element.
3. If an element appears exactly once, return it immediately.
4. If no such element is found, return `-1`.

This is a brute-force approach that checks the frequency of every element using two nested loops.

## Algorithm
1. Traverse the array using index `i`.
2. Initialize `count = 0` for the current element.
3. Traverse the array again using index `j`.
4. If `nums[i] == nums[j]`, increment `count`.
5. After the inner loop:
   - If `count == 1`, return `nums[i]`.
6. If no unique element is found after checking all elements, return `-1`.

## Time Complexity
- Outer loop: **O(n)**
- Inner loop: **O(n)**

**Overall Time Complexity:**  
**O(n²)**

where:
- `n` = length of the input array.

## Space Complexity
- No extra data structures are used.
- Only the variable `count` is maintained.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Arrays
- Brute Force
- Nested Loops
- Frequency Counting
