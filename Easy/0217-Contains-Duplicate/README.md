# 217. Contains Duplicate

## Approach
1. Create a `HashSet` to store the elements that have already been seen.
2. Traverse the array one element at a time.
3. For each element:
   - Check if it already exists in the `HashSet`.
   - If it does, return `true` because a duplicate has been found.
   - Otherwise, add the element to the `HashSet`.
4. If the entire array is traversed without finding any duplicate, return `false`.

This approach works because a `HashSet` stores only unique elements and provides efficient lookup operations.

## Algorithm
1. Create an empty `HashSet<Integer>`.
2. Traverse the array using a for-each loop.
3. For each element:
   - If `set.contains(num)` is `true`, return `true`.
   - Otherwise, insert the element into the set using `set.add(num)`.
4. After the loop completes, return `false`.

## Time Complexity
- Single traversal of the array: **O(n)**
- HashSet lookup and insertion: **O(1)** (average)

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the input array.

## Space Complexity
- The `HashSet` may store all unique elements in the worst case.

**Overall Space Complexity:**  
**O(n)**

## Concepts
- Arrays
- HashSet
- Duplicate Detection
- Hashing
- One-pass Traversal
