# 383. Ransom Note

## Approach
1. Create a `HashMap` to store the frequency of each character in the `magazine`.
2. Traverse the `magazine` string:
   - If the character already exists in the map, increment its frequency.
   - Otherwise, insert it into the map with a frequency of `1`.
3. Traverse the `ransomNote` string:
   - If a character is not present in the map or its frequency is `0`, return `false` because the required character is unavailable.
   - Otherwise, decrement the frequency of that character in the map.
4. If all characters of the `ransomNote` are successfully matched, return `true`.

This approach works because the `HashMap` keeps track of how many times each character is available in the `magazine`. As characters are used, their frequencies are reduced.

## Algorithm
1. Create a `HashMap<Character, Integer>` to store character frequencies.
2. Traverse the `magazine` string:
   - If the character exists in the map, increment its count.
   - Otherwise, insert the character with frequency `1`.
3. Traverse the `ransomNote` string:
   - If the character is missing from the map or its count is `0`, return `false`.
   - Otherwise, decrement its frequency by `1`.
4. After processing all characters, return `true`.

## Time Complexity
- Traversing `magazine`: **O(m)**
- Traversing `ransomNote`: **O(n)**
- HashMap lookup and update: **O(1)** (average)

**Overall Time Complexity:**  
**O(m + n)**

where:
- `m` = length of `magazine`
- `n` = length of `ransomNote`

## Space Complexity
- The `HashMap` stores the frequency of each unique character in the `magazine`.

**Overall Space Complexity:**  
**O(m)**

## Concepts
- Strings
- HashMap
- Frequency Counting
- Character Matching
- Greedy
