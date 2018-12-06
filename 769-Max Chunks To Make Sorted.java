class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 1;
        }
        
        LinkedList<Chunk> chunks = new LinkedList<>();
        chunks.push(new Chunk(arr[0], arr[0]));
        for (int i = 1; i < n; ++i) {
            Chunk c = chunks.peek();
            if (arr[i] >= c.max) {
                chunks.push(new Chunk(arr[i], arr[i]));
            } else {
                int max = c.max;
                while (!chunks.isEmpty() && arr[i] < chunks.peek().min) {
                    chunks.pop();
                }
                if (chunks.isEmpty()) {
                    chunks.push(new Chunk(arr[i], max));
                } else if (arr[i] >= chunks.peek().max){
                    chunks.push(new Chunk(arr[i], max));
                } else {
                    Chunk current = chunks.peek();
                    current.max = max;
                }
            }
        }
        return chunks.size();
    }
    
    private static class Chunk {
        int min, max;
        Chunk(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int i = 0, n = arr.length;
        int chunks = 0;
        while (i < n) {
            int max = arr[i];
            while (i < n && i != max) {
                i = i + 1;
                if (i < n) {
                    max = Math.max(max, arr[i]);
                }
            }
            chunks += 1;
            i = i + 1;
        }
        return chunks;
    }
}