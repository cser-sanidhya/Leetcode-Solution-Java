# 3863. Minimum Operations to Sort a String

## Approach

The goal is to determine the minimum number of operations required to sort the string in non-decreasing order.

We use the minimum and maximum characters in the string, along with their positions, to determine the answer.

1. Traverse the string to find the minimum and maximum characters.
2. Check whether the string is already sorted. If it is, return `0`.
3. If the string has length `2` and is not sorted, return `-1`, because sorting cannot be achieved using the allowed operations.
4. If the first character is the minimum character or the last character is the maximum character, return `1`.
5. Otherwise, check the middle characters. If any middle character is the minimum or maximum character, return `2`.
6. If none of the above conditions apply, return `3`.

## Algorithm

1. Initialize `min = 'z'`, `max = 'a'`, and `sorted = true`.
2. Traverse the string:
   - Update the minimum and maximum characters.
   - If the current character is smaller than the previous character, set `sorted = false`.
3. If `sorted` is true, return `0`.
4. If `n == 2`, return `-1`.
5. If `s.charAt(0) == min` or `s.charAt(n - 1) == max`, return `1`.
6. Traverse the middle characters from index `1` to `n - 2`:
   - If a character equals `min` or `max`, return `2`.
7. If no earlier condition applies, return `3`.

## Time Complexity

- Traversing the string to find the minimum, maximum, and sorted status takes O(n).
- Checking the middle characters takes O(n) in the worst case.

Overall Time Complexity: **O(n)**

## Space Complexity

- Only a constant number of variables are used.

Overall Space Complexity: **O(1)**

## Concepts

- String Traversal
- Character Comparison
- Minimum and Maximum Tracking
- Greedy Approach
- Conditional Logic
