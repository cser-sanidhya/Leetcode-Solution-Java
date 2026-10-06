
# 921. Minimum Add to Make Parentheses Valid

## Approach
1. Use a **Counter** to keep track of unmatched opening parentheses.
2. Traverse the string character by character.
3. When an opening parenthesis `'('` is encountered:
   - Increase `open`.
4. When a closing parenthesis `')'` is encountered:
   - If there is an unmatched opening parenthesis (`open > 0`), match it by decreasing `open`.
   - Otherwise, this closing parenthesis has no matching opening parenthesis, so we need to add an opening parenthesis. Increase `additions`.
5. After traversing the entire string:
   - Any remaining unmatched opening parentheses stored in `open` need a closing parenthesis each.
6. Therefore, the total number of additions required is:
   ```java
   additions + open
   ```

## Algorithm
1. Initialize:
   ```java
   int open = 0;
   int additions = 0;
   ```
2. Traverse every character in the string.
3. If the character is `'('`:
   ```java
   open++;
   ```
4. Otherwise, the character is `')'`.
5. If there is an unmatched opening parenthesis:
   ```java
   if (open > 0) {
       open--;
   }
   ```
6. Otherwise, the closing parenthesis cannot be matched:
   ```java
   additions++;
   ```
7. After processing the entire string, add the remaining unmatched opening parentheses:
   ```java
   return additions + open;
   ```
8. Return the minimum number of parentheses that need to be added.

## Time Complexity

The string is traversed exactly once.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the string.

## Space Complexity

Only two integer variables are used.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Strings
- Parentheses
- Greedy
- Counter
- Matching Parentheses
- Traversal
- Constant Space
- Unmatched Parentheses
