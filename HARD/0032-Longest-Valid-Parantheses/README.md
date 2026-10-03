# 32. Longest Valid Parentheses

## Approach

1. Use a **Stack** to store the indices of parentheses.
2. Push `-1` initially to act as a **base index** for calculating valid substring lengths.
3. Traverse the string character by character.
4. If the current character is `'('`:

   * Push its index onto the stack.
5. If the current character is `')'`:

   * Pop the top index because it represents the matching opening parenthesis.
6. After popping:

   * If the stack becomes empty, push the current index as the new base index.
   * Otherwise, calculate the length of the current valid substring using:

     ```java
     i - stack.peek()
     ```
7. Update `maxLength` with the maximum valid length found.
8. Return `maxLength` after processing the entire string.

## Algorithm

1. Create a stack of integers:

   ```java
   Stack<Integer> stack = new Stack<>();
   ```
2. Push `-1` as the initial base index:

   ```java
   stack.push(-1);
   ```
3. Initialize:

   ```java
   int maxLength = 0;
   ```
4. Traverse the string from left to right.
5. If:

   ```java
   s.charAt(i) == '('
   ```

   push the current index:

   ```java
   stack.push(i);
   ```
6. Otherwise, the character is `')'`:

   * Pop the top index:

     ```java
     stack.pop();
     ```
7. If the stack is empty:

   * Push the current index as the new base:

     ```java
     stack.push(i);
     ```
8. Otherwise, calculate the current valid parentheses length:

   ```java
   i - stack.peek()
   ```
9. Update:

   ```java
   maxLength = Math.max(maxLength, i - stack.peek());
   ```
10. Return `maxLength`.

## Time Complexity

Each character is pushed and popped from the stack at most once.

**Overall Time Complexity:**
**O(n)**

where:

* `n` = length of the string.

## Space Complexity

In the worst case, the stack can contain the indices of all opening parentheses.

**Overall Space Complexity:**
**O(n)**

where:

* `n` = length of the string.

## Concepts

* Stack
* Strings
* Parentheses
* Valid Parentheses
* Index Tracking
* LIFO (Last In, First Out)
* Substring Length
* Traversal
