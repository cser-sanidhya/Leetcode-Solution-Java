# 160. Intersection of Two Linked Lists

## Approach
1. Use the **Two Pointer** technique with two pointers:
   - `pointerA` starts at `headA`.
   - `pointerB` starts at `headB`.
2. Move both pointers one node at a time.
3. When `pointerA` reaches the end of List A, move it to `headB`.
4. When `pointerB` reaches the end of List B, move it to `headA`.
5. This makes both pointers travel the same total distance:
   - Length of List A + Length of List B.
6. If the two lists intersect, both pointers will eventually meet at the intersection node.
7. If the lists do not intersect, both pointers will eventually become `null` at the same time.
8. Return `pointerA`, which will either be the intersection node or `null`.

The key idea is that switching the heads removes the difference in lengths between the two linked lists.

## Algorithm
1. Initialize:
   - `pointerA = headA`
   - `pointerB = headB`
2. While `pointerA != pointerB`:
   - If `pointerA == null`, move it to `headB`.
   - Otherwise, move it to `pointerA.next`.
   - If `pointerB == null`, move it to `headA`.
   - Otherwise, move it to `pointerB.next`.
3. When `pointerA == pointerB`:
   - Return `pointerA`.
4. The returned value will be:
   - Intersection node, if an intersection exists.
   - `null`, if there is no intersection.

## Time Complexity
Each pointer traverses both linked lists at most once.

**Overall Time Complexity:**  
**O(n + m)**

where:
- `n` = number of nodes in List A
- `m` = number of nodes in List B

## Space Complexity
- Only two pointers are used.
- No additional data structure is required.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Linked List
- Two Pointers
- Intersection of Linked Lists
- Pointer Switching
- One-pass Traversal
- In-place Traversal


