# 2913. Subarrays Distinct Element Sum of Squares I

## Approach
1. Use **Brute Force + HashSet** to calculate the sum of squared distinct-element counts for all subarrays.
2. Traverse the array using two nested loops to generate every possible subarray.
3. For each starting index `i`, create an empty `HashSet` to store distinct elements.
4. Use the inner loop with index `j` to extend the subarray from `i` to `j`.
5. Add `nums.get(j)` to the HashSet.
   - Since a HashSet stores only unique elements, duplicate values are counted only once.
6. Calculate the number of distinct elements using:
   ```java
   int count = set.size();
   ```
7. Square the distinct-element count and add it to `sum`:
   ```java
   sum += count * count;
   ```
8. Continue until every possible subarray has been processed.
9. Return the final sum.

## Algorithm
1. Find the length of the list:
   ```java
   int n = nums.size();
   ```
2. Initialize:
   ```java
   int sum = 0;
   ```
3. Iterate through every possible starting index `i`.
4. Create a new HashSet for each starting index:
   ```java
   HashSet<Integer> set = new HashSet<>();
   ```
5. Iterate through every ending index `j`, starting from `i`.
6. Add the current element to the set:
   ```java
   set.add(nums.get(j));
   ```
7. Calculate the number of distinct elements:
   ```java
   int count = set.size();
   ```
8. Add its square to the total:
   ```java
   sum += count * count;
   ```
9. Repeat until all subarrays have been considered.
10. Return:
    ```java
    return sum;
    ```

## Time Complexity

- The outer loop runs **O(n)** times.
- The inner loop runs up to **O(n)** times for each starting index.
- HashSet insertion takes **O(1)** average time.

**Overall Time Complexity:**  
**O(n²)** average time

where:
- `n` = number of elements in the list.

## Space Complexity

A HashSet stores at most `n` distinct elements for each starting index.

**Overall Space Complexity:**  
**O(n)**

## Concepts
- Arrays and Lists
- Brute Force
- Nested Loops
- HashSet
- Distinct Elements
- Subarrays
- Set Operations
- Counting and Squaring
