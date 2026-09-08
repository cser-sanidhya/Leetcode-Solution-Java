# 3870. Count Commas

## Approach
1. Numbers from **1 to 999** do not contain any comma when written in standard format.
2. Numbers starting from **1000** contain at least one comma.
3. Therefore:
   - If `n ≤ 999`, there are no numbers containing commas.
   - If `n > 999`, every number from `1000` to `n` contains a comma.
4. The count of such numbers is:

   `n - 999`

5. Use `Math.max(0, n - 999)` to handle cases where `n < 1000`.

## Algorithm
1. Receive the integer `n`.
2. Compute:
   - `n - 999`
3. If the result is negative:
   - Return `0`
4. Otherwise:
   - Return `n - 999`

Implemented as:

```java
return Math.max(0, n - 999);
```

## Time Complexity
- Only a single arithmetic operation is performed.

**Overall Time Complexity:**  
**O(1)**

## Space Complexity
- No extra data structures are used.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Mathematics
- Arithmetic
- Counting
- Constant Time Computation
- Simple Formula
