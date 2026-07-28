# 75. Sort Colors

## Approach
1. Use the **Dutch National Flag Algorithm** with three pointers:
   - `low` → Position where the next `0` should be placed.
   - `mid` → Current element being processed.
   - `high` → Position where the next `2` should be placed.
2. Traverse the array while `mid <= high`.
3. If `nums[mid] == 0`:
   - Swap `nums[low]` and `nums[mid]`.
   - Increment both `low` and `mid`.
4. If `nums[mid] == 1`:
   - It is already in the correct position.
   - Increment `mid`.
5. If `nums[mid] == 2`:
   - Swap `nums[mid]` and `nums[high]`.
   - Decrement `high`.
   - Do **not** increment `mid` because the swapped element from the end has not been processed yet.
6. Continue until `mid` crosses `high`.

This algorithm sorts the array in a **single traversal** without using any extra space.

## Algorithm
1. Initialize:
   - `low = 0`
   - `mid = 0`
   - `high = nums.length - 1`
2. While `mid <= high`:
   - If `nums[mid] == 0`:
     - Swap `nums[low]` and `nums[mid]`.
     - Increment `low` and `mid`.
   - Else if `nums[mid] == 1`:
     - Increment `mid`.
   - Else (`nums[mid] == 2`):
     - Swap `nums[mid]` and `nums[high]`.
     - Decrement `high`.
3. The array is now sorted in the order `0`, `1`, `2`.

## Time Complexity
- Single traversal of the array: **O(n)**

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the input array.

## Space Complexity
- Only three pointers (`low`, `mid`, `high`) and one temporary variable are used for swapping.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Arrays
- Dutch National Flag Algorithm
- Three Pointers
- In-place Swapping
- One-pass Traversal
