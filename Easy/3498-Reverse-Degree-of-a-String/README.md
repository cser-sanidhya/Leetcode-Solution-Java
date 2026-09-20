#  3498-Reverse Degree of a String

## Approach

1. Traverse each character of the string from left to right.
2. Compute the **reverse alphabetical position** of the current character:

   * `'z' → 1`
   * `'y' → 2`
   * ...
   * `'a' → 26`
3. The reverse degree of a character can be calculated as:

   ```java
   26 - (ch - 'a')
   ```
4. Multiply the reverse degree by the character's **1-based index** in the string.
5. Add this contribution to the running sum.
6. After processing all characters, return the final sum.

## Algorithm

1. Initialize:

   ```java
   int sum = 0;
   ```
2. Traverse the string:

   ```java
   for (int i = 0; i < s.length(); i++)
   ```
3. Calculate the reverse degree:

   ```java
   int reverseDegree = 26 - (s.charAt(i) - 'a');
   ```
4. Multiply it by its position:

   ```java
   reverseDegree * (i + 1)
   ```
5. Add the value to `sum`.
6. Continue until all characters are processed.
7. Return:

   ```java
   sum;
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

* Strings
* Character Arithmetic
* ASCII Manipulation
* Simulation
* Traversal
* Mathematical Computation
* Index-Based Weighting
