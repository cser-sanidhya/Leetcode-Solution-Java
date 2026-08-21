# 3116. Kth Smallest Amount With Single Denomination Combination

## Approach
1. We need to find the **kth smallest positive number** that is divisible by at least one coin denomination.
2. Instead of generating all numbers, use **Binary Search on the Answer**.
3. For a given number `x`, calculate how many valid numbers are less than or equal to `x`.
4. Use the **Inclusion-Exclusion Principle** to count numbers divisible by at least one coin:
   - Add counts of numbers divisible by individual coins.
   - Subtract counts divisible by pairs of coins.
   - Add counts divisible by triples of coins.
   - Continue alternating signs.
5. To find common multiples of coin subsets, compute their **LCM (Least Common Multiple)**.
6. If the count of valid numbers up to `mid` is at least `k`, then the answer lies on the left side.
7. Otherwise, search on the right side.
8. Continue binary search until `left == right`.

## Algorithm
1. Initialize:
   - `left = 1`
   - `right = min(coin × k)` among all coins.
2. Perform Binary Search:
   - While `left < right`:
     - Compute `mid`.
     - Calculate `count(mid, coins)`.
3. In `count(x, coins)`:
   - Iterate through all non-empty subsets using bitmasks.
   - For each subset:
     - Calculate its LCM.
     - Count numbers divisible by that LCM:
       - `x / lcm`
   - Apply Inclusion-Exclusion:
     - Odd-sized subsets → Add.
     - Even-sized subsets → Subtract.
4. If:
   - `count(mid) >= k`
     - Move left:
       - `right = mid`
   - Else:
       - `left = mid + 1`
5. Return `left`.

## Time Complexity
Let:
- `n` = number of coin denominations.
- `M` = answer range.

### Binary Search
- Takes **O(log M)** iterations.

### Counting Function
- Generates all non-empty subsets:
  - Total subsets = **2ⁿ - 1**
- For each subset, LCM calculation takes **O(n)** in the worst case.

Count Complexity:

**O(n × 2ⁿ)**

Total Complexity:

**O(log M × n × 2ⁿ)**

## Space Complexity
- Only a few variables are used.
- No extra recursive stack or large data structures.

**Overall Space Complexity:**  
**O(1)**

(Excluding the input array.)

## Concepts
- Binary Search on Answer
- Inclusion-Exclusion Principle
- Bitmasking
- Number Theory
- GCD (Greatest Common Divisor)
- LCM (Least Common Multiple)
- Counting Technique
- Mathematical Optimization
- Subset Enumeration
