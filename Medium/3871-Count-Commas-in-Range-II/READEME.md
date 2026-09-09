# 3871. Count Commas

## Approach
1. A comma appears in a number when its decimal representation contains at least:
   - 4 digits → 1 comma
   - 7 digits → 2 commas
   - 10 digits → 3 commas
2. Instead of checking every number individually, count how many numbers contribute each comma position.
3. For a given number `n`:
   - Every number from `1000` to `n` contributes one comma.
   - Every number from `1,000,000` to `n` contributes an additional comma.
   - Every number from `1,000,000,000` to `n` contributes another comma.
4. Sum all these contributions to get the total number of commas from `1` to `n`.
5. To find the number of commas in a range `[left, right]`, use:

   `count(right) - count(left - 1)`

This avoids iterating through every number and computes the answer in constant time.

## Algorithm
### Function: `count(n)`
1. If:
   - `n < 1000`
   - Return `0`
2. Initialize:
   - `ans = 0`
3. Count numbers having at least one comma:
   - `ans += n - 999`
4. If:
   - `n >= 1,000,000`
   - Add:
     - `ans += n - 999,999`
5. If:
   - `n >= 1,000,000,000`
   - Add:
     - `ans += n - 999,999,999`
6. Return `ans`

### Function: `countCommasInRange(left, right)`
1. Compute:
   - `count(right)`
2. Compute:
   - `count(left - 1)`
3. Return:
   - `count(right) - count(left - 1)`

## Time Complexity
### count(n)
- Performs a constant number of operations.

**Time Complexity:**  
**O(1)**

### countCommasInRange(left, right)
- Calls `count()` twice.

**Overall Time Complexity:**  
**O(1)**

## Space Complexity
- Only a few variables are used.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Mathematics
- Counting
- Number System
- Range Queries
- Prefix Counting
- Constant-Time Computation
- Simulation Optimization
