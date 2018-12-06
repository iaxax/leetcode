class Solution {
    public String predictPartyVictory(String senate) {
        int r = 0, d = 0;
        List<Character> remain = new ArrayList<>();
        for (char s : senate.toCharArray()) {
            remain.add(s);
            if (s == 'R') {
                r = r + 1;
            } else {
                d = d + 1;
            }
        }
        
        int banR = 0, banD = 0;
        while (r > 0 && d > 0) {
            r = d = 0;
            List<Character> newRemain = new ArrayList<>();
            for (char s : remain) {
                if (s == 'R') {
                    if (banR > 0) {
                        banR -= 1;
                    } else {
                        banD += 1;
                        r = r + 1;
                        newRemain.add('R');
                    }
                }
                if (s == 'D') {
                    if (banD > 0) {
                        banD -= 1;
                    } else {
                        banR += 1;
                        d = d + 1;
                        newRemain.add('D');
                    }
                }
            }
            remain = newRemain;
        }
        return r > 0 ? "Radiant" : "Dire";
    }
}

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> parties = new LinkedList<>();
        int[] banned = new int[2];
        int[] count = new int[2];
        for (char c : senate.toCharArray()) {
            int p = c == 'R' ? 1 : 0;
            count[p] += 1;
            parties.offer(p);
        }
        
        while (count[0] > 0 && count[1] > 0) {
            int p = parties.poll();
            if (banned[p] > 0) {
                banned[p] -= 1;
                count[p] -= 1;
            } else {
                banned[1 - p] += 1;
                parties.offer(p);
            }
        }
        return count[0] > 0 ? "Dire" : "Radiant";
    }
}