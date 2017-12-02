// O(nk) Solution
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int size = primes.length;
        int[] index = new int[size];
        int[] nums = new int[n];
        int[] value = new int[size];
        Arrays.fill(value, 1);
        
        int next = 1;
        for (int i = 0; i < n; ++i) {
            nums[i] = next;
            
            next = Integer.MAX_VALUE;
            for (int j = 0; j < size; ++j) {
                if (nums[i] == value[j]) value[j] = primes[j] * nums[index[j]++];
                next = Math.min(next, value[j]);
            }
        }
        return nums[n - 1];
    }
}

// O(nlogk) Solution
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int size = primes.length;
        PriorityQueue<Num> pq = new PriorityQueue<>(size);
        for (int i = 0; i < size; ++i) {
            pq.add(new Num(primes[i], 0, primes[i]));
        }
        
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; ++i) {
            ugly[i] = pq.peek().val;
            while (ugly[i] == pq.peek().val) {
                Num num = pq.poll();
                pq.add(new Num(num.p * ugly[num.index + 1], num.index + 1, num.p));
            }
        }
        return ugly[n - 1];
    }
    
    private static class Num implements Comparable<Num> {
        private int val, index, p;
        Num(int v, int i, int p) {
            val = v; index = i; this.p = p;
        }
        public int compareTo(Num n) {
            return val - n.val;
        }
    }
}
