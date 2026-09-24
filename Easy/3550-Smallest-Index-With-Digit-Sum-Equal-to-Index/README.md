# 3550. Smallest Index With Digit Sum Equal to Index

## Approach

1. Traverse the array from left to right.
2. For each index `i`, calculate the digit sum of `nums[i]`.
3. Compare the digit sum with the current index.
4. If:

   ```java
   digitSum(nums[i]) == i
   ```

   then `i` is a valid index.
5. Since we are traversing from the beginning, the first valid index encountered will automatically be the smallest.
6. Return that index immediately.
7. If no such index exists after checking all elements, return `-1`.

## Algorithm

1. Iterate through the array:

   ```java
   for (int i = 0; i < nums.length; i++)
   ```
2. For each element, compute its digit sum.
3. Initialize:

   ```java
   sum = 0
   ```
4. Repeatedly extract digits:

   ```java
   sum += num % 10;
   num /= 10;
   ```
5. After computing the digit sum:

   * Compare it with the current index.
6. If:

   ```java
   digitSum(nums[i]) == i
   ```

   return `i`.
7. If the loop finishes without finding a valid index:

   ```java
   return -1;
   ```

## Time Complexity

Let:

* `n` = length of the array.
* `d` = maximum number of digits in an element.

For each element, we compute its digit sum.

**Overall Time Complexity:**
**O(n × d)**

Since `d` is very small (at most 10 for integer values), this is effectively:

**O(n)**

## Space Complexity

Only a few variables are used.

**Auxiliary Space Complexity:**
**O(1)**

**Overall Space Complexity:**
**O(1)**

## Concepts

* Arrays
* Simulation
* Digit Manipulation
* Math
* Linear Scan
* Number Processing
