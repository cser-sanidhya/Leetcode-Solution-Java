# 1614. Maximum Nesting Depth of the Parentheses

## Approach

1. Use a variable `depth` to track the current nesting level of parentheses.
2. Traverse the string character by character.
3. Whenever an opening parenthesis `'('` is encountered:

   * Increase the current depth by `1`.
   * Update the maximum depth reached so far.
4. Whenever a closing parenthesis `')'` is encountered:

   * Decrease the current depth by `1`.
5. Ignore all other characters since they do not affect the nesting depth.
6. After processing the entire string, return the maximum depth encountered.

## Algorithm

1. Initialize:

   ```java
   depth = 0
   maxDepth = 0
   ```
2. Traverse each character in the string.
3. If the character is `'('`:

   ```java
   depth++;
   maxDepth = Math.max(maxDepth, depth);
   ```
4. Else if the character is `')'`:

   ```java
   depth--;
   ```
5. Continue until all characters have been processed.
6. Return:

   ```java
   maxDepth
   ```

## Time Complexity

The string is traversed exactly once.

**Overall Time Complexity:**
**O(n)**

where:

* `n` = length of the string.

## Space Complexity

Only a few integer variables are used.

**Auxiliary Space Complexity:**
**O(1)**

**Overall Space Complexity:**
**O(1)**

## Concepts

* String
* Parentheses
* Stack Simulation
* Counter Technique
* Traversal
* Greedy Tracking
* Nested Structures
