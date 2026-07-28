# 3. 3Sum

## Approach
1. Sort the array to enable the Two Pointer technique.
2. Iterate through the array and fix one element at a time.
3. Use two pointers (left and right) to find two numbers whose sum with the fixed element equals 0.
4. If the sum is:
   - 0 → Store the triplet, move both pointers, and skip duplicate values.
   - Less than 0 → Move the left pointer to increase the sum.
   - Greater than 0 → Move the right pointer to decrease the sum.
5. Skip duplicate fixed elements to avoid duplicate triplets.

## Time Complexity
- Sorting: O(n log n)
- Two Pointer Traversal: O(n²)
- Overall: O(n²)

## Space Complexity
- Auxiliary Space: O(1) (excluding the output list)
- Output Space: O(k), where k is the number of unique triplets.

## Concepts
- Arrays
- Sorting
- Two Pointers
- Duplicate Handling
