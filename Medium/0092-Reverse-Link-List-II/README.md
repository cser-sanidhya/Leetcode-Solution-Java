# 92. Reverse Linked List II

## Approach
1. Use a `dummy` node before the head to make handling the beginning of the list easier.
2. Move `prev` until it reaches the node just before position `left`.
3. Set `curr = prev.next`, which is the first node of the section that needs to be reversed.
4. Reverse the section from `left` to `right` using **head insertion**:
   - Take the node after `curr`.
   - Remove it from its current position.
   - Insert it immediately after `prev`.
5. Repeat this process `right - left` times.
6. Return `dummy.next`.

For example:

`1 → 2 → 3 → 4 → 5`

For `left = 2`, `right = 4`:

`1 → 2 → 3 → 4 → 5`

becomes:

`1 → 4 → 3 → 2 → 5`

## Algorithm
1. Handle edge cases:
   - If `head == null`
   - Or `left == right`
   - Return `head`.
2. Create a dummy node:
   - `dummy.next = head`
3. Initialize:
   - `prev = dummy`
4. Move `prev` to the node before position `left`.
5. Set:
   - `curr = prev.next`
6. Repeat `right - left` times:
   - Store the node after `curr`:
     - `next = curr.next`
   - Remove `next` from its current position:
     - `curr.next = next.next`
   - Insert `next` after `prev`:
     - `next.next = prev.next`
     - `prev.next = next`
7. Return `dummy.next`.

## Time Complexity
- Finding the starting position takes **O(n)** in the worst case.
- Reversing the selected portion takes **O(right - left)**.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = number of nodes in the linked list.

## Space Complexity
- Only a few pointers are used.
- The reversal is performed **in-place**.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Linked List
- Two Pointers
- In-place Reversal
- Dummy Node
- Pointer Manipulation
- Sublist Reversal
- Head Insertion Technique
