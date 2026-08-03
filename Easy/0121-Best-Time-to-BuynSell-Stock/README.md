# 121. Best Time to Buy and Sell Stock

## Approach
1. Assume the first day's price is the lowest buying price.
2. Traverse the array from the second day onwards.
3. For each price:
   - If the current price is lower than the recorded lowest price, update the lowest price.
   - Otherwise, calculate the profit by selling on the current day.
4. Compare the current profit with the maximum profit found so far and update it if necessary.
5. After traversing the entire array, return the maximum profit.

This approach works because we always try to buy at the lowest price seen so far and sell at the current day's price to maximize profit.

## Algorithm
1. Initialize:
   - `lowestPrice = prices[0]`
   - `maxProfit = 0`
2. Traverse the array from index `1` to `prices.length - 1`.
3. For each price:
   - If `prices[i] < lowestPrice`:
     - Update `lowestPrice`.
   - Otherwise:
     - Calculate `profit = prices[i] - lowestPrice`.
     - If `profit > maxProfit`, update `maxProfit`.
4. Return `maxProfit`.

## Time Complexity
- Single traversal of the array: **O(n)**

**Overall Time Complexity:**  
**O(n)**

where:
- `n` = length of the `prices` array.

## Space Complexity
- Only two variables (`lowestPrice` and `maxProfit`) along with a temporary variable (`profit`) are used.

**Overall Space Complexity:**  
**O(1)**

## Concepts
- Arrays
- Greedy
- One-pass Traversal
- Maximum Profit Calculation
- Running Minimum
