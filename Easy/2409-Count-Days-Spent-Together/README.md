# 2409. Count Days Spent Together

## Approach

The goal is to calculate the number of days Alice and Bob are both present, including their arrival and departure dates.

We convert each date into its corresponding day number in a non-leap year, then find the overlapping interval.

1. Convert Alice's arrival and departure dates into day numbers.
2. Convert Bob's arrival and departure dates into day numbers.
3. Find the later arrival date using `Math.max()`.
4. Find the earlier departure date using `Math.min()`.
5. Calculate the number of overlapping days using `end - start + 1`.
6. If there is no overlap, return `0` using `Math.max(0, ...)`.

## Algorithm

1. Calculate the common start day:

   ```java
   int start = Math.max(toDays(arriveAlice), toDays(arriveBob));
   ```

2. Calculate the common end day:

   ```java
   int end = Math.min(toDays(leaveAlice), toDays(leaveBob));
   ```

3. In `toDays()`:
   - Extract the month and day from the date string.
   - Initialize `total` with the day of the month.
   - Add the number of days in all preceding months.
   - Return the resulting day number.
4. Calculate the inclusive overlap:

   ```java
   return Math.max(0, end - start + 1);
   ```

## Time Complexity

- Converting each date takes O(1), because there are only 12 months.
- Calculating the overlap takes O(1).

Overall Time Complexity: **O(1)**

## Space Complexity

- Only a fixed-size array and a constant number of variables are used.

Overall Space Complexity: **O(1)**

## Concepts

- Date Conversion
- String Manipulation
- Interval Intersection
- Minimum and Maximum
- Inclusive Range Calculation
