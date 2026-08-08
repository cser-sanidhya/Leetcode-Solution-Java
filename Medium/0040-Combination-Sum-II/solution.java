class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        Arrays.sort(candidates);

        helper(0, candidates, target, current, result);

        return result;
    }

    private void helper( int index, int[] candidates, int target, List<Integer> current, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index == candidates.length) {
            return;
        }

        current.add(candidates[index]);

        helper(index + 1, candidates, target - candidates[index], current, result);

        current.remove(current.size() - 1);

        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }

        helper(index + 1, candidates, target, current, result);
        
    }
}
