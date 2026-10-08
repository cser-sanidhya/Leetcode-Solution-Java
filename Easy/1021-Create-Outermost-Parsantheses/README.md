# 1021. Remove Outermost Parentheses

## Approach
1. Use a **Balance Counter** to track the current nesting depth of parentheses.
2. A primitive valid parentheses string starts when `balance` is `0` and ends when `balance` returns to `0`.
3. For an opening parenthesis `'('`:
   - If `balance > 0`, it is not an outermost parenthesis, so add it to the result.
   - Then increase `balance`.
4. For a closing parenthesis `')'`:
   - First decrease `balance`.
   - If `balance > 0`, it is not an outermost parenthesis, so add it to the result.
5. The outermost `'('` is skipped because `balance == 0` before processing it.
6. The outermost `')'` is skipped because `balance == 0` after processing it.
7. Continue until the entire string is processed.
8. Return the resulting string.

## Algorithm
1. Create a `StringBuilder`:
   ```java
   StringBuilder result = new StringBuilder();
   ```
2. Initialize:
   ```java
   int balance = 0;
   ```
3. Traverse every character in the string.
4. If the character is `'('`:
   - If:
     ```java
     balance > 0
     ```
     append it to `result`.
   - Increase the balance:
     ```java
     balance++;
     ```
5. If the character is `')'`:
   - Decrease the balance:
     ```java
     balance--;
     ```
   - If:
     ```java
     balance > 0
     ```
     append it to `result`.
6. Continue until all characters are processed.
7. Return:
   ```java
   result.toString();
   ```

## Time Complexity

The string is traversed exactly once.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the string.

## Space Complexity

The `StringBuilder` stores the resulting string.

**Auxiliary Space Complexity:**  
**O(1)**

**Overall Space Complexity (including output):**  
**O(n)**

## Concepts
- Strings
- StringBuilder
- Parentheses
- Balance Counter
- Nesting Depth
- Primitive Parentheses
- Traversal
- Constant Space Technique
