# 301. Remove Invalid Parentheses

## Approach
1. Use **Breadth-First Search (BFS)** to find all valid strings with the minimum number of removals.
2. Start with the original string and place it into a queue.
3. Use a `HashSet` called `visited` to avoid processing the same string multiple times.
4. For each string removed from the queue:
   - Check whether it is valid using the `isValid()` function.
5. If the string is valid:
   - Add it to the result.
   - Set `found = true`.
6. Once a valid string is found at a particular BFS level, do not generate any further strings from it.
   - This guarantees that all returned strings require the **minimum number of removals**.
7. If no valid string has been found yet:
   - Generate new strings by removing one parenthesis at every possible position.
   - Add unvisited strings to the queue.
8. Continue until the queue is empty.
9. Return all valid strings found at the minimum-removal level.

## Algorithm
1. Create:
   ```java
   List<String> result = new ArrayList<>();
   Set<String> visited = new HashSet<>();
   Queue<String> queue = new LinkedList<>();
   ```
2. Add the original string to the queue:
   ```java
   queue.offer(s);
   ```
3. Mark it as visited:
   ```java
   visited.add(s);
   ```
4. Initialize:
   ```java
   boolean found = false;
   ```
5. While the queue is not empty:
   - Remove the next string:
     ```java
     String current = queue.poll();
     ```
6. Check whether `current` is valid:
   ```java
   if (isValid(current))
   ```
7. If valid:
   - Add it to `result`.
   - Set:
     ```java
     found = true;
     ```
8. If `found` is already `true`:
   ```java
   continue;
   ```
   This prevents generating strings requiring additional removals.
9. Otherwise, try removing every parenthesis:
   - Traverse every index `i`.
   - Skip non-parenthesis characters.
10. Create the next string by removing the character at index `i`:
    ```java
    String next = current.substring(0, i)
               + current.substring(i + 1);
    ```
11. If the string has not been visited:
    ```java
    if (visited.add(next)) {
        queue.offer(next);
    }
    ```
12. In `isValid()`:
    - Increase `balance` for `'('`.
    - Decrease `balance` for `')'`.
    - If `balance < 0`, return `false`.
13. After traversing the string:
    - Return `true` only when:
      ```java
      balance == 0
      ```
14. Return `result`.

## Time Complexity

There can be up to **O(2ⁿ)** possible subsequences because each parenthesis can potentially be removed or kept.

For each generated string, the validity check takes **O(n)** time, and creating strings can also take **O(n)** time.

**Overall Time Complexity:**  
**O(n × 2ⁿ)**

where:
- `n` = length of the string.

## Space Complexity

The BFS queue and `visited` set can contain up to **O(2ⁿ)** different strings, each requiring up to **O(n)** space.

**Overall Space Complexity:**  
**O(n × 2ⁿ)**

## Concepts
- Strings
- Breadth-First Search (BFS)
- Queue
- HashSet
- Backtracking / State-Space Search
- Parentheses Validation
- Minimum Removals
- Duplicate State Prevention
- Level-Order Search
- String Manipulation
