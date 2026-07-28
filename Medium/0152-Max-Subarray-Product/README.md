# 152. Maximum Product Subarray

## Approach
1. Initialize three variables:
   - `maxProduct` → Maximum product ending at the current index.
   - `minProduct` → Minimum product ending at the current index.
   - `answer` → Maximum product found so far.
2. Start traversing the array from index `1` since the first element is already used for initialization.
3. If the current element is negative, swap `maxProduct` and `minProduct` because multiplying by a negative number changes the maximum product into the minimum product and vice versa.
4. Update:
   - `maxProduct` as the maximum of the current element and the product of the current element with the previous `maxProduct`.
   - `minProduct` as the minimum of the current element and the product of the current element with the previous `minProduct`.
5. Update `answer` with the maximum value between the current `answer` and `maxProduct`.
6. After traversing the entire array, return `answer`.

This approach is a variation of Kadane's Algorithm, where both the maximum and minimum products are tracked because a negative number can turn a small (negative) product into the largest positive product.

## Algorithm
1. Initialize:
   - `maxProduct = nums[0]`
   - `minProduct = nums[0]`
   - `answer = nums[0]`
2. Traverse the array from index `1` to `n - 1`.
3. If `nums[i]` is negative:
   - Swap `maxProduct` and `minProduct`.
4. Update:
   - `maxProduct = max(nums[i], maxProduct * nums[i])`
   - `minProduct = min(nums[i], minProduct * nums[i])`
5. Update:
   - `answer = max(answer, maxProduct)`
6. Return `answer`.

## Time Complexity
- Single traversal of the array: **O(n)**

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the input array.

## Space Complexity
- Only a few variables (`maxProduct`, `minProduct`, `answer`, `temp`) are used.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Arrays
- Dynamic Programming
- Kadane's Algorithm (Variation)
- Maximum & Minimum Product Tracking
- Greedy
