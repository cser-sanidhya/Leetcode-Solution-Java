# 643. Maximum Average Subarray I

## Approach
1. Use the **Sliding Window** technique to find the maximum sum of any subarray of size `k`.
2. Calculate the sum of the first `k` elements to form the initial window.
3. Store this sum as `maxSum`.
4. Slide the window one element at a time:
   - Remove the leftmost element from the current window.
   - Add the new rightmost element.
   - Update `maxSum` if the current window sum is greater.
5. After traversing the array, divide `maxSum` by `k` to obtain the maximum average.
6. Return the result as a `double`.

This approach avoids recalculating the sum of every subarray from scratch, making it much more efficient.

## Algorithm
1. Initialize:
   - `sum = 0`
2. Calculate the sum of the first `k` elements.
3. Set:
   - `maxSum = sum`
   - `left = 0`
4. Traverse the remaining elements using `right` from `k` to `nums.length - 1`:
   - Update the window sum:
     - `sum = sum - nums[left] + nums[right]`
   - Increment `left`.
   - Update:
     - `maxSum = Math.max(maxSum, sum)`
5. Return:
   - `(double) maxSum / k`

## Time Complexity
- Calculating the first window sum: **O(k)**
- Sliding the window through the remaining elements: **O(n - k)**

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the input array.

## Space Complexity
- Only a few variables (`sum`, `maxSum`, `left`, and `right`) are used.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Arrays
- Sliding Window
- Fixed Size Window
- Running Sum
- Maximum Average
- One-pass Traversal
