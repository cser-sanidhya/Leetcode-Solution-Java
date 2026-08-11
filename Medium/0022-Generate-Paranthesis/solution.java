class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        StringBuilder current = new StringBuilder();

        generateParentheses(current, 0, 0, n, result);

        return result;
    }

    private void generateParentheses(StringBuilder current, int open, int close, int n, List<String> result) {

        if (open == n && close == n) {
            result.add(current.toString());
            return;
        }

        if (open < n) {

            current.append('(');

            generateParentheses(current, open + 1, close, n, result);

            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {

            current.append(')');

            generateParentheses(current, open, close + 1, n, result);

            current.deleteCharAt(current.length() - 1);
        }
        
    }
}
