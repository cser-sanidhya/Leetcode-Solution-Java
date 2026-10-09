# 1541. Minimum Insertions to Balance a Parentheses String

## Approach
1. Use a **Greedy Approach** to count the minimum insertions required to make the parentheses string valid.
2. Each opening parenthesis `'('` requires **two consecutive closing parentheses `'))'`** to form a valid pair.
3. Maintain two variables:
   - `ans`: Total number of insertions required.
   - `x`: Number of unmatched opening parentheses.
4. Traverse the string character by character.
5. If the current character is `'('`, increment `x` because it requires two closing parentheses.
6. If the current character is `')'`:
   - Check whether the next character is also `')'`.
   - If yes, treat both closing parentheses as a pair and skip the next character.
   - Otherwise, insert one `')'` to complete the required pair and increment `ans`.
7. If there is no unmatched opening parenthesis (`x == 0`), insert an opening parenthesis `'('` and increment `ans`.
8. Otherwise, match the closing pair with an existing opening parenthesis by decrementing `x`.
9. After traversing the string, each unmatched opening parenthesis requires two closing parentheses.
10. Add `2 * x` to `ans` and return the result.

## Algorithm
1. Initialize:
   ```java
   int ans = 0;
   int x = 0;
   int n = s.length();
   ```
2. Traverse the string using index `i`.
3. If `s.charAt(i) == '('`:
   ```java
   ++x;
   ```
4. Otherwise, check whether the next character is `')'`:
   - If yes, increment `i` to process both closing parentheses together.
   - If no, increment `ans` because one closing parenthesis is missing.
5. Check whether an unmatched opening parenthesis exists:
   - If `x == 0`, increment `ans` to insert a missing opening parenthesis.
   - Otherwise, decrement `x` to match the closing pair with an opening parenthesis.
6. After the loop, account for all unmatched opening parentheses:
   ```java
   ans += x << 1;
   ```
   The left shift by one is equivalent to multiplying `x` by `2`.
7. Return:
   ```java
   return ans;
   ```

## Time Complexity

The string is traversed once. Each character is processed at most once.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the string.

## Space Complexity

Only a few integer variables are used.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Strings
- Greedy
- Parentheses
- Balance Tracking
- Character Traversal
- Conditional Logic
- Bitwise Left Shift
- Constant Space Algorithm
