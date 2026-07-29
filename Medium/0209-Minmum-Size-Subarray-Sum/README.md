# 209. Minimum Size Subarray Sum

## Approach
1. Use the **Sliding Window** technique to maintain a window of contiguous elements.
2. Initialize two variables:
   - `left` → Starting index of the current window.
   - `sum` → Sum of elements inside the current window.
3. Expand the window by moving the `right` pointer and adding `nums[right]` to `sum`.
4. Whenever `sum >= target`:
   - Update the minimum subarray length.
   - Shrink the window from the left by subtracting `nums[left]` from `sum`.
   - Increment `left`.
5. Continue expanding and shrinking until the entire array is traversed.
6. If no valid subarray is found, return `0`; otherwise, return the minimum length.

This approach works because all numbers in the array are positive. Once the window sum reaches or exceeds the target, removing elements from the left is the only way to find a smaller valid subarray.

## Algorithm
1. Initialize:
   - `left = 0`
   - `sum = 0`
   - `minLength = Integer.MAX_VALUE`
2. Traverse the array using `right` from `0` to `nums.length - 1`.
3. Add `nums[right]` to `sum`.
4. While `sum >= target`:
   - Update:
     - `minLength = Math.min(minLength, right - left + 1)`
   - Remove `nums[left]` from `sum`.
   - Increment `left`.
5. After the traversal:
   - If `minLength == Integer.MAX_VALUE`, return `0`.
   - Otherwise, return `minLength`.

## Time Complexity
- Each element is added to the window once and removed from the window at most once.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the input array.

## Space Complexity
- Only three variables (`left`, `sum`, `minLength`) and the `right` pointer are used.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Arrays
- Sliding Window
- Two Pointers
- Running Sum
- Window Shrinking
- One-pass Traversal
