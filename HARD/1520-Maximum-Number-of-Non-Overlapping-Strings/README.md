# 1520. Maximum Number of Non-Overlapping Substrings

## Approach

1. For every character, find its **first** and **last** occurrence in the string.
2. Each character can potentially define a valid substring starting from its first occurrence and ending at its last occurrence.
3. Expand the interval whenever a character inside the current interval has a last occurrence outside the current boundary.
4. If any character inside the interval has its first occurrence before the current start, the interval becomes invalid.
5. Store all valid intervals.
6. Sort the intervals by their ending position.
7. Use a **Greedy Interval Scheduling** approach:

   * Always pick the interval that ends earliest.
   * This maximizes the number of non-overlapping substrings.
8. Convert the selected intervals into substrings and return them.

## Algorithm

1. Let `n` be the length of the string.
2. Create two arrays:

   ```java
   first[26]
   last[26]
   ```
3. Initialize:

   * `first` with `n`
   * `last` with `-1`
4. Traverse the string:

   * Update the first occurrence of each character.
   * Update the last occurrence of each character.
5. For every character from `'a'` to `'z'`:

   * Skip if the character does not appear.
6. Set:

   ```java
   start = first[c]
   end = last[c]
   ```
7. Expand the interval:

   * Traverse from `start` to `end`.
   * For each character:

     * If its first occurrence is before `start`, mark interval as invalid.
     * Update:

       ```java
       end = Math.max(end, last[current])
       ```
8. If the interval remains valid:

   * Store `(start, end)` in the interval list.
9. Sort all valid intervals by their ending index.
10. Greedily select intervals:

    * Maintain `prevEnd`.
    * If:

      ```java
      start > prevEnd
      ```

      choose the interval.
11. Add:

    ```java
    s.substring(start, end + 1)
    ```

    to the result.
12. Return the result list.

## Time Complexity

* Finding first and last occurrences: **O(n)**
* Building valid intervals: **O(26 × n)**
* Sorting at most 26 intervals: **O(26 log 26)**
* Greedy selection: **O(26)**

**Overall Time Complexity:**
**O(n)**

where:

* `n` = length of the string.

## Space Complexity

* `first` array: **O(26)**
* `last` array: **O(26)**
* Interval list stores at most 26 intervals.

**Auxiliary Space Complexity:**
**O(1)**

(Only fixed-size arrays and interval storage are used.)

**Overall Space Complexity:**
**O(1)**

## Concepts

* Strings
* Greedy
* Interval Scheduling
* Character Frequency Tracking
* First and Last Occurrence
* Interval Expansion
* Sorting
* Non-overlapping Intervals
