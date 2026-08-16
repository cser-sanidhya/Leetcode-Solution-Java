# 143. Reorder List

## Approach
1. Use the **Fast and Slow Pointer** technique to find the middle of the linked list.
2. Split the list into two halves.
3. Reverse the second half of the linked list.
4. Merge the first half and the reversed second half alternately.
5. The list is reordered in the pattern:

`L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...`

For example:

`1 → 2 → 3 → 4 → 5`

becomes:

`1 → 5 → 2 → 4 → 3`

The algorithm modifies the linked list **in-place**, without creating another linked list.

## Algorithm
1. Handle edge cases:
   - If `head == null`
   - Or `head.next == null`
   - Return.
2. Find the middle of the list using `slow` and `fast`:
   - `slow` moves one step.
   - `fast` moves two steps.
3. Split the list:
   - `second = slow.next`
   - `slow.next = null`
4. Reverse the second half:
   - Initialize `prev = null`.
   - Use `current` to traverse the second half.
   - Reverse each pointer using:
     - `current.next = prev`
5. After reversal:
   - `prev` becomes the head of the reversed second half.
   - Set `second = prev`.
6. Merge the two halves alternately:
   - Save `first.next` in `firstNext`.
   - Save `second.next` in `secondNext`.
   - Connect:
     - `first.next = second`
     - `second.next = firstNext`
   - Move both pointers forward.
7. Continue until the second half is completely merged.

## Time Complexity
The algorithm performs three main operations:

- Find the middle: **O(n)**
- Reverse the second half: **O(n)**
- Merge the two halves: **O(n)**

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = number of nodes in the linked list.

## Space Complexity
- Only a few pointers are used.
- The list is reversed and merged **in-place**.
- No additional data structure is required.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Linked List
- Fast and Slow Pointers
- Two Pointers
- Linked List Reversal
- In-place Manipulation
- Splitting Linked List
- Merging Linked Lists
- Pointer Reconnection
