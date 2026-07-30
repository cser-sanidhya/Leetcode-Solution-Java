# 1004. Max Consecutive Ones III

## Approach
1. Use the **Sliding Window** technique to maintain a window of consecutive elements.
2. Keep track of:
   - `left` → Starting index of the current window.
   - `zeroCount` → Number of zeros in the current window.
3. Expand the window by moving the `right` pointer.
4. If the current element is `0`, increment `zeroCount`.
5. If `zeroCount` becomes greater than `k`, shrink the window from the left until the window contains at most `k` zeros.
6. After adjusting the window, calculate the current window length and update the maximum length.
7. Return the maximum window size obtained.

This approach works because the window always represents the longest valid subarray where at most `k` zeros can be flipped to `1`.

## Algorithm
1. Initialize:
   - `left = 0`
   - `zeroCount = 0`
   - `maxLength = 0`
2. Traverse the array using `right` from `0` to `nums.length - 1`.
3. If `nums[right] == 0`, increment `zeroCount`.
4. While `zeroCount > k`:
   - If `nums[left] == 0`, decrement `zeroCount`.
   - Increment `left`.
5. Update:
   - `maxLength = Math.max(maxLength, right - left + 1)`
6. After the traversal, return `maxLength`.

## Time Complexity
- Each element is visited at most twice:
  - Once when the `right` pointer expands the window.
  - Once when the `left` pointer shrinks the window.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the input array.

## Space Complexity
- Only a few integer variables are used (`left`, `right`, `zeroCount`, and `maxLength`).

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Arrays
- Sliding Window
- Two Pointers
- Window Expansion and Shrinking
- Greedy
- Variable Size Sliding Window
