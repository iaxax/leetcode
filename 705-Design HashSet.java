class MyHashSet {
    
    LinkedList<Integer>[] buckets = new LinkedList[10000];

    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        int h = hash(key);
        if (buckets[h] == null) {
            buckets[h] = new LinkedList<>();
        }
        int i = buckets[h].indexOf(key);
        if (i == -1) {
            buckets[h].add(key);
        }
    }
    
    public void remove(int key) {
        int h = hash(key);
        if (buckets[h] != null) {
            Iterator<Integer> iter = buckets[h].iterator();
            while (iter.hasNext()) {
                int v = iter.next();
                if (v == key) {
                    iter.remove();
                    return;
                }
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = hash(key);
        if (buckets[h] == null) {
            return false;
        }
        int i = buckets[h].indexOf(key);
        return i != -1;
    }
    
    private int hash(int key) {
        return key % 997;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */