# 2778. Sum of Squares of Special Elements

## Approach
1. Traverse the array and identify **Special Elements**.
2. An element at index `i` (0-based) is special if the length of the array `n` is divisible by its **1-based position** (`i + 1`).
3. Check the condition:
   ```java
   n % (i + 1) == 0
   ```
4. If the condition is satisfied, square the element and add it to `sum`.
5. Continue until all elements have been processed.
6. Return the final sum.

## Algorithm
1. Initialize:
   ```java
   int n = nums.length;
   int sum = 0;
   ```
2. Traverse the array using a loop from `i = 0` to `n - 1`.
3. Check whether the current position divides `n`:
   ```java
   if (n % (i + 1) == 0)
   ```
4. If the condition is true, add the square of the current element:
   ```java
   sum += nums[i] * nums[i];
   ```
5. Repeat for all elements.
6. Return:
   ```java
   return sum;
   ```

## Time Complexity

The algorithm traverses the array once.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the array.

## Space Complexity

Only a few integer variables are used.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Arrays
- Iteration
- Modulo Operator
- Indexing
- Conditional Statements
- Special Elements
- Mathematical Operations
