class MinStack {
public:
    /** initialize your data structure here. */
    MinStack() {
        
    }
    
    void push(int x) {
        stk.push(x);
        if (minStk.empty() || minStk.top() >= x) {
            minStk.push(x);
        }
    }
    
    void pop() {
        if (stk.top() == minStk.top()) {
            minStk.pop();
        }
        stk.pop();
    }
    
    int top() {
        return stk.top();
    }
    
    int getMin() {
        return minStk.top();
    }
    
private:
    int minElement;
    stack<int> stk;
    stack<int> minStk;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 
 // solution using only one stack
 class MinStack {
public:
    /** initialize your data structure here. */
    MinStack() {
        
    }
    
    void push(int x) {
        if (diffStk.empty()) {
            diffStk.push(0L);
            minNum = x;
        }
        else {
            diffStk.push(x - minNum);
            if (x < minNum) {
                minNum = x;
            }
        }
    }
    
    void pop() {
        long long t = diffStk.top();
        diffStk.pop();
        
        if (t < 0) {
            minNum = minNum - t;
        }
    }
    
    int top() {
        long long t = diffStk.top();
        return int(t > 0 ? minNum + t : minNum);
    }
    
    int getMin() {
        return (int)minNum;
    }
    
private:
    long long minNum;
    stack<long> diffStk;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */