# 1927. Sum Game

## Approach
1. Split the string into two halves:
   - Left half
   - Right half
2. Calculate:
   - `leftSum` → sum of known digits in the left half.
   - `rightSum` → sum of known digits in the right half.
   - `leftQ` → number of `'?'` in the left half.
   - `rightQ` → number of `'?'` in the right half.
3. Alice and Bob replace the `'?'` characters optimally:
   - Alice tries to make the final sums unequal.
   - Bob tries to make the final sums equal.
4. Instead of simulating the game, use the mathematical observation:
   - Bob can force a tie only when:

     `2 × (leftSum - rightSum) = 9 × (rightQ - leftQ)`

5. If the above equation holds:
   - Bob can always make the sums equal.
   - Alice loses.
6. Otherwise:
   - Alice can force the sums to be different.
   - Alice wins.

The entire game can therefore be solved using a simple mathematical condition.

## Algorithm
1. Let:
   - `n = num.length()`
   - `mid = n / 2`
2. Initialize:
   - `leftSum = 0`
   - `rightSum = 0`
   - `leftQ = 0`
   - `rightQ = 0`
3. Traverse the left half:
   - If character is `'?'`
     - Increment `leftQ`
   - Else
     - Add digit value to `leftSum`
4. Traverse the right half:
   - If character is `'?'`
     - Increment `rightQ`
   - Else
     - Add digit value to `rightSum`
5. Check:
   - `2 * (leftSum - rightSum) != 9 * (rightQ - leftQ)`
6. If true:
   - Return `true` (Alice wins)
7. Otherwise:
   - Return `false` (Bob wins)

## Time Complexity
- The string is traversed once.

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the string.

## Space Complexity
- Only a few integer variables are used.
- No extra data structures are required.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Strings
- Mathematics
- Game Theory
- Greedy Observation
- Simulation Reduction
- Counting
- Optimal Play
