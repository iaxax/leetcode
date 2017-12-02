class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int owe = 0, remain = 0, start = 0;
        for (int i = 0; i < gas.size(); ++i) {
            if (gas[i] + remain >= cost[i]) {
                remain += gas[i] - cost[i];
            }
            else {
                start = i + 1;
                owe += cost[i] - (gas[i] + remain);
                remain = 0;
            }
        }
        return start == gas.size() || remain < owe ? -1 : start;
    }
};