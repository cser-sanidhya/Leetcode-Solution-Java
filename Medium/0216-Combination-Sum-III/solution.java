class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        backtrack(1, current, 0, k, n, result);

        return result;
    }

    private void backtrack(int start, List<Integer> current, int sum, int k, int n, List<List<Integer>> result) {

        if (sum > n) {
            return;
        }

        if (current.size() == k) {

            if (sum == n) {
                result.add(new ArrayList<>(current));
            }

            return;
        }

        for (int i = start; i <= 9; i++) {

            current.add(i);

            backtrack( i + 1, current, sum + i, k, n, result);

            current.remove(current.size() - 1);
        }
        
    }
}
