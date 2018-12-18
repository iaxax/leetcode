class MyCalendarThree {
    
    private TreeMap<Integer, Integer> bookings;

    public MyCalendarThree() {
        bookings = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        bookings.put(start, bookings.getOrDefault(start, 0) + 1);
        bookings.put(end, bookings.getOrDefault(end, 0) - 1);
        int k = 0, count = 0;;
        for (int v : bookings.values()) {
            count += v;
            k = Math.max(k, count);
        }
        return k;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */