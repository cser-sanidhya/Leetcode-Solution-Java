# 20. Valid Parentheses

## Approach

1. Use a **Stack** to keep track of opening brackets.
2. Traverse the string character by character.
3. If the current character is an opening bracket:

   * `'('`
   * `'{'`
   * `'['`

   push it onto the stack.
4. If the current character is a closing bracket:

   * First check if the stack is empty. If it is empty, there is no matching opening bracket, so return `false`.
   * Pop the top opening bracket from the stack.
5. Check whether the popped bracket matches the current closing bracket.
6. If the brackets do not match, return `false`.
7. After processing the entire string, the stack must be empty for the parentheses to be valid.
8. Return `true` if the stack is empty.

## Algorithm

1. Create an empty stack:

   ```java
   Stack<Character> stack = new Stack<>();
   ```
2. Traverse every character `c` in the string.
3. If `c` is `'('`, `'{'`, or `'['`:

   ```java
   stack.push(c);
   ```
4. Otherwise, `c` is a closing bracket.
5. If the stack is empty:

   ```java
   return false;
   ```
6. Pop the top element:

   ```java
   char top = stack.pop();
   ```
7. Check whether the opening and closing brackets match:

   ```java
   if ((c == ')' && top != '(') ||
       (c == '}' && top != '{') ||
       (c == ']' && top != '[')) {
       return false;
   }
   ```
8. After processing all characters, check:

   ```java
   return stack.isEmpty();
   ```
9. If the stack is empty, every opening bracket has a corresponding closing bracket in the correct order.

## Time Complexity

Each character is processed exactly once.

**Overall Time Complexity:**
**O(n)**

where:

* `n` = length of the string.

## Space Complexity

In the worst case, all characters can be opening brackets and stored in the stack.

**Overall Space Complexity:**
**O(n)**

where:

* `n` = length of the string.

## Concepts

* Stack
* Strings
* Parentheses Matching
* Bracket Matching
* LIFO (Last In, First Out)
* Traversal
* Character Comparison
