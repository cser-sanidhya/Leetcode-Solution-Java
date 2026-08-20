# 203. Remove Linked List Elements

## Approach
1. Use a **Dummy Node** before the head of the linked list.
2. The dummy node helps handle cases where the head node itself needs to be removed.
3. Maintain a pointer `curr` starting from the dummy node.
4. Traverse the linked list while `curr.next` is not `null`.
5. If the value of `curr.next` equals the target value:
   - Skip that node by changing the link:
     - `curr.next = curr.next.next`
6. Otherwise:
   - Move `curr` to the next node.
7. Continue until the end of the list.
8. Return `dummy.next` as the new head.

This approach removes all nodes with the given value without creating a new linked list.

## Algorithm
1. Create a dummy node:
   - `dummy = new ListNode(0)`
2. Connect:
   - `dummy.next = head`
3. Initialize:
   - `curr = dummy`
4. Traverse the list:
   - While `curr.next != null`
5. For each node:
   - If `curr.next.val == val`
     - Remove the node:
       - `curr.next = curr.next.next`
   - Else:
     - Move:
       - `curr = curr.next`
6. After traversal, return:
   - `dummy.next`

## Time Complexity
- Each node is visited at most once.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = number of nodes in the linked list.

## Space Complexity
- Only a dummy node and one pointer are used.
- No extra data structure is required.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Linked List
- Dummy Node
- Node Deletion
- Pointer Manipulation
- In-place Modification
- Linked List Traversal
