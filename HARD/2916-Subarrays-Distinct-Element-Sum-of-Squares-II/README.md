# 2916. Subarrays Distinct Element Sum of Squares II

## Approach
1. Use a **Segment Tree with Lazy Propagation** to efficiently calculate the sum of squared distinct-element counts for all subarrays.
2. Fix the right endpoint `r` and consider every subarray ending at `r`.
3. Maintain a segment tree where each index `l` represents the subarray `nums[l...r]`.
   - `sum[l]` conceptually stores the distinct count of that subarray.
   - `squareSum[l]` stores the square of its distinct count.
4. Use a `lastSeen` array to track the most recent index of each value.
5. When processing `nums[r]`, let `prev` be its previous occurrence. The value `nums[r]` introduces a new distinct element into subarrays starting at indices `prev + 1` through `r`.
6. Perform a range increment on `[prev + 1, r]` in the segment tree.
   - This increases the distinct count of each affected subarray by `1`.
   - Lazy propagation applies updates efficiently without visiting every index.
7. For a range increment, update the sum of squares using:
   \[
   (x+1)^2=x^2+2x+1
   \]
   Thus, for a segment of length `L`:
   - New squared sum = old squared sum + `2 × old sum + L`.
   - New sum = old sum + `L`.
8. After each right endpoint is processed, `squareSum[1]` contains the sum of squared distinct counts for all subarrays ending at `r`.
9. Add this value to `answer`, modulo `1,000,000,007`.
10. Return the final answer.

## Algorithm
1. Initialize:
   ```java
   int n = nums.length;
   SegmentTree tree = new SegmentTree(n);
   int[] lastSeen = new int[100001];

   Arrays.fill(lastSeen, -1);
   long answer = 0;
   ```
2. Traverse the array using right endpoint `r`.
3. Find the previous occurrence:
   ```java
   int prev = lastSeen[nums[r]];
   ```
4. Update the segment tree over the range:
   ```java
   tree.update(prev + 1, r);
   ```
   This increments the distinct count for all subarrays ending at `r` that now include a new distinct value.
5. Add the segment tree's total squared count:
   ```java
   answer = (answer + tree.squareSum[1]) % MOD;
   ```
6. Update the last occurrence:
   ```java
   lastSeen[nums[r]] = r;
   ```
7. In the segment tree:
   - `sum[]` stores the sum of distinct counts across a segment.
   - `squareSum[]` stores the sum of their squares.
   - `lazy[]` stores pending range increments.
8. When applying an increment to a fully covered segment:
   ```java
   long length = end - start + 1L;

   squareSum[node] =
       (squareSum[node] + 2L * sum[node] + length) % MOD;

   sum[node] = (sum[node] + length) % MOD;
   lazy[node]++;
   ```
9. Push pending lazy updates to child segments when further partial updates are needed.
10. Combine child sums and squared sums after recursive updates.
11. Return:
    ```java
    return (int) answer;
    ```

## Time Complexity

- Processing each array element requires one segment-tree range update.
- Each range update takes **O(log n)** time.
- The segment tree uses **O(n)** space.

**Overall Time Complexity:**  
**O(n log n)**

where:
- `n` = length of the array.

## Space Complexity

- Segment tree arrays (`sum`, `squareSum`, and `lazy`): **O(n)**
- `lastSeen` array: **O(100001)**, which is fixed for the given value constraints.

**Overall Space Complexity:**  
**O(n + U)**

where:
- `U` = the size of the value range used by `lastSeen`.

With the fixed-size `lastSeen` array in this implementation, the complexity is commonly expressed as **O(n)**.

## Concepts
- Arrays
- Segment Tree
- Lazy Propagation
- Range Updates
- Distinct Element Counting
- Subarrays
- Sum of Squares
- Last Occurrence Tracking
- Modular Arithmetic
- Optimization
