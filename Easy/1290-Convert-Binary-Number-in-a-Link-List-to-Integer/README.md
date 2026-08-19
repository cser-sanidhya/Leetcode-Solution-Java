# 1290. Convert Binary Number in a Linked List to Integer

## Approach
1. Traverse the linked list from left to right.
2. Treat each node value as a binary digit (`0` or `1`).
3. Maintain a variable `result` to store the decimal value.
4. For every node:
   - Multiply the current `result` by `2`.
   - Add the current binary digit.
5. Continue until the end of the linked list.
6. Return `result`.

For example:

`1 → 0 → 1`

Calculation:

`result = 0`

`result = 0 × 2 + 1 = 1`

`result = 1 × 2 + 0 = 2`

`result = 2 × 2 + 1 = 5`

So the binary number `101` is **5** in decimal.

## Algorithm
1. Initialize:
   - `result = 0`
2. Traverse the linked list while `head != null`.
3. For each node:
   - `result = result * 2 + head.val`
4. Move to the next node:
   - `head = head.next`
5. When the traversal ends, return `result`.

## Time Complexity
- Each node is visited exactly once.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = number of nodes in the linked list.

## Space Complexity
- Only one variable `result` is used.
- No additional data structure is required.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Linked List
- Binary Numbers
- Decimal Conversion
- Traversal
- Mathematical Formula
- Iteration
