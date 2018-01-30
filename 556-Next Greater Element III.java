class Solution {
    public int nextGreaterElement(int n) {
        List<Integer> bits = new ArrayList<>();
        int[] count = new int[10];
        int num = n;
        while (num > 0) {
            int bit = num % 10;
            count[bit] += 1;
            bits.add(bit);
            num /= 10;
        }
        
        int size = bits.size();
        int index = 0;
        while (index + 1 < size && bits.get(index) <= bits.get(index + 1)) ++index;
        if (index + 1 == size) return -1;
        
        int[] arr = new int[size];
        for (int i = size - 1; i > index + 1; --i) {
            arr[i] = bits.get(i);
            --count[bits.get(i)];
        }
        
        int bit = bits.get(index + 1), current = index + 1;
        while (index - 1 >= 0 && bits.get(index - 1) > bit) --index;
        arr[current] = bits.get(index);
        --count[bits.get(index)];
        
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < count[i]; ++j) {
                arr[--current] = i;
            }
        }
        
        int result = 0;
        for (int i = size - 1; i >= 0; --i) {
            if (result * 10L + arr[i] > Integer.MAX_VALUE) return -1;
            result = result * 10 + arr[i];
        }
        
        return result;
    }
}
