class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> wordDic(wordList.begin(), wordList.end());
        return findLadders(beginWord, endWord, wordDic);
    }
    
    vector<vector<string>> findLadders(string beginWord, string endWord, unordered_set<string> &wordDic) {
        if (wordDic.find(endWord) == wordDic.end()) return {};
        
        wordDic.insert(endWord);
        unordered_set<string> visited;
        visited.insert(beginWord);
        deque<vector<string>> paths;
        paths.push_back({beginWord});

        while (visited.find(endWord) == visited.end()) {
            unordered_set<string> newVisited;
            unordered_set<string> newDic = wordDic;
            int pathNum = paths.size();
            for (const string &str : visited) {
                for (int i = 0; i < str.size(); ++i) {
                    string word = str;
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        word[i] = ch;
                        if (wordDic.find(word) != wordDic.end()) {
                            newDic.erase(word);
                            newVisited.insert(word);
                            for (int j = 0; j < pathNum; ++j) {
                                if (paths[j].back() == str) {
                                    vector<string> p = paths[j];
                                    p.push_back(word);
                                    paths.push_back(p);
                                }
                            }
                        }
                    }
                }
            }
            paths.erase(paths.begin(), paths.begin() + pathNum);
            
            if (newVisited.size() == 0) return {};
            visited = newVisited;
            wordDic = newDic;
        }
        
        vector<vector<string>> result;
        for (const vector<string> &v : paths) {
            if (v.back() == endWord) result.push_back(v);
        }
        return result;
    }
};