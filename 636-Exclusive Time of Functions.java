class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] times = new int[n];
        Stack<int[]> tasks = new Stack<>();
        for (String log : logs) {
            int[] newTask = extract(log);
            if(newTask[1] == 1) {
                if (!tasks.isEmpty()) {
                    int[] task = tasks.peek();
                    tasks.push(newTask);
                    times[task[0]] += newTask[2] - task[2];
                } else {
                    tasks.push(newTask);
                }
            } else {
                int[] task = tasks.pop();
                times[task[0]] += newTask[2] - task[2] + 1;
                if (!tasks.isEmpty()) tasks.peek()[2] = newTask[2] + 1;
            }
        }
        return times;
    }
    
    private int[] extract(String log) {
        String[] temp = log.split(":");
        return new int[] {
            Integer.parseInt(temp[0]),
            temp[1].equals("start") ? 1 : 0,
            Integer.parseInt(temp[2])
        };
    }
}
