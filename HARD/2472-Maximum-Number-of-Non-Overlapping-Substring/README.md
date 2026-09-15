# 2472. Maximum Number of Non-overlapping Palindrome Substrings

## Approach

1. We need to find the **maximum number of non-overlapping palindromic substrings** whose length is at least `k`.
2. First, precompute whether every substring `s[i...j]` is a palindrome using **Dynamic Programming**.
3. Create a 2D boolean array `isPalindrome` where:

   * `isPalindrome[i][j] = true` if the substring from index `i` to `j` is a palindrome.
4. After identifying all palindromic substrings, use another DP array:

   * `dp[i]` = maximum number of valid non-overlapping palindromes that can be formed using the first `i` characters.
5. For each position `i`:

   * Skip the current character and inherit the previous answer.
   * Try every possible starting position `j` such that the substring length is at least `k`.
6. If `s[j...i-1]` is a palindrome:

   * Include it and update:

     ```java
     dp[i] = Math.max(dp[i], dp[j] + 1);
     ```
7. The final answer is stored in `dp[n]`.

## Algorithm

### Step 1: Precompute Palindromes

1. Let `n = s.length()`.
2. Create:

   ```java
   boolean[][] isPalindrome = new boolean[n][n];
   ```
3. Every single character is a palindrome:

   ```java
   isPalindrome[i][i] = true;
   ```
4. For every possible substring length from `2` to `n`:

   * Let:

     ```java
     int j = i + len - 1;
     ```
   * If:

     ```java
     s.charAt(i) == s.charAt(j)
     ```

     and either:

     * `len == 2`, or
     * `isPalindrome[i + 1][j - 1]` is true
   * Then:

     ```java
     isPalindrome[i][j] = true;
     ```

### Step 2: Dynamic Programming for Maximum Count

5. Create:

   ```java
   int[] dp = new int[n + 1];
   ```
6. For each position `i` from `1` to `n`:

   * Initially:

     ```java
     dp[i] = dp[i - 1];
     ```

     (skip current character)
7. Try all valid starting positions:

   ```java
   for (int j = 0; j <= i - k; j++)
   ```
8. If:

   ```java
   isPalindrome[j][i - 1]
   ```

   then update:

   ```java
   dp[i] = Math.max(dp[i], dp[j] + 1);
   ```
9. Return:

   ```java
   dp[n];
   ```

## Time Complexity

### Palindrome Precomputation

The `isPalindrome` table contains `n²` states.

**Time:** `O(n²)`

### DP Computation

For every index `i`, we may iterate through all previous indices `j`.

**Time:** `O(n²)`

### Overall Time Complexity

**O(n²)**

where:

* `n` = length of the string.

## Space Complexity

### Palindrome Table

```java
boolean[n][n]
```

requires:

**O(n²)**

### DP Array

```java
int[n + 1]
```

requires:

**O(n)**

### Overall Space Complexity

**O(n²)**

## Concepts

* Dynamic Programming
* String DP
* Palindrome Detection
* Interval DP
* Non-overlapping Substrings
* 2D DP
* Optimization DP
* Recurrence Relations
