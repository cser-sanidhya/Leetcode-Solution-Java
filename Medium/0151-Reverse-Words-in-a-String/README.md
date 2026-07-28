# 151. Reverse Words in a String

## Approach
1. Remove the leading and trailing spaces using `trim()`.
2. Split the string into individual words using `split("\\s+")`, which handles one or more spaces between words.
3. Create a `StringBuilder` to efficiently build the reversed string.
4. Traverse the `words` array from the last index to the first.
5. Append each word to the `StringBuilder`.
6. Add a single space after each word except the last one.
7. Convert the `StringBuilder` to a string and return it.

This approach ensures that:
- Extra spaces are removed.
- Words are reversed.
- Only a single space exists between consecutive words.

## Algorithm
1. Remove leading and trailing spaces using `trim()`.
2. Split the string into an array of words using `split("\\s+")`.
3. Create an empty `StringBuilder`.
4. Traverse the array from the last element to the first:
   - Append the current word.
   - If it is not the last word to be added, append a single space.
5. Return the final string using `result.toString()`.

## Time Complexity
- `trim()`: **O(n)**
- `split()`: **O(n)**
- Traversing the words array: **O(n)**
- Building the result string: **O(n)**

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the input string.

## Space Complexity
- Words array created by `split()`: **O(n)**
- `StringBuilder`: **O(n)**

**Overall Space Complexity:**  
**O(n)**

## Concepts
- Strings
- String Manipulation
- StringBuilder
- String Splitting
- Reverse Traversal
