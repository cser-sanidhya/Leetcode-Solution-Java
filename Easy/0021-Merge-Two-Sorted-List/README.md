# 21. Merge Two Sorted Lists

## Approach
1. Use a **Dummy Node** to simplify the process of building the merged linked list.
2. Maintain a `current` pointer that points to the last node of the merged list.
3. Compare the values of the current nodes of `list1` and `list2`.
4. Attach the smaller node to `current.next`.
5. Move the pointer of the list from which the node was taken.
6. Move `current` to the newly added node.
7. Continue until one of the lists becomes `null`.
8. Attach the remaining part of the non-empty list directly to `current.next`.
9. Return `dummy.next`, because `dummy` itself is only a helper node.

This approach merges the two lists **in-place**, meaning we reuse the existing nodes instead of creating new nodes.

## Algorithm
1. Create a dummy node:
   - `ListNode dummy = new ListNode(0)`
2. Set:
   - `current = dummy`
3. While both lists are not empty:
   - Compare `list1.val` and `list2.val`.
   - If `list1.val <= list2.val`:
     - Attach `list1` to `current.next`.
     - Move `list1` forward.
   - Otherwise:
     - Attach `list2` to `current.next`.
     - Move `list2` forward.
   - Move `current` forward.
4. When one list becomes empty:
   - Attach the remaining list:
   - `current.next = (list1 != null) ? list1 : list2`
5. Return `dummy.next`.

## Time Complexity
- Each node from both linked lists is visited exactly once.

**Overall Time Complexity:**  
**O(n + m)**

where:
- `n` = number of nodes in `list1`
- `m` = number of nodes in `list2`

## Space Complexity
- Only `dummy` and `current` pointers are used.
- No additional data structure is created.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Linked List
- Two Pointers
- Dummy Node
- In-place Merging
- Sorted Lists
- Iterative Traversal
