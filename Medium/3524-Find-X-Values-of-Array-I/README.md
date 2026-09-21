# 3524. Count Arrays by Product Modulo K

## Approach

1. Use **Dynamic Programming with Modulo States** to count subarrays based on the remainder of their product modulo `k`.
2. Maintain an array `prev` where:

   ```java
   prev[r]
   ```

   stores the number of subarrays ending at the previous index whose product modulo `k` equals `r`.
3. For every number in `nums`:

   * Create a new DP array `curr`.
4. Start a new subarray containing only the current number:

   ```java
   curr[num % k]++;
   ```
5. Extend all previously formed subarrays:

   * For every remainder `r` present in `prev`,
   * Multiply the current number's remainder with `r`.
   * Compute the new remainder:

     ```java
     (r * remainder) % k
     ```
   * Add the count to the corresponding state in `curr`.
6. Every value in `curr` represents subarrays ending at the current index.
7. Add these counts to the final answer array `ans`.
8. Update:

   ```java
   prev = curr;
   ```
9. After processing all elements, return `ans`.

## Algorithm

1. Create:

   ```java
   long[] ans = new long[k];
   ```
2. Create:

   ```java
   long[] prev = new long[k];
   ```
3. Traverse every number in `nums`.
4. Create:

   ```java
   long[] curr = new long[k];
   ```
5. Calculate:

   ```java
   int remainder = num % k;
   ```
6. Start a new subarray:

   ```java
   curr[remainder]++;
   ```
7. For every remainder `r` from `0` to `k - 1`:

   * If:

     ```java
     prev[r] != 0
     ```
   * Compute:

     ```java
     int newRemainder =
         (int)((long) r * remainder % k);
     ```
   * Update:

     ```java
     curr[newRemainder] += prev[r];
     ```
8. Add all counts from `curr` into `ans`.
9. Set:

   ```java
   prev = curr;
   ```
10. After all elements are processed:

    ```java
    return ans;
    ```

## Time Complexity

For each element, all `k` remainder states are processed.

**Overall Time Complexity:**
**O(n × k)**

where:

* `n` = length of the array.
* `k` = modulo value.

## Space Complexity

Three arrays of size `k` are maintained:

* `ans`
* `prev`
* `curr`

**Auxiliary Space Complexity:**
**O(k)**

**Overall Space Complexity:**
**O(k)**

## Concepts

* Dynamic Programming
* Arrays
* Modular Arithmetic
* State Compression
* Prefix Product States
* Counting Subarrays
* Mathematical Simulation
* Hashing by Remainder
