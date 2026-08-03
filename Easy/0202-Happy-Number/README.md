# 202. Happy Number

## Approach
1. Create a `HashSet` to keep track of all numbers that have already been seen.
2. Repeatedly replace the current number with the sum of the squares of its digits.
3. If the number becomes `1`, it is a happy number, so return `true`.
4. Before processing a number, check if it already exists in the `HashSet`.
   - If it does, a cycle has been detected, meaning the number will never reach `1`. Return `false`.
5. Otherwise, add the number to the `HashSet` and continue the process.
6. The helper method `getNextNumber()` calculates the sum of the squares of the digits of the current number.

This approach works because every unhappy number eventually enters a repeating cycle. The `HashSet` helps detect this cycle efficiently.

## Algorithm
1. Create an empty `HashSet<Integer>` named `Seen`.
2. While `n != 1`:
   - If `Seen` already contains `n`, return `false`.
   - Add `n` to `Seen`.
   - Update `n = getNextNumber(n)`.
3. Return `true` if `n` becomes `1`.
4. In `getNextNumber(n)`:
   - Initialize `Sum = 0`.
   - While `n > 0`:
     - Extract the last digit using `n % 10`.
     - Add the square of the digit to `Sum`.
     - Remove the last digit using `n /= 10`.
   - Return `Sum`.

## Time Complexity
- Each transformation processes all digits of the current number, taking **O(log n)** time.
- The number of unique values before entering a cycle is bounded, and each value is processed at most once.

**Overall Time Complexity:**  
**O(log n)**

where:
- `n` = input number.

## Space Complexity
- The `HashSet` stores all previously seen numbers before a cycle is detected or `1` is reached.

**Overall Space Complexity:**  
**O(log n)**

## Concepts
- HashSet
- Cycle Detection
- Digit Manipulation
- Mathematical Simulation
- Number Theory
