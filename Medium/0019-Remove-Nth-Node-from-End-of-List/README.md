# 19. Remove Nth Node From End of List

## Approach
1. Use the **Two Pointer** technique with `slow` and `fast`.
2. Create a `dummy` node before the head to handle cases where the first node itself needs to be removed.
3. Initially, both `slow` and `fast` point to the dummy node.
4. Move `fast` forward by `n + 1` positions.
   - This creates a gap of `n` nodes between `slow` and `fast`.
5. Move both pointers forward until `fast` reaches `null`.
6. At this point, `slow` will be positioned immediately before the node that needs to be removed.
7. Remove the node using:
   - `slow.next = slow.next.next`
8. Return `dummy.next` as the new head.

The dummy node makes the deletion easier, especially when the node to remove is the original head.

## Algorithm
1. Create a dummy node:
   - `dummy = new ListNode(0)`
2. Connect:
   - `dummy.next = head`
3. Initialize:
   - `slow = dummy`
   - `fast = dummy`
4. Move `fast` forward `n + 1` times.
5. Move both pointers while `fast != null`:
   - `slow = slow.next`
   - `fast = fast.next`
6. Once `fast` becomes `null`, `slow` is directly before the node to remove.
7. Remove the node:
   - `slow.next = slow.next.next`
8. Return:
   - `dummy.next`

## Time Complexity
- The linked list is traversed once.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = number of nodes in the linked list.

## Space Complexity
- Only `dummy`, `slow`, and `fast` pointers are used.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Linked List
- Two Pointers
- Fast and Slow Pointers
- Dummy Node
- Node Deletion
- One-pass Traversal
