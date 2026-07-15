# 1. Two Sum
## Problem Statement
Find two numbers whose sum equals the target.
## My Approach
  1.Traverse the array once.
  2.Calculate the required complement.
  3.Check if the complement exists in a HashMap.
  4.If found, return the indices.
  5.Otherwise, store the current number and its index.
  ## Java Solution
  class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}

## Time Complexity
  O(n*n)
## Space Complexity
  O(1)
  
