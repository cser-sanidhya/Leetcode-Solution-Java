# 3876-Construct-Unifrom-Parity-Array-II

## Approach
1. Find:
   - The smallest odd number in the array (`minOdd`).
   - The smallest even number in the array (`minEven`).
2. Traverse the array once:
   - If a number is even, update `minEven`.
   - If a number is odd, update `minOdd`.
3. After traversal:
   - If there are no odd numbers, return `true`.
   - If there are no even numbers, return `true`.
4. If both odd and even numbers exist:
   - Compare their minimum values.
   - Return `true` if the smallest odd number is less than the smallest even number.
   - Otherwise return `false`.

The idea is that the array is considered uniform when either:
- All numbers have the same parity (all odd or all even), or
- The smallest odd number is smaller than the smallest even number.

## Algorithm
1. Initialize:
   - `minOdd = Integer.MAX_VALUE`
   - `minEven = Integer.MAX_VALUE`
2. Traverse each element `x` in `nums1`:
   - If `x` is even:
     - `minEven = min(minEven, x)`
   - Else:
     - `minOdd = min(minOdd, x)`
3. If no odd number exists:
   - Return `true`
4. If no even number exists:
   - Return `true`
5. Return:
   - `minOdd < minEven`

## Time Complexity
- The array is traversed exactly once.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the array.

## Space Complexity
- Only two variables are used to store minimum values.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Arrays
- Parity Check
- Bit Manipulation (`& 1`)
- Minimum Element Tracking
- Single Pass Traversal
- Greedy Observation
