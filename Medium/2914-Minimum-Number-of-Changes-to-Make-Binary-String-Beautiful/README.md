# 2914. Minimum Number of Changes to Make Binary String Beautiful

## Approach

The solution uses **Greedy Approach with Pairwise Checking**.

The binary string must be divided into groups of two characters, and each pair must contain identical characters (`00` or `11`).

Iterate through the string in steps of `2`, checking each pair:

- If both characters are equal, no changes are required.
- If the characters are different (`01` or `10`), one change is required to make them equal.

Since changing either character in a mismatched pair is sufficient, we increment `changes` by one.

## Algorithm

1. Initialize `changes = 0`.
2. Iterate through the string using `i += 2` to process consecutive pairs.
3. Compare `s.charAt(i)` with `s.charAt(i + 1)`.
4. If both characters are different, increment `changes`.
5. Return `changes`.

## Time Complexity

**O(n)**

We iterate through the string once, checking every pair of characters. Each comparison takes constant time.

Overall: **O(n)**.

## Space Complexity

**O(1)**

Only one integer variable `changes` is used. No additional data structures are created.

## Concepts

- Greedy Algorithm
- String Traversal
- Pairwise Comparison
- Character Access
- Incremental Counting
