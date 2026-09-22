# 3525. Find the X Value of Array II

## Approach

1. Use a **Segment Tree** to efficiently handle:

   * Point updates on the array.
   * Queries on suffix ranges after each update.
2. For every segment, store:

   * `product` → Product of all elements in the segment modulo `k`.
   * `count[r]` → Number of prefixes within the segment whose product modulo `k` equals `r`.
3. For a leaf node:

   * The segment contains a single value.
   * Its product modulo `k` is stored.
   * The corresponding remainder count is incremented.
4. While merging two segments:

   * Compute the combined segment product modulo `k`.
   * Copy all valid prefix counts from the left segment.
   * Transform the prefix counts of the right segment using the left segment's product.
   * Add the transformed counts to the result node.
5. For every query:

   * Update the value at the given index.
   * Query the segment tree for the suffix range `[start, n - 1]`.
   * Return the count of prefixes whose product modulo `k` equals `x`.

The segment tree allows updates and range queries to be processed efficiently without recomputing the entire suffix after every modification.

## Algorithm

1. Create a `Node` class containing:

   ```java
   int product;
   int[] count;
   ```
2. Build a segment tree over the array.
3. For a leaf node:

   * Compute:

     ```java
     value % k
     ```
   * Store it as the segment product.
   * Increment its corresponding remainder frequency.
4. Merge two child nodes:

   * Compute:

     ```java
     product = (left.product * right.product) % k;
     ```
   * Copy all counts from the left child.
   * For every remainder in the right child:

     ```java
     transformed = (left.product * remainder) % k;
     ```
   * Add transformed frequencies into the merged node.
5. For each query:

   * Perform a point update.
   * Query the segment tree on:

     ```java
     [start, n - 1]
     ```
6. Retrieve:

   ```java
   res.count[x]
   ```
7. Store the result in the answer array.
8. Return the final answer array.

## Time Complexity

Let:

* `n` = length of the array.
* `q` = number of queries.

### Build

Each node merge processes `k` remainders.

**O(n · k)**

### Update

Segment tree height is `O(log n)`.

Each merge costs `O(k)`.

**O(k · log n)**

### Query

Segment tree traversal takes `O(log n)` nodes.

Each merge costs `O(k)`.

**O(k · log n)**

### Overall

For `q` queries:

**O(n · k + q · k · log n)**

## Space Complexity

### Segment Tree

Stores:

```java
4 * n nodes
```

Each node contains:

```java
count[k]
```

Therefore:

**O(n · k)**

## Concepts

* Segment Tree
* Range Query
* Point Update
* Prefix Product
* Modular Arithmetic
* Frequency Counting
* Divide and Conquer
* Data Structures
* Query Processing
* Array Manipulation
