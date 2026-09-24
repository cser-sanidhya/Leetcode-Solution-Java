# 237. Delete Node in a Linked List

## Approach

1. Unlike a normal linked list deletion, we are **not given the head** of the list.
2. Instead, we are directly given the node that needs to be deleted.
3. Since we cannot access the previous node, we cannot remove the current node in the usual way.
4. Copy the value of the next node into the current node.
5. Skip the next node by updating the current node's `next` pointer.
6. This effectively removes the next node while making the current node appear deleted.
7. The problem guarantees that the given node is **not the last node** in the linked list.

## Algorithm

1. Copy the value of the next node:

   ```java
   node.val = node.next.val;
   ```
2. Bypass the next node:

   ```java
   node.next = node.next.next;
   ```
3. The linked list now behaves as if the given node has been deleted.

## Time Complexity

Only constant-time operations are performed.

**Overall Time Complexity:**
**O(1)**

## Space Complexity

No extra data structures are used.

**Auxiliary Space Complexity:**
**O(1)**

**Overall Space Complexity:**
**O(1)**

## Concepts

* Linked List
* Singly Linked List
* In-Place Modification
* Pointer Manipulation
* Node Deletion
* Constant Space Algorithm
