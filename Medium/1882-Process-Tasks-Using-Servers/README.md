# 1882. Process Tasks Using Servers

## Approach

Use **Two Priority Queues (Min Heaps)** to efficiently manage available and busy servers.

Each server has:
- A weight (processing priority).
- An index (original position in the `servers` array).

The problem requires assigning each task to the available server with the smallest weight. If multiple servers have the same weight, choose the one with the smallest index.

Maintain two priority queues:

### 1. Available Servers

The `available` priority queue stores servers that are currently free.

Each entry contains:

```java
new int[]{weight, index}
```

Servers are ordered by:
1. Smaller weight.
2. Smaller server index.

### 2. Busy Servers

The `busy` priority queue stores servers currently processing tasks.

Each entry contains:

```java
new int[]{finishTime, weight, index}
```

Servers are ordered by:
1. Earlier finishing time.
2. Smaller weight.
3. Smaller server index.

### 3. Task Assignment

For every task:

1. Set the current time to the task's arrival time (`i`).
2. Move all servers whose finishing time is less than or equal to the current time from `busy` to `available`.
3. If no server is available:
   - Move the current time forward to the earliest finishing time.
   - Release all servers that become free at that time.
4. Select the server at the top of `available`.
5. Store its index in the answer array.
6. Insert the selected server into `busy` with its new finishing time:

```java
time + tasks[i]
```

Repeat until all tasks are assigned...

## Algorithm

1. Initialize the answer array `ans` of size `m`.
2. Create two min heaps:
   - `available`: Orders servers by weight and index.
   - `busy`: Orders servers by finishing time, weight, and index.
3. Insert all servers into the `available` priority queue.
4. Iterate through all tasks:
   - Set `time = i`.
   - Release every server that has completed its task.
   - If `available` is empty, advance time to the earliest server finishing time.
   - Release all servers that are free at the updated time.
   - Extract the highest-priority available server.
   - Store its index in `ans[i]`.
   - Calculate its finishing time and insert it into `busy`.
5. Return the answer array.

## Time Complexity

**O((n + m) log n)**

- Inserting all `n` servers into the priority queue takes `O(n log n)`.
- Each server enters and leaves the busy queue at most once per task assignment cycle.
- Each task requires priority queue operations taking `O(log n)`.
- Across all tasks, the total number of server insertions and removals is bounded by `O(m)`.

Overall: **O((n + m) log n)**.

## Space Complexity

**O(n + m)**

- `available` and `busy` priority queues together store at most `n` servers: `O(n)`.
- The answer array stores `m` server indices: `O(m)`.

Overall: **O(n + m)**, including the output array.

## Concepts

- Priority Queue
- Min Heap
- Greedy Algorithm
- Simulation
- Server Scheduling
- Custom Comparator
- Task Scheduling
