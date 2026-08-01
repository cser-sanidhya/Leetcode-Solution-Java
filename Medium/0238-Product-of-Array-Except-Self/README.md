# 238. Product of Array Except Self

## Approach
1. Create a new array `result` to store the product of all elements except the current element.
2. Traverse the array using index `i`.
3. For every index `i`, initialize `product = 1`.
4. Traverse the array again using index `j`.
5. If `i != j`, multiply `product` by `nums[j]`.
6. After the inner loop, store the calculated product in `result[i]`.
7. Repeat the process for every element and return the `result` array.

This brute-force approach calculates the product for each index by multiplying every other element in the array.

## Algorithm
1. Create a `result` array of size `nums.length`.
2. Traverse the array using `i` from `0` to `nums.length - 1`.
3. Initialize:
   - `product = 1`
4. Traverse the array again using `j` from `0` to `nums.length - 1`.
5. If `i != j`:
   - Update:
     - `product *= nums[j]`
6. Store:
   - `result[i] = product`
7. After processing all indices, return the `result` array.

## Time Complexity
- Outer loop: **O(n)**
- Inner loop: **O(n)**

**Overall Time Complexity:**  
**O(n²)**

where:
- `n` = length of the input array.

## Space Complexity
- Result array: **O(n)**
- Auxiliary variables (`product`, `i`, `j`): **O(1)**

**Overall Space Complexity:**  
**O(n)**

## Concepts
- Arrays
- Brute Force
- Nested Loops
- Product Calculation
