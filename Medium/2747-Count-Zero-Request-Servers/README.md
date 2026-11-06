# 2747. Count Zero Request Servers

## Approach

Use **Sorting + Sliding Window + HashMap** to efficiently count the number of servers that did not receive any requests during each query's time interval.

For a query time `time`, we need to consider logs within the inclusive interval:

A server is considered inactive if it has no request inside this interval.

### 1. Sort the Logs

Sort `logs` based on their timestamps (`logs[i][1]`) in ascending order.

This allows us to process requests chronologically using two pointers.

```java
Arrays.sort(logs, (a, b) -> a[1] - b[1]);
```

### 2. Sort the Queries

Create a two-dimensional array `q` containing:

- `q[i][0]`: Query timestamp.
- `q[i][1]`: Original index of the query.

Sort this array by query timestamp.

Storing the original index allows us to restore the answers to their original order.

### 3. Sliding Window with HashMap

Maintain:

- `left`: Left boundary of the active log window.
- `right`: Right boundary of the active log window.
- `map`: Stores each server ID and its number of requests within the current time interval.

For every sorted query:

**Expand the window:**

Add all logs whose timestamps are less than or equal to the query time.

```java
while (right < logs.length && logs[right][1] <= time) {
    map.put(logs[right][0],
        map.getOrDefault(logs[right][0], 0) + 1);
    right++;
}
```

**Shrink the window:**

Remove logs whose timestamps are strictly less than `time - x`.

```java
while (left < right && logs[left][1] < time - x) {
    int server = logs[left][0];
    map.put(server, map.get(server) - 1);

    if (map.get(server) == 0) {
        map.remove(server);
    }
    left++;
}
```

The HashMap maintains the frequency of requests for each server. When a server's frequency becomes zero, it is removed from the map.

### 4. Calculate the Answer

`map.size()` represents the number of servers that received at least one request during the query interval.

Therefore:

```java
ans[index] = n - map.size();
```

This gives the number of servers that did not receive any requests during that interval.

The original query index is used to store the answer in the correct position.

## Algorithm

1. Initialize the answer array with the same length as `queries`.
2. Sort `logs` by timestamp in ascending order.
3. Create a query array containing each query time and its original index.
4. Sort the queries by timestamp.
5. Initialize a HashMap to track the frequency of requests for each server.
6. Initialize two pointers, `left = 0` and `right = 0`.
7. Process each sorted query:
   - Add all logs with timestamps less than or equal to the query time.
   - Remove all logs with timestamps strictly less than `time - x`.
   - Remove servers from the HashMap when their request frequency becomes zero.
   - Calculate inactive servers using `n - map.size()`.
   - Store the result using the original query index.
8. Return the answer array.

## Time Complexity

**O(L log L + Q log Q + L + Q)**

Where:
- `L` = Number of logs.
- `Q` = Number of queries.

- Sorting logs: `O(L log L)`.
- Sorting queries: `O(Q log Q)`.
- Sliding window: `O(L)` because each log is added and removed at most once.
- Processing queries: `O(Q)` expected time for HashMap operations.

Overall: **O(L log L + Q log Q)**.

## Space Complexity

**O(L + Q + N)**

- Query array: `O(Q)`.
- Answer array: `O(Q)`.
- HashMap: `O(N)` in the worst case.
- Sorting may require additional implementation-dependent space.

Overall: **O(L + Q + N)** auxiliary space, including the created arrays and HashMap.

## Concepts

- Sorting
- Sliding Window
- Two Pointers
- HashMap
- Frequency Counting
- Offline Query Processing
- Query Index Mapping
