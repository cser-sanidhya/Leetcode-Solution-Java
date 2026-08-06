class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();

        Arrays.sort(nums);

        generateSubsets(0, nums, currentSubset, result);
        return result;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> currentSubset, List<List<Integer>> result) {

        if (index == nums.length) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }

        currentSubset.add(nums[index]);
        generateSubsets(index + 1, nums, currentSubset, result);

        currentSubset.remove(currentSubset.size() - 1);

        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

        generateSubsets(index + 1, nums, currentSubset, result);

        
    }
}
