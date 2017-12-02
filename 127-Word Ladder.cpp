class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> wordDic(wordList.begin(), wordList.end());
        return ladderLength(beginWord, endWord, wordDic);
    }
    
private:
    int ladderLength(const string &beginWord, const string &endWord, unordered_set<string> &wordDic) {
        if (wordDic.find(endWord) == wordDic.end()) return 0;
        
        set<string> visited;
        visited.insert(beginWord);
        int len = 1, wordLen = beginWord.size();
        
        while (visited.find(endWord) == visited.end()) {
            set<string> newVisited;
            for (const string &str : visited) {
                for (int i = 0; i < wordLen; ++i) {
                    string word = str;
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        word[i] = ch;
                        if (wordDic.find(word) != wordDic.end()) {
                            newVisited.insert(word);
                            wordDic.erase(word);
                        }
                    }
                }
            }
            
            if (newVisited.empty()) return 0;
            len += 1;
            visited = newVisited;
        }
        return len;
    }
};