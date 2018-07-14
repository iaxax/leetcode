// O(nlogn) solution
class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> times = new ArrayList<>(timePoints.size());
        for (String str : timePoints) {
            String[] temp = str.split(":");
            int h = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            times.add(60 * h + m);
        }
        Collections.sort(times);
        int minDiff = Integer.MAX_VALUE;
        
        int size = times.size(), day = 24 * 60;
        for (int i = 1; i < size; ++i) {
            int t1 = times.get(i), t2 = times.get(i - 1);
            int diff = Math.min(t1 - t2, t2 + day - t1);
            minDiff = Math.min(minDiff, diff);
        }
        
        return Math.min(minDiff, times.get(0) + day - times.get(size - 1));
    }
}

// O(n) solution
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int day = 24 * 60;
        boolean[] minutes = new boolean[day];
        for (String str : timePoints) {
            String[] temp = str.split(":");
            int h = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            int index = h * 60 + m;
            if (minutes[index]) return 0;
            minutes[index] = true;
        }
        
        int prev = 0;
        while (!minutes[prev]) ++prev;
        
        int start = prev, current = prev;
        int minDiff = Integer.MAX_VALUE;
        for (int i = current + 1; i < day; ++i) {
            if (minutes[i]) {
                prev = current;
                current = i;
                int diff = Math.min(current - prev, prev + day - current);
                minDiff = Math.min(minDiff, diff);
            }
        }
        
        return Math.min(minDiff, start + day - current);
    }
}
