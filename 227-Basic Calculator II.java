// Traditional Solution
class Solution {
    public int calculate(String s) {
        List<String> postfix = toPostfix(s);
        Stack<Long> stack = new Stack<>();
        int n = postfix.size();
        for (int i = 0; i < n; ++i) {
            String str = postfix.get(i);
            char c = str.charAt(0);
            if (c >= '0' && c <= '9') {
                stack.push(Long.valueOf(str));
            }
            else {
                long a = stack.pop();
                long b = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(a + b); break;
                    case '-':
                        stack.push(b - a); break;
                    case '*':
                        stack.push(a * b); break;
                    case '/':
                        stack.push(b / a); break;
                    default: break;
                }
            }
        }
        return (int)stack.pop().longValue();
    }
    
    private List<String> toPostfix(String s) {
        int[] priority = new int[256];
        priority['+'] = priority['-'] = 1;
        priority['*'] = priority['/'] = 2;
        
        char[] arr = s.toCharArray();
        List<String> result = new ArrayList<>(100);
        Stack<Character> operator = new Stack<>();
        int n = arr.length, i = 0;
        while (i < n) {
            while (i < n && arr[i] == ' ') ++i;
            if (i == n) break;
            if (arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/') {
                while (!operator.isEmpty() && priority[operator.peek()] >= priority[arr[i]]) {
                    result.add(String.valueOf(operator.pop()));
                }
                operator.push(arr[i++]);
            }
            else {
                StringBuilder sb = new StringBuilder();
                while (i < n && arr[i] >= '0' && arr[i] <= '9') {
                    sb.append(arr[i++]);
                }
                result.add(sb.toString());
            }
        }
        
        while (!operator.isEmpty()) result.add(String.valueOf(operator.pop()));
        return result;
    }
}

// Faster, cleaner, one-pass Solution
class Solution {
    public int calculate(String s) {
        int[] priority = new int[128];
        priority['+'] = priority['-'] = 1;
        priority['*'] = priority['/'] = 2;
        
        Stack<Character> operator = new Stack<>();
        Stack<Long> operand = new Stack<>();
        char[] arr = new String(s + "+").toCharArray();
        int i = 0, n = arr.length;
        while (i < n) {
            while (i < n && arr[i] == ' ') ++i;
            if (i == n) break;
            
            if (arr[i] >= '0' && arr[i] <= '9') {
                long num = arr[i++] - '0';
                while (i < n && arr[i] >= '0' && arr[i] <= '9') {
                    num = num * 10 + arr[i++] - '0';
                }
                operand.push(num);
            }
            else {
                while (!operator.isEmpty() && priority[operator.peek()] >= priority[arr[i]]) {
                    long a = operand.pop();
                    long b = operand.pop();
                    char op = operator.pop();
                    switch (op) {
                        case '+':
                            operand.push(a + b); break;
                        case '-':
                            operand.push(b - a); break;
                        case '*':
                            operand.push(a * b); break;
                        case '/':
                            operand.push(b / a); break;
                        default: break;
                    }
                }
                operator.push(arr[i++]);
            }
        }
        
        return (int)operand.pop().longValue();
    }
}
