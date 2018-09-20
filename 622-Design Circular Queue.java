class MyCircularQueue {
    
    private int[] data;
    
    private int head, size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new int[k];
        head = 0;
        size = 0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }
        int tail = (head + size + 1) % data.length;
        data[tail] = value;
        size += 1;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }
        head = (head + 1) % data.length;
        size -= 1;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return this.isEmpty() ? -1 : data[(head + 1) % data.length];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return this.isEmpty() ? -1 : data[(head + size) % data.length];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == data.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */