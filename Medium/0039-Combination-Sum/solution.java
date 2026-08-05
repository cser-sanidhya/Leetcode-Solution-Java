class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) { 
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();

        generateCombination(0, candidates, target, currentCombination, result);
        return result;
    }

    private void generateCombination(int index, int[] candidates, int target, List<Integer> currentCombination, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        if (target < 0 || index == candidates.length) {
            return;
        }

        currentCombination.add(candidates[index]);

        generateCombination(index, candidates, target - candidates[index], currentCombination, result);

        currentCombination.remove(currentCombination.size() - 1);

        generateCombination(index + 1, candidates, target, currentCombination, result);
        
    }
}
