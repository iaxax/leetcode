class Twitter {
    
    private Map<Integer, Set<Integer>> followers = new HashMap<>();
    
    private Map<Integer, List<Integer>> tweets = new HashMap<>();
    
    private Map<Integer, Integer> tweeters = new HashMap<>();
    
    private Map<Integer, Integer> time = new HashMap<>();
    
    private int index = 0;

    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new LinkedList<>()).add(0, Integer.valueOf(tweetId));
        Set<Integer> list = followers.computeIfAbsent(userId, k -> new HashSet<>());
        for (Integer f : list) {
            tweets.computeIfAbsent(f, k -> new LinkedList<>()).add(0, Integer.valueOf(tweetId));
        }
        tweeters.put(tweetId, userId);
        time.put(tweetId, index++);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>(10);
        List<Integer> t = tweets.getOrDefault(userId, new LinkedList<>());
        result.addAll(t.size() > 10 ? t.subList(0, 10) : t);
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        
        Set<Integer> set = followers.computeIfAbsent(followeeId, k -> new HashSet<>());
        if (!set.contains(followerId)) {
            set.add(followerId);
            tweets.computeIfAbsent(followerId, k -> new LinkedList<>()).addAll(
                0, tweets.computeIfAbsent(followeeId, k -> new LinkedList<>()).stream().
                filter(tid -> tweeters.get(tid).intValue() == followeeId).collect(Collectors.toList())
            );
            Collections.sort(tweets.get(followerId), (t1, t2) -> time.get(t2) - time.get(t1));
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        
        followers.computeIfAbsent(followeeId, k -> new HashSet<>()).remove(followerId);
        tweets.put(followerId, tweets.computeIfAbsent(followerId, k -> new LinkedList<>()).stream().
                  filter(tid -> tweeters.get(tid).intValue() != followeeId).collect(Collectors.toList()));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
