# 3723. Maximize Sum of Squares of Digits (as per provided solution)

## Approach
1. Use a **Greedy Approach** to construct the largest possible number with exactly `num` digits and a digit sum equal to `sum`.
2. Each digit can be at most `9`, so the maximum possible digit sum is `9 × num`.
3. If `num * 9 < sum`, it is impossible to construct such a number, so return an empty string.
4. To maximize the sum of squared digits, place as many `9`s as possible at the beginning of the number.
5. Calculate the number of `9`s using:
   ```java
   int nines = sum / 9;
   ```
6. Calculate the remaining sum:
   ```java
   int remainder = sum % 9;
   ```
7. Append all the `9`s to the result.
8. If the remainder is greater than `0`, append it as the next digit.
9. Append zeros until the result contains exactly `num` digits.
10. Return the constructed string.

## Algorithm
1. Check whether the required digit sum is possible:
   ```java
   if ((long) num * 9 < sum) {
       return "";
   }
   ```
2. Calculate the number of complete `9`s:
   ```java
   int nines = sum / 9;
   ```
3. Calculate the remaining sum:
   ```java
   int remainder = sum % 9;
   ```
4. Create a `StringBuilder`:
   ```java
   StringBuilder ans = new StringBuilder();
   ```
5. Append `nines` occurrences of `'9'`:
   ```java
   for (int i = 0; i < nines; i++) {
       ans.append('9');
   }
   ```
6. If `remainder > 0`, append the remainder:
   ```java
   ans.append(remainder);
   ```
7. Append zeros until the required length is reached:
   ```java
   while (ans.length() < num) {
       ans.append('0');
   }
   ```
8. Return:
   ```java
   return ans.toString();
   ```

## Time Complexity

- Appending the `9`s: **O(sum / 9)**
- Appending the remainder: **O(1)**
- Padding with zeros: **O(num)**

**Overall Time Complexity:**  
**O(num + sum)**

where:
- `num` = required number of digits.
- `sum` = required sum of digits.

## Space Complexity

The `StringBuilder` stores the resulting string of length `num`.

**Overall Space Complexity:**  
**O(num)**

## Concepts
- Greedy
- Strings
- StringBuilder
- Digit Manipulation
- Mathematical Optimization
- Integer Division
- Modulo Operator
- Conditional Statements
