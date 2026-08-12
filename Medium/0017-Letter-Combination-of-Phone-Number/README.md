# 17. Letter Combinations of a Phone Number

## Approach
1. Use **Backtracking** to generate all possible letter combinations represented by the given digits.
2. Create a mapping between digits `2–9` and their corresponding letters.
3. Maintain a `StringBuilder` called `current` to build the current combination.
4. At each position in `digits`:
   - Get the letters corresponding to the current digit.
   - Try each available letter one by one.
5. Add a letter to `current` and recursively process the next digit.
6. After returning from recursion, remove the last character using `deleteCharAt()` to **backtrack**.
7. When `index == digits.length()`, a complete combination has been created, so add it to `result`.

## Algorithm
1. Create an empty `result` list.
2. If `digits` is empty, return `result`.
3. Create the digit-to-letter mapping:
   - `2 → abc`
   - `3 → def`
   - `4 → ghi`
   - `5 → jkl`
   - `6 → mno`
   - `7 → pqrs`
   - `8 → tuv`
   - `9 → wxyz`
4. Create an empty `StringBuilder` called `current`.
5. Call:
   - `generate(digits, 0, current, result, map)`
6. In the recursive function:
   - If `index == digits.length()`:
     - Add `current.toString()` to `result`.
     - Return.
7. Get the letters for the current digit:
   - `String letters = map[digits.charAt(index) - '2'];`
8. Loop through each letter:
   - Add the letter to `current`.
   - Recursively process the next digit.
   - Remove the last character to backtrack.
9. Return `result`.

## Time Complexity
Each digit has up to **4 possible letters**.

For `n` digits, there can be up to **4ⁿ combinations**.

Each completed combination takes **O(n)** time to create/copy.

**Overall Time Complexity:**  
**O(n × 4ⁿ)**

where:
- `n` = number of digits.

## Space Complexity
- Recursion depth: **O(n)**
- `StringBuilder`: **O(n)**
- Result stores up to `4ⁿ` combinations, each of length `n`.

**Auxiliary Space Complexity:**  
**O(n)**

**Overall Space Complexity (including output):**  
**O(n × 4ⁿ)**

## Concepts
- Strings
- Backtracking
- Recursion
- StringBuilder
- Depth-First Search (DFS)
- Combinatorial Search
- Digit-to-Letter Mapping
