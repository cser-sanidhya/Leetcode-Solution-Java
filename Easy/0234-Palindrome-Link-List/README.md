# 234. Palindrome Linked List

## Approach
1. Use the **Fast and Slow Pointer** technique to find the middle of the linked list.
2. `slow` moves one node at a time, while `fast` moves two nodes at a time.
3. When `fast` reaches the end, `slow` points to the beginning of the second half.
4. Reverse the second half of the linked list using three pointers:
   - `prev`
   - `current`
   - `next`
5. Compare the first half with the reversed second half.
6. If any pair of values is different, return `false`.
7. If all corresponding values match, return `true`.

This approach checks whether the linked list reads the same from both directions without using an extra array or stack.

## Algorithm
1. Initialize:
   - `slow = head`
   - `fast = head`
2. Find the middle:
   - Move `slow` one step.
   - Move `fast` two steps.
   - Continue while `fast != null && fast.next != null`.
3. Set:
   - `secondHalf = slow`
4. Reverse the second half:
   - Initialize `prev = null`
   - Set `current = secondHalf`
   - Save `current.next` in `next`.
   - Reverse the pointer using `current.next = prev`.
   - Move `prev` and `current` forward.
5. After reversal:
   - `prev` points to the head of the reversed second half.
6. Initialize:
   - `first = head`
   - `second = prev`
7. Compare both halves:
   - If `first.val != second.val`, return `false`.
   - Move both pointers forward.
8. If all values match, return `true`.

## Time Complexity
- Finding the middle: **O(n)**
- Reversing the second half: **O(n)**
- Comparing both halves: **O(n)**

These operations are performed sequentially.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = number of nodes in the linked list.

## Space Complexity
- Only a few pointers are used.
- No extra data structure is created.
- The second half is reversed **in-place**.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Linked List
- Fast and Slow Pointers
- Two Pointers
- Linked List Reversal
- In-place Manipulation
- Palindrome
- One-pass Traversal
