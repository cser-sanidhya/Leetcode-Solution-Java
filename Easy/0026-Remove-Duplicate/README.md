# 26. Remove Duplicates from Sorted Array

## Approach
1. Use the **Two Pointer** technique to remove duplicates in-place.
2. Initialize two pointers:
   - `i` → Points to the last unique element.
   - `j` → Traverses the array to find new unique elements.
3. Start `j` from index `1` since the first element is always unique.
4. Compare `nums[i]` and `nums[j]`:
   - If they are different, a new unique element is found.
   - Increment `i` and copy `nums[j]` to `nums[i]`.
5. Continue until the entire array is traversed.
6. Return `i + 1`, which represents the total number of unique elements.

This approach modifies the original array in-place without using any extra space.

## Algorithm
1. Initialize:
   - `i = 0`
2. Traverse the array using `j` from `1` to `nums.length - 1`.
3. For each element:
   - If `nums[i] != nums[j]`:
     - Increment `i`.
     - Assign `nums[i] = nums[j]`.
4. After the loop, return `i + 1` as the number of unique elements.

## Time Complexity
- Single traversal of the array: **O(n)**

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the input array.

## Space Complexity
- No extra data structures are used.
- Only two pointers (`i`, `j`) are maintained.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Arrays
- Two Pointers
- In-place Modification
- Sorted Array
