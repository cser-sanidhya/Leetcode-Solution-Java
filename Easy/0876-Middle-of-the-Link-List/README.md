# 876. Middle of the Linked List

## Approach
1. Use the **Fast and Slow Pointer** technique.
2. Initialize two pointers:
   - `slow` starts at `head`.
   - `fast` starts at `head`.
3. Move:
   - `slow` one node at a time.
   - `fast` two nodes at a time.
4. When `fast` reaches the end of the linked list, `slow` will be at the middle.
5. Return `slow`.

For an even-length linked list, this approach returns the **second middle node**, which matches the problem requirement.

## Algorithm
1. Initialize:
   - `slow = head`
   - `fast = head`
2. While `fast != null` and `fast.next != null`:
   - Move `slow` one step:
     - `slow = slow.next`
   - Move `fast` two steps:
     - `fast = fast.next.next`
3. When the loop ends, `slow` points to the middle node.
4. Return `slow`.

## Time Complexity
- The `fast` pointer moves through the linked list in pairs.
- Every node is visited at most once by the pointers.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = number of nodes in the linked list.

## Space Complexity
- Only two pointers (`slow` and `fast`) are used.
- No additional data structures are created.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Linked List
- Two Pointers
- Fast and Slow Pointer
- Floyd's Technique
- One-pass Traversal
