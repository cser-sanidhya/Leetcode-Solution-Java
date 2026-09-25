# 1096. Brace Expansion II

## Approach

1. Treat the expression as a combination of two operations:

   * **Union ( , )** → combines strings from both sets.
   * **Concatenation** → joins every string from one set with every string from another set.
2. Use two stacks:

   * `stack` to store sets of strings.
   * `ops` to store operators (`{`, `,`, `*`).
3. Use `*` as an implicit concatenation operator.
4. While traversing the expression:

   * Letters are converted into singleton sets and pushed onto the stack.
   * `{` marks the beginning of a grouped expression.
   * `}` triggers evaluation until the matching `{` is reached.
   * `,` represents the union operation.
5. Whenever two expressions appear adjacent to each other:

   * Insert a concatenation operator `*`.
6. Evaluate operations according to precedence:

   * Concatenation (`*`) before Union (`,`).
7. For concatenation:

   * Generate all combinations by joining strings from the left set with strings from the right set.
8. For union:

   * Merge both sets into one set.
9. After processing the entire expression:

   * Evaluate all remaining operators.
10. Convert the final set into a sorted list and return it.

## Algorithm

1. Create:

   ```java
   Stack<Set<String>> stack
   Stack<Character> ops
   ```
2. Traverse each character of the expression.
3. If the character is a letter:

   * Create a set containing that single letter.
   * Push it onto `stack`.
4. If concatenation is implied:

   * Push `'*'` into `ops`.
5. If the character is `{`:

   * Push it into `ops`.
6. If the character is `,`:

   * Evaluate all pending concatenations.
   * Push `','` into `ops`.
7. If the character is `}`:

   * Evaluate operators until `{` is found.
   * Remove `{`.
   * Evaluate pending concatenations if necessary.
8. After traversing the expression:

   * Evaluate all remaining operators.
9. Pop the final set from the stack.
10. Convert it into a list and sort it.
11. Return the sorted list.

## Time Complexity

Let:

* `n` = length of the expression.
* `k` = number of generated strings.

Concatenation may generate many combinations, requiring pairwise merging of sets.

**Overall Time Complexity:**
**O(k² + n)**

The exact complexity depends on the number of generated strings produced during expansion.

## Space Complexity

* Stacks store operators and intermediate sets.
* Generated strings are stored in sets.

**Auxiliary Space Complexity:**
**O(k)**

**Overall Space Complexity:**
**O(k)**

where:

* `k` = total number of unique expanded strings.

## Concepts

* Strings
* Stack
* Parsing
* Expression Evaluation
* Recursion Simulation
* Set Operations
* Union
* Cartesian Product
* Backtracking Style Expansion
* Sorting
