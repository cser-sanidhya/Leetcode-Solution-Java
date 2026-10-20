# 3886. Sortable Integers

## Approach

The goal is to find the sum of all valid divisors `k` of the array length `n` for which the array satisfies the required sorting condition when divided into blocks of size `k`.

We use prefix maximums, suffix minimums, and prefix counts of descending adjacent pairs to check each valid block size efficiently.

1. Build a prefix maximum array `prefMax`, where each position stores the maximum element before that index.
2. Build a suffix minimum array `suffMin`, where each position stores the minimum element from that index onward.
3. Build a prefix count array `prefDrop` to count adjacent descending pairs, where `nums[i - 1] > nums[i]`.
4. Iterate through the divisors of `n` using `k` and `n / k`, avoiding checking every possible block size.
5. For each divisor, call `check()` to verify whether every block satisfies the required conditions:
   - Each block contains at most one descending adjacent pair.
   - The maximum element in the preceding portion does not exceed the minimum element in the following portion.
6. If a block size is valid, add it to the answer.
7. Return the total sum of valid block sizes.

## Algorithm

1. Initialize `prefMax` with size `n + 1` and calculate prefix maximums.
2. Initialize `suffMin` with size `n + 1`, set `suffMin[n]` to `Integer.MAX_VALUE`, and calculate suffix minimums.
3. Create `prefDrop` to store cumulative counts of adjacent descending pairs.
4. Initialize `ans = 0`.
5. Iterate through possible divisors using `k` from `1` while `k <= n / k`:
   - If `n % k == 0`, check `k`.
   - Also check `n / k` if it differs from `k`.
6. In `check()`:
   - Iterate through blocks of size `k`.
   - Calculate the number of descending adjacent pairs within each block using `prefDrop`.
   - Reject the block size if a block contains more than one descending pair.
   - Reject it if `prefMax[start] > suffMin[start]`.
7. Add every valid block size to `ans` and return the result.

## Time Complexity

- Building the prefix maximum, suffix minimum, and prefix drop arrays takes O(n).
- Checking one block size takes O(n).
- There are O(√n) divisors to check.

Overall Time Complexity: **O(n√n)**

## Space Complexity

- The prefix maximum, suffix minimum, and prefix drop arrays each require O(n) space.

Overall Space Complexity: **O(n)**

## Concepts

- Prefix Maximum Array
- Suffix Minimum Array
- Prefix Sum / Prefix Count
- Divisor Enumeration
- Array Partitioning
- Boundary Condition Checking
