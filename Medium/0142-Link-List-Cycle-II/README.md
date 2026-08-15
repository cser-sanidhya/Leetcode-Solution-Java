# 142. Linked List Cycle II

## Approach
1. Use **Floyd's Cycle Detection Algorithm** with two pointers:
   - `slow` moves one node at a time.
   - `fast` moves two nodes at a time.
2. First, determine whether a cycle exists.
3. If `slow` and `fast` meet, a cycle exists.
4. Create another pointer `entry` starting from the `head`.
5. Move both `entry` and `slow` one node at a time.
6. The point where `entry` and `slow` meet is the **starting node of the cycle**.
7. Return that node.
8. If no cycle is detected, return `null`.

The important idea is that after `slow` and `fast` meet inside the cycle, moving one pointer from `head` and the other from the meeting point at the same speed will make them meet exactly at the cycle's entry point.

## Algorithm
1. Initialize:
   - `slow = head`
   - `fast = head`
2. Move the pointers while:
   - `fast != null`
   - `fast.next != null`
3. Move:
   - `slow = slow.next`
   - `fast = fast.next.next`
4. If `slow == fast`:
   - A cycle exists.
   - Create:
     - `entry = head`
5. Move both pointers one step at a time:
   - `entry = entry.next`
   - `slow = slow.next`
6. Continue until `entry == slow`.
7. Return `entry`.
8. If `fast` reaches `null`, return `null`.

## Time Complexity
- The cycle detection phase takes **O(n)**.
- Finding the cycle's entry point also takes **O(n)**.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = number of nodes in the linked list.

## Space Complexity
- Only three pointers (`slow`, `fast`, and `entry`) are used.
- No extra data structure is required.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Linked List
- Two Pointers
- Floyd's Cycle Detection
- Fast and Slow Pointers
- Cycle Entry Detection
- Mathematical Pointer Technique
