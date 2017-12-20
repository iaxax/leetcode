class Solution {
    public String decodeString(String s) {
        Stack<Object> stack = new Stack<>();
        int i = 0, len = s.length();

        while (i < len) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int n = 0;
                while (Character.isDigit(c)) {
                    n = n * 10 + c - '0';
                    i += 1;
                    c = s.charAt(i);
                }
                stack.push(new Integer(n));
            } else if (c == '[') {
                i += 1;
            } else if (c == ']') {
                String ss = (String) stack.pop();
                while (stack.peek() instanceof String) {
                    ss = ((String)stack.pop()) + ss;
                }

                Integer n = (Integer)stack.pop();
                StringBuilder temp = new StringBuilder();
                for (int k = 0; k < n; ++k) {
                    temp.append(ss);
                }
                stack.push(temp.toString());
                i += 1;
            } else {
                StringBuilder temp = new StringBuilder();
                while (!Character.isDigit(c) && c !='[' && c != ']') {
                    temp.append(c);
                    i += 1;
                    if (i == len) break;
                    c = s.charAt(i);
                }
                stack.push(temp.toString());
            }
        }

        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }

}
