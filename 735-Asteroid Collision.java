class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> remain = new ArrayList<>();
        LinkedList<Integer> right = new LinkedList<>();
        for (int a : asteroids) {
            if (a < 0) {
                while (!right.isEmpty() && right.getLast() < -a) {
                    right.removeLast();
                }
                if (!right.isEmpty() && right.getLast() == -a) {
                    right.removeLast();
                } else if (right.isEmpty()) {
                    remain.add(a);
                }
            } else {
                right.addLast(a);
            }
        }
        remain.addAll(right);
        
        int[] result = new int[remain.size()];
        for (int i = 0;i < remain.size(); ++i) {
            result[i] = remain.get(i);
        }
        return result;
    }
}