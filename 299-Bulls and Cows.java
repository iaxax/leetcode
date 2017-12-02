class Solution {
    public String getHint(String secret, String guess) {
        int[] secretCount = new int[10];
        int[] guessCount = new int[10];
        int n = secret.length();
        
        int bull = 0;
        for (int i = 0; i < n; ++i) {
            char c = secret.charAt(i), d = guess.charAt(i);
            if (c == d) {
                bull += 1;
            }
            else {
                secretCount[c - '0'] += 1;
                guessCount[d - '0'] += 1;
            }
        }
        
        int cow = 0;
        for (int i = 0; i < 10; ++i) {
            cow += Math.min(secretCount[i], guessCount[i]);
        }
        
        return new StringBuilder().append(bull).append("A").append(cow).append("B").toString();
    }
}
