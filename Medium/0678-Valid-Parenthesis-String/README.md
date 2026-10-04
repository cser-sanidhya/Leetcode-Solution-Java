# 678. Valid Parenthesis String

## Approach

1. Use a **Greedy Range** approach to track the possible number of open parentheses at every position.
2. Maintain two variables:

   * `minOpen` → minimum possible number of unmatched `'('`.
   * `maxOpen` → maximum possible number of unmatched `'('`.
3. Traverse the string character by character.
4. For an opening parenthesis `'('`:

   * Both minimum and maximum possible open counts increase.
5. For a closing parenthesis `')'`:

   * Both counts decrease because one opening parenthesis is matched.
6. For a wildcard `'*'`:

   * It can act as `'('`, `')'`, or an empty character.
   * Therefore:

     * `minOpen--` assumes `'*'` acts as `')'`.
     * `maxOpen++` assumes `'*'` acts as `'('`.
7. If `maxOpen < 0`, there are more closing parentheses than can possibly be matched, so return `false`.
8. `minOpen` cannot be negative because we can choose previous `'*'` characters to act as empty characters or opening parentheses.
9. After processing the entire string, `minOpen == 0` means it is possible to balance all parentheses.
10. Return the result.

## Algorithm

1. Initialize:

   ```java
   int minOpen = 0;
   int maxOpen = 0;
   ```
2. Traverse every character `ch` in the string.
3. If `ch == '('`:

   ```java
   minOpen++;
   maxOpen++;
   ```
4. If `ch == ')'`:

   ```java
   minOpen--;
   maxOpen--;
   ```
5. If `ch == '*'`:

   ```java
   minOpen--;
   maxOpen++;
   ```
6. If:

   ```java
   maxOpen < 0
   ```

   return `false`.
7. Keep `minOpen` non-negative:

   ```java
   minOpen = Math.max(minOpen, 0);
   ```
8. After processing the complete string:

   ```java
   return minOpen == 0;
   ```
9. If the minimum possible number of unmatched opening parentheses is `0`, a valid interpretation of the string exists.

## Time Complexity

The string is traversed exactly once.

**Overall Time Complexity:**
**O(n)**

where:

* `n` = length of the string.

## Space Complexity

Only two integer variables are used.

**Overall Space Complexity:**
**O(1)**

## Concepts

* Strings
* Greedy
* Parentheses
* Stack Alternative
* Range Tracking
* Wildcard Handling
* Open Parentheses Count
* Constant Space Algorithm
