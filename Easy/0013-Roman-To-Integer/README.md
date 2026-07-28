# 13. Roman to Integer

## Approach
1. Create a `HashMap` to store the integer value of each Roman numeral.
2. Traverse the string from left to right.
3. For each Roman numeral:
   - Get its corresponding integer value from the map.
   - If the current numeral is smaller than the next numeral, subtract its value from the answer.
   - Otherwise, add its value to the answer.
4. Continue until the end of the string.
5. Return the final integer value.

This approach works because Roman numerals follow the subtraction rule. For example:
- `IV = 5 - 1 = 4`
- `IX = 10 - 1 = 9`
- `XL = 50 - 10 = 40`

Whenever a smaller numeral appears before a larger numeral, it should be subtracted instead of added.

## Algorithm
1. Create a `HashMap<Character, Integer>` containing the values of all Roman numerals:
   - `I → 1`
   - `V → 5`
   - `X → 10`
   - `L → 50`
   - `C → 100`
   - `D → 500`
   - `M → 1000`
2. Initialize:
   - `answer = 0`
   - `n = s.length()`
3. Traverse the string from index `0` to `n - 1`:
   - Get the value of the current Roman numeral.
   - If there is a next character and the current value is less than the next value:
     - Subtract the current value from `answer`.
   - Otherwise:
     - Add the current value to `answer`.
4. Return `answer`.

## Time Complexity
- Single traversal of the string: **O(n)**
- HashMap lookup: **O(1)** (average)

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the Roman numeral string.

## Space Complexity
- The `HashMap` stores the seven Roman numeral mappings.

**Overall Space Complexity:**  
**O(1)**

The map size is constant (only 7 entries), so the extra space does not grow with the input size.

## Concepts
- Strings
- HashMap
- Character Mapping
- Greedy
- Simulation
