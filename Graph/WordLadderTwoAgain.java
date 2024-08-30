package DSA.Graph;

import java.util.*;

public class WordLadderTwoAgain {
    class lexioComp implements Comparator<List<String>> {
        @Override
        public int compare(List<String> l1, List<String> l2) {
            String s1 = "", s2 ="";
            for(int i =0; i<l1.size(); i++) s1 += l1.get(i);
            for(int i =0; i<l2.size(); i++) s1 += l2.get(i);
            return s1.compareTo(s2);
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        List<List<String>> ans = new ArrayList<>();
        Set<String> wordListSet = new HashSet<>();
        for(String s: wordList){
            wordListSet.add(s);
        }
        List<String> ls = new ArrayList<>();
        Queue<List<String>> q = new LinkedList<>();
        ls.add(beginWord);
        q.add(ls);
        int level = 0;
        List<String> usedWords = new ArrayList<>();
        usedWords.add(beginWord);
        while(!q.isEmpty()){
            List<String> top = q.poll();
            String word = top.get(top.size()-1);
            if(word.equals(endWord)){
                if(ans.size()==0) ans.add(top);
                else if(ans.get(0).size() == top.size()) ans.add(top);
            } else {
                // remove all the already added strings.
                if(level<top.size()){ // why ??
                    level++;
                    for(String s: usedWords){
                        wordList.remove(s);
                    }
                }
                for(int i =0; i<word.length(); i++){
                    for(char c = 'a'; c<='z'; c++){
                        // forming different words
                        char[] charArray = word.toCharArray();
                        charArray[i] = c;
                        String replacedWord = new String(charArray);
                        if(wordListSet.contains(replacedWord)){
                            // recursion and backtracking
                            top.add(replacedWord);
                            List<String> temp = new ArrayList<>(top);
                            q.add(temp);
                            top.remove(top.size()-1);
                            usedWords.add(replacedWord);
                        }
                    }
                }
            }

        }

        Collections.sort(ans, new lexioComp());
        return ans;
    }
}
