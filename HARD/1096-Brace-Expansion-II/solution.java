
class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression);
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> parse(String expr) {
        Stack<Set<String>> stack = new Stack<>();
        Stack<Character> ops = new Stack<>();

        int i = 0;
        while (i < expr.length()) {
            char c = expr.charAt(i);

            if (c == '{') {
                if (i > 0 && (Character.isLetter(expr.charAt(i - 1)) || expr.charAt(i - 1) == '}')) {
                    while (!ops.isEmpty() && ops.peek() == '*') {
                        evaluate(stack, ops);
                    }
                    ops.push('*');
                }
                ops.push('{');
            } 
            else if (c == '}') {
                while (!ops.isEmpty() && ops.peek() != '{') {
                    evaluate(stack, ops);
                }
                ops.pop();

                if (!ops.isEmpty() && ops.peek() == '*') {
                    evaluate(stack, ops);
                }
            } 
            else if (c == ',') {
                while (!ops.isEmpty() && ops.peek() == '*') {
                    evaluate(stack, ops);
                }
                ops.push(',');
            } 
            else {
                if (i > 0 && (Character.isLetter(expr.charAt(i - 1)) || expr.charAt(i - 1) == '}')) {
                    while (!ops.isEmpty() && ops.peek() == '*') {
                        evaluate(stack, ops);
                    }
                    ops.push('*');
                }

                Set<String> set = new HashSet<>();
                set.add(String.valueOf(c));
                stack.push(set);
            }
            i++;
        }

        while (!ops.isEmpty()) {
            evaluate(stack, ops);
        }

        return stack.pop();
    }

    private void evaluate(Stack<Set<String>> stack, Stack<Character> ops) {
        char op = ops.pop();

        Set<String> b = stack.pop();
        Set<String> a = stack.pop();

        Set<String> res = new HashSet<>();

        if (op == ',') {
            res.addAll(a);
            res.addAll(b);
        } else {
            for (String s1 : a) {
                for (String s2 : b) {
                    res.add(s1 + s2);
                }
            }
        }

        stack.push(res);
    }
}
