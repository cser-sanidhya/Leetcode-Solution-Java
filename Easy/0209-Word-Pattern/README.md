# 290. Word Pattern

## Approach
1. Split the input string `s` into an array of words using spaces.
2. If the number of words is not equal to the length of the `pattern`, return `false`.
3. Create a `HashMap` to map each character in the pattern to a corresponding word.
4. Traverse the pattern and the words simultaneously.
5. For each character:
   - If the character already exists in the map, check whether it maps to the current word.
     - If not, return `false`.
   - Otherwise:
     - Ensure the current word is not already mapped to another character using `containsValue()`.
     - If it is, return `false`.
     - Otherwise, add the new character-word mapping to the map.
6. If all mappings are consistent, return `true`.

This approach ensures a **one-to-one correspondence (bijection)** between pattern characters and words.

## Algorithm
1. Split `s` into an array of words using `split(" ")`.
2. If `pattern.length() != words.length`, return `false`.
3. Create a `HashMap<Character, String>`.
4. Traverse from `i = 0` to `pattern.length() - 1`:
   - Let:
     - `c = pattern.charAt(i)`
     - `word = words[i]`
   - If `c` exists in the map:
     - If the mapped word is not equal to `word`, return `false`.
   - Otherwise:
     - If the map already contains `word` as a value, return `false`.
     - Insert the mapping `(c, word)` into the map.
5. Return `true`.

## Time Complexity
- Splitting the string: **O(n)**
- Traversing the pattern: **O(n)**
- `containsKey()` and `get()` operations: **O(1)** (average)
- `containsValue()` operation: **O(n)** because it searches through all values.

**Overall Time Complexity:**  
**O(n²)**

where:
- `n` = number of words (or length of the pattern).

## Space Complexity
- The `HashMap` stores the mapping between pattern characters and words.

**Overall Space Complexity:**  
**O(n)**

## Concepts
- Strings
- HashMap
- Hashing
- One-to-One Mapping (Bijection)
- String Splitting
- Simulation
