class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<string> symbolStk;
        stack<int> numberStk;
        
        for (int i = 0; i < tokens.size(); ++i) {
            if (isOperator(tokens[i])) {
                int num1 = numberStk.top();
                numberStk.pop();
                int num2 = numberStk.top();
                numberStk.pop();
                
                if (tokens[i] == "+") {
                    numberStk.push(num1 + num2);
                }
                else if (tokens[i] == "-") {
                    numberStk.push(num2 - num1);
                }
                else if (tokens[i] == "*") {
                    numberStk.push(num1 * num2);
                }
                else if (tokens[i] == "/") {
                    numberStk.push(num2 / num1);
                }
            }
            else {
                numberStk.push(stoi(tokens[i]));
            }
        }
        
        return numberStk.top();
    }
    
private:
    inline bool isOperator(string str) {
        return str == "+" || str == "-" || str == "*" || str == "/";
    }
};