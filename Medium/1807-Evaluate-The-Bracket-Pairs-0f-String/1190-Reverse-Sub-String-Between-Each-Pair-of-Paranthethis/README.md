# 1190. Reverse Substrings Between Each Pair of Parentheses

## Approach

1. Use a **Stack** to keep track of the string built before encountering an opening parenthesis.
2. Maintain a `StringBuilder` called `current` to store the characters of the current substring.
3. Traverse the string character by character.
4. When encountering `'('`:

   * Push the current string onto the stack.
   * Start a new empty `StringBuilder` for the substring inside the parentheses.
5. When encountering `')'`:

   * Reverse the current substring.
   * Pop the previously stored string from the stack.
   * Append the reversed substring to it.
   * Continue building from this combined string.
6. For normal characters:

   * Append them to `current`.
7. Nested parentheses are handled naturally because each new level stores its previous state on the stack.
8. After processing the entire string, return the final string stored in `current`.

## Algorithm

1. Create:

   ```java
   Stack<StringBuilder> stack = new Stack<>();
   ```
2. Initialize:

   ```java
   StringBuilder current = new StringBuilder();
   ```
3. Traverse every character in the string.
4. If the character is `'('`:

   * Push `current` onto the stack.
   * Create a new empty `StringBuilder`.
5. If the character is `')'`:

   * Reverse:

     ```java
     current.reverse();
     ```
   * Pop the previous string:

     ```java
     StringBuilder prev = stack.pop();
     ```
   * Append the reversed substring:

     ```java
     prev.append(current);
     ```
   * Set:

     ```java
     current = prev;
     ```
6. Otherwise:

   * Append the character to `current`.
7. After the traversal ends:

   ```java
   return current.toString();
   ```

## Time Complexity

Each character is processed once, and every character participates in at most one reversal operation.

**Overall Time Complexity:**
**O(n²)**

where:

* `n` = length of the string.

*(The `reverse()` operation may take linear time for nested parentheses.)*

## Space Complexity

* Stack stores intermediate strings.
* StringBuilders store characters from the input.

**Auxiliary Space Complexity:**
**O(n)**

**Overall Space Complexity:**
**O(n)**

## Concepts

* Strings
* Stack
* StringBuilder
* Simulation
* Parentheses Processing
* Nested Structures
* String Reversal
* Iterative Parsing
