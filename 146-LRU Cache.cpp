class LRUCache {
public:
    LRUCache(int capacity) {
        this->capacity = capacity;
    }
    
    int get(int key) {
        if (cache.find(key) != cache.end()) {
            touch(key);
            return cache[key];
        }
        else {
            return -1;
        }
    }
    
    void put(int key, int value) {
        if (cache.find(key) != cache.end()) {
            touch(key);
        }
        else if (cache.size() < capacity) {
            visitedMap[key] = visited.insert(visited.end(), key);
        }
        else {
            int replaceKey = visited.front();
            cache.erase(replaceKey);
            visited.pop_front();
            visitedMap.erase(replaceKey);
            visitedMap[key] = visited.insert(visited.end(), key);
        }
            
        cache[key] = value;
    }
    
private:
    int capacity;
    unordered_map<int, int> cache;
    
    list<int> visited;
    unordered_map<int, list<int>::iterator> visitedMap;
    
    void touch(int key) {
        visited.erase(visitedMap[key]);
        visitedMap[key] = visited.insert(visited.end(), key);
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */