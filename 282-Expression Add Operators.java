class Solution {
    
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        if (num.length() == 1) {
            if (Integer.parseInt(num) == target) {
                result.add(num);
            }
            return result;
        }
        
        List<String> exprs = new ArrayList<>();
        exprs.add(num.substring(0, 1));
        exprs = addOperators(exprs, num, 1);
        
        exprs.forEach(expr -> {
            Long value = eval(expr);
            if (value != null && value == target) {
                result.add(expr);
            }
        });
        return result;
    }
    
    private List<String> addOperators(List<String> exprs, String num, int index) {
        if (index < num.length()) {
            List<String> next = new ArrayList<>(exprs.size() * 4);
            for (String expr : exprs) {
                char c = num.charAt(index);
                next.add(expr + c);
                next.add(expr + '+' + c);
                next.add(expr + '-' + c);
                next.add(expr + '*' + c);
            }
            return addOperators(next, num, index + 1);
        }
        return exprs;
    }
    
    private Long eval(String s) {
        char[] arr = s.toCharArray();
        int i = 0, len = arr.length;
        LinkedList<Object> postfix = new LinkedList<>();
        LinkedList<Character> operator = new LinkedList<>();

        while (i < len) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                if (arr[i] == '0' && i + 1 < len && arr[i + 1] >= '0' && arr[i + 1] <= '9') {
                    return null;
                }
                
                long v = 0;
                while (i < len && arr[i] >= '0' && arr[i] <= '9') {
                    v = v * 10 + arr[i] - '0';
                    ++i;
                }
                postfix.addLast(v);
            } else if (operator.isEmpty()) {
                operator.push(arr[i++]);
            } else if (arr[i] == '+' || arr[i] == '-') {
                while (!operator.isEmpty()) {
                  postfix.addLast(operator.pop());
                }
                operator.push(arr[i++]);
            } else if (arr[i] == '*') {
                while (!operator.isEmpty() && operator.peek() == '*') {
                    postfix.addLast((operator.pop()));
                }
                operator.push(arr[i++]);
            }
        }

        while (!operator.isEmpty()) {
            postfix.addLast(operator.pop());
        }

        LinkedList<Long> value = new LinkedList<>();
        for (Object token : postfix) {
            if (token instanceof Long) {
                value.push((Long)token);
            } else {
                char op = (Character) token;
                long v1 = value.pop();
                long v2 = value.pop();
                if (op == '+') {
                    value.push(v1 + v2);
                } else if (op == '-') {
                    value.push(v2 - v1);
                } else if (op == '*') {
                    value.push(v1 * v2);
                }
            }
        }
        return value.pop();
    }
}

// faster solution
class Solution {
    
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        if (num.length() == 1) {
            if (Integer.parseInt(num) == target) {
                result.add(num);
            }
            return result;
        }
        
        dfs(result, "", 0, target, num, 0, 0);
        return result;
    }
    
    private void dfs(List<String> result, String expr, long v, int target, String num, int pos, long multed) {
        if (pos == num.length()) {
            if (v == target) {
                result.add(expr);
            }
            return;
        }
        
        long value = 0;
        for (int i = pos; i < num.length(); ++i) {
            if (i > pos && num.charAt(pos) == '0') break;
            String str = num.substring(pos, i + 1);
            value = value * 10 + num.charAt(i) - '0';
            if (pos == 0) {
                dfs(result, str, value, target, num, i + 1, value);
            } else {
                dfs(result, expr + "+" + str, v + value, target, num, i + 1, value);
                dfs(result, expr + "-" + str, v - value, target, num, i + 1, -value);
                dfs(result, expr + "*" + str, v - multed + multed * value, target, num, i + 1, multed * value);
            }
        }
    }

}