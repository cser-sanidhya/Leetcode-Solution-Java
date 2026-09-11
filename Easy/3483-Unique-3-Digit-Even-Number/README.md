# 3483. Unique 3-Digit Even Numbers

## Approach
1. A valid number must satisfy:
   - It is a **3-digit number**.
   - The first digit cannot be `0`.
   - The last digit must be **even**.
   - Each digit can only be used as many times as it appears in the input array.
2. Store the frequency of each digit (0–9) using a count array.
3. Try every possible:
   - Hundreds digit (`i`)
   - Tens digit (`j`)
   - Units digit (`k`)
4. Before choosing a digit, verify that it is available in the frequency array.
5. Temporarily decrease the frequency when selecting a digit and restore it afterward (backtracking style).
6. For every valid combination:
   - Increment the answer count.
7. Return the total number of unique valid 3-digit even numbers.

The frequency array ensures that duplicate digits are handled correctly and that each digit is used only when available.

## Algorithm
1. Create:
   - `count[10]`
2. Store the frequency of each digit from `digits`.
3. Initialize:
   - `ans = 0`
4. Choose the hundreds digit:
   - Iterate `i` from `1` to `9`
   - Skip if `count[i] == 0`
5. Use digit `i`:
   - `count[i]--`
6. Choose the tens digit:
   - Iterate `j` from `0` to `9`
   - Skip if `count[j] == 0`
7. Use digit `j`:
   - `count[j]--`
8. Choose the units digit:
   - Iterate through even digits:
     - `0, 2, 4, 6, 8`
   - If `count[k] > 0`
     - Increment `ans`
9. Restore:
   - `count[j]++`
10. Restore:
    - `count[i]++`
11. Return:
    - `ans`

## Time Complexity
- Hundreds digit: 9 possibilities
- Tens digit: 10 possibilities
- Units digit: 5 even digits

Total operations:

**9 × 10 × 5 = 450**

**Overall Time Complexity:**  
**O(1)**

(Upper bound is constant because digit values are limited to 0–9.)

## Space Complexity
- Frequency array of size 10.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Arrays
- Frequency Counting
- Enumeration
- Backtracking Simulation
- Combinatorics
- Digit Manipulation
- Brute Force Optimization
