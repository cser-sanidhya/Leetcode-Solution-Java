# 141. Linked List Cycle

## Approach
1. Use the **Floyd's Cycle Detection Algorithm**, also known as the **Tortoise and Hare Algorithm**.
2. Maintain two pointers:
   - `slow` moves one node at a time.
   - `fast` moves two nodes at a time.
3. If there is no cycle, `fast` will eventually reach `null`.
4. If there is a cycle, the `fast` pointer will eventually catch up with the `slow` pointer.
5. When `slow == fast`, a cycle exists, so return `true`.
6. If the loop ends because `fast` reaches `null`, there is no cycle, so return `false`.

The key idea is that inside a cycle, the faster pointer will eventually meet the slower pointer.

## Algorithm
1. Initialize:
   - `slow = head`
   - `fast = head`
2. While:
   - `fast != null`
   - `fast.next != null`
3. Move the pointers:
   - `slow = slow.next`
   - `fast = fast.next.next`
4. Check if `slow == fast`:
   - If yes, return `true`.
5. If the loop finishes without the pointers meeting, return `false`.

## Time Complexity
- Each pointer traverses the linked list.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = number of nodes in the linked list.

## Space Complexity
- Only two pointers are used.
- No extra data structure is required.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Linked List
- Two Pointers
- Floyd's Cycle Detection
- Fast and Slow Pointers
- Cycle Detection
