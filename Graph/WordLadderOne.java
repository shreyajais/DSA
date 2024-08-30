package DSA.Graph;

import java.util.*;

class WordLadderOne {
    class Pair{
        String word;
        int steps;
        Pair(String word, int steps){
            this.word = word;
            this.steps = steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for(String str: wordList){
            wordSet.add(str);
        }
        wordList.remove(beginWord);
        if(beginWord == endWord) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        while(!q.isEmpty() && wordSet.size()>0){
            Pair p = q.peek();
            q.remove();
            String word = p.word;
            if(word.equals(endWord)) return p.steps;
            for(int i =0; i<word.length(); i++){
                for(char j ='a'; j<='z'; j++){
                    char[] wordArr = word.toCharArray();
                    wordArr[i] = j;
                    String newWord = String.copyValueOf(wordArr);
                    if(wordSet.contains(newWord)){
                        q.add(new Pair(newWord, p.steps+1));
                        wordSet.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}