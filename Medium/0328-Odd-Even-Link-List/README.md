# 328. Odd Even Linked List

## Approach
1. Use two pointers to separate the linked list into:
   - `odd` → nodes at odd positions.
   - `even` → nodes at even positions.
2. Store the beginning of the even list in `evenHead` so that we can connect it after the odd list later.
3. Rearrange the links while traversing the list:
   - Connect the current odd node to the next odd node.
   - Connect the current even node to the next even node.
4. Continue until there are no more pairs of nodes.
5. Connect the end of the odd list to `evenHead`.
6. Return `head`.

The important point is that **odd and even refer to positions**, not the values of the nodes.

For example:

`1 → 2 → 3 → 4 → 5`

becomes:

`1 → 3 → 5 → 2 → 4`

## Algorithm
1. Handle the edge cases:
   - If `head == null`
   - Or `head.next == null`
   - Return `head`.
2. Initialize:
   - `odd = head`
   - `even = head.next`
   - `evenHead = even`
3. While `even != null && even.next != null`:
   - Connect odd node to the next odd node:
     - `odd.next = even.next`
   - Move `odd` forward:
     - `odd = odd.next`
   - Connect even node to the next even node:
     - `even.next = odd.next`
   - Move `even` forward:
     - `even = even.next`
4. Connect the end of the odd list to the beginning of the even list:
   - `odd.next = evenHead`
5. Return `head`.

## Time Complexity
- Each node is visited at most once.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = number of nodes in the linked list.

## Space Complexity
- Only a few pointers are used.
- The linked list is rearranged **in-place**.
- No extra data structure is required.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Linked List
- Two Pointers
- In-place Manipulation
- Pointer Reconnection
- Linked List Traversal
- Odd/Even Positioning
