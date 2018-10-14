class MyCalendar {
    
    private TreeMap<Integer, Integer> bookings = new TreeMap<>();

    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        if (isInInterval(start) || isInInterval(end - 1)) {
            return false;
        }
        
        Map.Entry<Integer, Integer> entry = bookings.ceilingEntry(start);
        if (entry != null && entry.getKey() >= start && entry.getKey() < end) {
            return false;
        }
        
        if (start < end) {
            bookings.put(start, 1);
            bookings.put(end - 1, -1);
        }
        return true;
    }
    
    private boolean isInInterval(int x) {
        Map.Entry<Integer, Integer> f = bookings.floorEntry(x);
        Map.Entry<Integer, Integer> c = bookings.ceilingEntry(x);
        if (f != null && c != null) {
            int lower = f.getKey(), upper = c.getKey();
            if (lower == upper) {
                return true;
            }
            return f.getValue() > 0 && c.getValue() < 0 && x >= lower && x <= upper;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */