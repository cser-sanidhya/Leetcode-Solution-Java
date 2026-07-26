# 242. Valid Anagram

## Approach
1. First, compare the lengths of both strings.
   - If the lengths are different, they cannot be anagrams, so return `false`.
2. Convert both strings into character arrays using `toCharArray()`.
3. Sort both character arrays using `Arrays.sort()`.
4. Compare the sorted arrays using `Arrays.equals()`.
5. If both arrays are identical, the strings are anagrams; otherwise, they are not.

This approach works because two anagrams contain the same characters with the same frequency. After sorting, both strings will have the characters in the same order if they are anagrams.

## Algorithm
1. Check if `s.length() != t.length()`:
   - If true, return `false`.
2. Convert both strings into character arrays:
   - `str1 = s.toCharArray()`
   - `str2 = t.toCharArray()`
3. Sort both arrays using `Arrays.sort()`.
4. Compare the sorted arrays using `Arrays.equals(str1, str2)`.
5. Return the comparison result.

## Time Complexity
- Converting strings to character arrays: **O(n)**
- Sorting both arrays:
  - `Arrays.sort(str1)` → **O(n log n)**
  - `Arrays.sort(str2)` → **O(n log n)**
- Comparing both arrays: **O(n)**

**Overall Time Complexity:**  
**O(n log n)**

where:
- `n` = length of the strings.

## Space Complexity
- Two character arrays of size `n` are created.

**Overall Space Complexity:**  
**O(n)**

## Concepts
- Strings
- Character Arrays
- Sorting
- Array Comparison
- Anagram Checking
