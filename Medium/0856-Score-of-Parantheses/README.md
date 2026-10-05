# 856. Score of Parentheses

## Approach

1. Use a **Stack** to keep track of the score of each nested level of parentheses.
2. Push `0` initially to represent the score at the outermost level.
3. Traverse the string character by character.
4. When an opening parenthesis `'('` is encountered:

   * Push `0` onto the stack to start a new nested level.
5. When a closing parenthesis `')'` is encountered:

   * Pop the score of the current inner level.
6. Calculate the score of the current pair:

   * If the inner score is `0`, the pair is `()` and its score is `1`.
   * Otherwise, the score is doubled:

     ```java
     2 * inner
     ```
7. Add the calculated score to the previous level.
8. After processing the entire string, the remaining value in the stack is the total score.

## Algorithm

1. Create a stack:

   ```java
   Stack<Integer> stack = new Stack<>();
   ```
2. Push `0` as the initial score:

   ```java
   stack.push(0);
   ```
3. Traverse every character in the string.
4. If the character is `'('`:

   ```java
   stack.push(0);
   ```
5. Otherwise, the character is `')'`:

   * Pop the score of the current inner level:

     ```java
     int inner = stack.pop();
     ```
6. Calculate the score:

   ```java
   int score = (inner == 0) ? 1 : 2 * inner;
   ```
7. Pop the previous level's score and add the current score:

   ```java
   stack.push(stack.pop() + score);
   ```
8. After processing all characters, return:

   ```java
   stack.pop();
   ```

## Time Complexity

Each character is processed once, with constant-time stack operations.

**Overall Time Complexity:**
**O(n)**

where:

* `n` = length of the string.

## Space Complexity

In the worst case, the stack can contain one entry for each nested opening parenthesis.

**Overall Space Complexity:**
**O(n)**

where:

* `n` = length of the string.

## Concepts

* Stack
* Strings
* Parentheses
* Recursion Simulation
* Nested Structures
* LIFO (Last In, First Out)
* Expression Evaluation
* Stack-Based Parsing
