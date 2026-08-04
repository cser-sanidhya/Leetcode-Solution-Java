class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> currentSubset = new ArrayList<>();

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

        generateSubsets(index + 1, nums, currentSubset, result);
    }
}
