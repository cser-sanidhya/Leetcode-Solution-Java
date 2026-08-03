# 88. Merge Sorted Array

## Approach
1. Create a new array `merged` of size `m + n` to store the merged elements.
2. Initialize three pointers:
   - `i` → Points to the current element in `nums1`.
   - `j` → Points to the current element in `nums2`.
   - `k` → Points to the current position in the `merged` array.
3. Compare the current elements of both arrays:
   - If `nums1[i] <= nums2[j]`, place `nums1[i]` into `merged` and increment `i`.
   - Otherwise, place `nums2[j]` into `merged` and increment `j`.
   - Increment `k` after every insertion.
4. If one array is completely traversed, copy the remaining elements of the other array into `merged`.
5. Copy all elements from `merged` back into `nums1`.
6. The final sorted array is stored in `nums1`.

This approach merges two sorted arrays in ascending order using an additional temporary array.

## Algorithm
1. Create a temporary array `merged` of size `m + n`.
2. Initialize:
   - `i = 0`
   - `j = 0`
   - `k = 0`
3. While both arrays have remaining elements:
   - Compare `nums1[i]` and `nums2[j]`.
   - Store the smaller element in `merged[k]`.
   - Increment the corresponding pointer and `k`.
4. Copy any remaining elements from `nums1` into `merged`.
5. Copy any remaining elements from `nums2` into `merged`.
6. Copy every element from `merged` back to `nums1`.
7. Return (the method modifies `nums1` in-place).

## Time Complexity
- Merging both arrays: **O(m + n)**
- Copying the merged array back into `nums1`: **O(m + n)**

**Overall Time Complexity:**  
**O(m + n)**

where:
- `m` = number of valid elements in `nums1`
- `n` = number of elements in `nums2`

## Space Complexity
- Temporary array `merged` of size `m + n`.

**Overall Space Complexity:**  
**O(m + n)**

## Concepts
- Arrays
- Two Pointers
- Merge Technique
- Sorted Arrays
- In-place Update (Final Copy)
