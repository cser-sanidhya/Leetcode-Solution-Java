# 283. Move Zeroes

## Problem

Move all zeros to the end while maintaining the relative order of non-zero elements.

## My Thought Process

Initially, I thought about creating another array.

Then I realized I could solve it using two pointers.

## Approach

Use one pointer to track where the next non-zero element should be placed.

Traverse the array.

Whenever a non-zero element is found,
swap it with the position of the first zero.

## Time Complexity

O(n)

## Space Complexity

O(1)

## What I Learned

- Two Pointer technique
- In-place swapping
- Constant space optimization
