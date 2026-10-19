# 2089. Find Target Indices After Sorting Array

## Approach

The goal is to find all indices where the target value appears after sorting the array in non-decreasing order.

1. Sort the array in ascending order.
2. Create an empty list to store the target indices.
3. Traverse the sorted array.
4. Whenever an element equals the target, add its index to the result list.
5. Return the list containing all target indices.

## Algorithm

1. Sort the array using `Arrays.sort(nums)`.
2. Initialize an empty `ArrayList<Integer>` named `result`.
3. Iterate through the array from index `0` to `nums.length - 1`.
4. If `nums[i] == target`, add `i` to `result`.
5. Return `result`.

## Time Complexity

- Sorting the array takes O(n log n).
- Traversing the array takes O(n).

Overall Time Complexity: **O(n log n)**

## Space Complexity

- The result list requires O(n) space in the worst case.
- The sorting implementation may also use auxiliary space.

Overall Space Complexity: **O(n)**, excluding sorting-related auxiliary space.

## Concepts

- Array Sorting
- Linear Traversal
- ArrayList
- Index-Based Searching
