# 61. Rotate List

## Approach
1. Find the length of the linked list and keep track of the last node (`tail`).
2. Use `k % n` to avoid performing unnecessary full rotations.
3. If `k == 0` after taking the modulo, return the original list.
4. Connect the tail to the head to temporarily make the linked list **circular**.
5. Find the new tail by moving `n - k - 1` steps from the original head.
6. The node after the new tail becomes the **new head**.
7. Break the circular connection by setting:
   - `newTail.next = null`
8. Return the new head.

For example:

`1 → 2 → 3 → 4 → 5`, `k = 2`

After rotation:

`4 → 5 → 1 → 2 → 3`

## Algorithm
1. Handle edge cases:
   - If `head == null`
   - If `head.next == null`
   - If `k == 0`
   - Return `head`.
2. Find the length:
   - Start `n = 1`.
   - Traverse until `tail.next == null`.
3. Reduce unnecessary rotations:
   - `k = k % n`
4. If `k == 0`, return `head`.
5. Make the list circular:
   - `tail.next = head`
6. Calculate:
   - `steps = n - k`
7. Find the new tail:
   - Start `newTail = head`.
   - Move it `steps - 1` times.
8. Set:
   - `newHead = newTail.next`
9. Break the circular list:
   - `newTail.next = null`
10. Return `newHead`.

## Time Complexity
- Finding the length and tail: **O(n)**
- Finding the new tail: **O(n)** in the worst case.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = number of nodes in the linked list.

## Space Complexity
- Only a few pointers and variables are used.
- No additional data structure is created.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Linked List
- Two Pointers
- Circular Linked List
- List Rotation
- Modulo Operation
- Pointer Manipulation
- In-place Manipulation
