package DSA.Graph;

import java.util.*;
public class WordLadderTwo {
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            return ladderLength(beginWord, endWord, wordList);
        }
        public List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> ans = new ArrayList<>();
            Set<String> wordSet = new HashSet<>();
            List<String> usedWords = new ArrayList<>();
            int level = 0;
            for(String str: wordList){
                wordSet.add(str);
            }
            wordList.remove(beginWord);
            if(beginWord == endWord) return new ArrayList<>();
            Queue<ArrayList<String>> q = new LinkedList<>();

            ArrayList<String> l1 = new ArrayList<>();
            l1.add(beginWord);
            q.add(l1);

            while(!q.isEmpty() && wordSet.size()>0){
                ArrayList<String> p = q.peek();
                q.remove();
                String word = p.get(p.size()-1);
                if(word.equals(endWord)){
                    if(ans.size()==0) ans.add(p);
                   else if(ans.get(0).size()==p.size()) ans.add(p);
                }
                for(int i =0; i<word.length(); i++){
                    for(char j ='a'; j<='z'; j++){
                        char[] wordArr = word.toCharArray();
                        wordArr[i] = j;
                        String newWord = String.copyValueOf(wordArr);
                        if(wordSet.contains(newWord)){
                            p.add(newWord);
                            q.add(new ArrayList<>(p));
                            p.remove(p.size()-1);
                            usedWords.add(newWord);
                        }
                    }
                }
            }
            return ans;
        }
    }
}

//class Solution {
//    public ArrayList < ArrayList < String >> findSequences(String startWord, String targetWord,
//                                                           String[] wordList) {
//        ArrayList < String > usedOnLevel = new ArrayList < > ();
//        usedOnLevel.add(startWord);
//        int level = 0;
//        int cnt = 0;
//
//        while (!q.isEmpty()) {
//            cnt++;
//
//            // Now, erase all words that have been
//            // used in the previous levels to transform
//            if (vec.size() > level) {
//                level++;
//                for (String it: usedOnLevel) {
//                    st.remove(it);
//                }
//            }
//        }
//        return ans;
//    }
//}
