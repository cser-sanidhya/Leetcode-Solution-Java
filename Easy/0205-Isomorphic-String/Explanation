# 205. Isomorphic Strings

## Approach
1. Use two `HashMap`s to maintain a one-to-one mapping between the characters of both strings.
2. `map1` stores the mapping from characters in `s` to characters in `t`.
3. `map2` stores the reverse mapping from characters in `t` to characters in `s`.
4. Traverse both strings simultaneously.
5. For each pair of characters:
   - If the mapping already exists, verify that it matches the current character.
   - If it does not match, return `false`.
   - Otherwise, create the new mapping.
6. If all character mappings are valid throughout the traversal, return `true`.

Using two maps ensures that:
- One character in `s` cannot map to multiple characters in `t`.
- Multiple characters in `s` cannot map to the same character in `t`.

## Algorithm
1. Create two `HashMap<Character, Character>` objects:
   - `map1` for mapping `s → t`
   - `map2` for mapping `t → s`
2. Traverse both strings from index `0` to `s.length() - 1`.
3. For each index:
   - Get:
     - `ch1 = s.charAt(i)`
     - `ch2 = t.charAt(i)`
4. Check `map1`:
   - If `ch1` already exists:
     - If its mapped value is not `ch2`, return `false`.
   - Otherwise, insert `(ch1, ch2)` into `map1`.
5. Check `map2`:
   - If `ch2` already exists:
     - If its mapped value is not `ch1`, return `false`.
   - Otherwise, insert `(ch2, ch1)` into `map2`.
6. If the loop completes without conflicts, return `true`.

## Time Complexity
- Single traversal of both strings: **O(n)**
- HashMap lookup and insertion: **O(1)** (average)

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the strings.

## Space Complexity
- Two `HashMap`s store at most one entry for each unique character.

**Overall Space Complexity:**  
**O(n)**

## Concepts
- Strings
- HashMap
- Bidirectional Mapping
- Character Mapping
- One-to-One Relationship
