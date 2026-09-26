# 1807. Evaluate the Bracket Pairs of a String

## Approach

1. Use a **HashMap** to store all key-value pairs from the `knowledge` list.
2. Traverse the string character by character.
3. When an opening bracket `'('` is encountered:

   * Start collecting characters to form a key.
4. Continue storing characters inside the brackets using a `StringBuilder`.
5. When a closing bracket `')'` is encountered:

   * Look up the collected key in the HashMap.
   * If the key exists, append its corresponding value.
   * Otherwise, append `"?"`.
6. Characters outside brackets are directly added to the result.
7. Continue until the entire string has been processed.
8. Return the final evaluated string.

## Algorithm

1. Create a HashMap:

   ```java
   Map<String, String> map = new HashMap<>();
   ```
2. Insert all key-value pairs from `knowledge` into the map.
3. Create:

   ```java
   StringBuilder result = new StringBuilder();
   StringBuilder key = new StringBuilder();
   ```
4. Maintain a boolean flag:

   ```java
   insideBracket = false;
   ```
5. Traverse every character in the string.
6. If the character is `'('`:

   * Set:

     ```java
     insideBracket = true;
     ```
   * Clear the key builder.
7. If the character is `')'`:

   * Set:

     ```java
     insideBracket = false;
     ```
   * Append:

     ```java
     map.getOrDefault(key.toString(), "?")
     ```

     to the result.
8. If the character is neither bracket:

   * If currently inside brackets:

     ```java
     key.append(ch);
     ```
   * Otherwise:

     ```java
     result.append(ch);
     ```
9. After processing all characters:

   ```java
   return result.toString();
   ```

## Time Complexity

* Building the HashMap takes **O(k)** where `k` is the number of knowledge pairs.
* Traversing the string takes **O(n)**.

**Overall Time Complexity:**
**O(n + k)**

where:

* `n` = length of the string.
* `k` = number of knowledge pairs.

## Space Complexity

* HashMap stores all knowledge pairs.
* StringBuilders store the result and current key.

**Auxiliary Space Complexity:**
**O(k + n)**

**Overall Space Complexity:**
**O(k + n)**

## Concepts

* Strings
* HashMap
* StringBuilder
* Parsing
* Simulation
* Character Traversal
* Key-Value Lookup
* String Processing
