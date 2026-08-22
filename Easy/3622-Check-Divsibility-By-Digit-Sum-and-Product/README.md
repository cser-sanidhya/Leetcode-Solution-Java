# 3622. Check Divisibility by Digit Sum and Product

## Approach
1. Create a temporary variable `temp` to preserve the original number.
2. Extract each digit of the number one by one using:
   - `digit = temp % 10`
3. Maintain:
   - `sum` to store the sum of all digits.
   - `product` to store the product of all digits.
4. For every extracted digit:
   - Add it to `sum`.
   - Multiply it with `product`.
5. Remove the last digit using:
   - `temp /= 10`
6. After processing all digits, calculate:
   - `sum + product`
7. Check whether the original number `n` is divisible by `(sum + product)`.
8. Return:
   - `true` if divisible.
   - `false` otherwise.

## Algorithm
1. Initialize:
   - `sum = 0`
   - `product = 1`
   - `temp = n`
2. While `temp > 0`:
   - Extract the last digit:
     - `digit = temp % 10`
   - Update:
     - `sum += digit`
     - `product *= digit`
   - Remove the last digit:
     - `temp /= 10`
3. Compute:
   - `sum + product`
4. Check:
   - `n % (sum + product) == 0`
5. Return the result.

## Time Complexity
Let:
- `d` = number of digits in `n`

The loop processes each digit exactly once.

**Overall Time Complexity:**  
**O(d)**

or

**O(log n)**

## Space Complexity
- Only a few integer variables are used.
- No extra data structure is required.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Mathematics
- Digit Extraction
- Modulo Operator
- Integer Division
- Number Theory
- Simulation
