class MyHashMap {
    
    private LinkedList<Entry>[] buckets = new LinkedList[1000];

    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = hash(key);
        if (buckets[h] == null) {
            buckets[h] = new LinkedList<>();
        }
        
        Iterator<Entry> iter = buckets[h].iterator();
        while (iter.hasNext()) {
            Entry e = iter.next();
            if (e.key == key) {
                e.value = value;
                return;
            }
        }
        buckets[h].add(new Entry(key, value));
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = hash(key);
        if (buckets[h] != null) {
            Iterator<Entry> iter = buckets[h].iterator();
            while (iter.hasNext()) {
                Entry e = iter.next();
                if (e.key == key) {
                    return e.value;
                }
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = hash(key);
        if (buckets[h] != null) {
            Iterator<Entry> iter = buckets[h].iterator();
            while (iter.hasNext()) {
                Entry e = iter.next();
                if (e.key == key) {
                    iter.remove();
                    return;
                }
            }
        }
    }
    
    private int hash(int key) {
        return key % 997;
    }
    
    private static class Entry {
        int key, value;
        Entry(int k, int v) {
            key = k;
            value = v;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */