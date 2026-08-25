# 3718. Missing Multiple

## Approach
1. We need to find the **smallest positive multiple of `k`** that does not appear in the array.
2. Store all elements of `nums` in a **HashSet** for efficient lookups.
3. Start checking multiples of `k` beginning with:
   - `multiple = k`
4. If the current multiple exists in the set:
   - Move to the next multiple by adding `k`.
5. Continue until a multiple is found that is not present in the array.
6. Return that missing multiple.

Using a HashSet allows us to check whether a multiple exists in constant time on average.

## Algorithm
1. Create a HashSet:
   - `set = new HashSet<>()`
2. Insert every element of `nums` into the set.
3. Initialize:
   - `multiple = k`
4. While:
   - `set.contains(multiple)`
     - `multiple += k`
5. Return:
   - `multiple`

## Time Complexity
Let:
- `n` = length of `nums`
- `m` = number of consecutive multiples of `k` present in the array

### Building the HashSet
- Insert all elements: **O(n)**

### Finding the Missing Multiple of K
- Each lookup takes **O(1)** on average.
- At most `m + 1` multiples are checked.

**Overall Time Complexity:**  
**O(n + m)**

In the worst case:

**O(n)**

## Space Complexity
- HashSet stores all elements from the array.

**Overall Space Complexity:**  
**O(n)**

## Concepts
- Arrays
- HashSet
- Hashing
- Simulation
- Greedy Search
- Multiples
- Constant-Time Lookup
