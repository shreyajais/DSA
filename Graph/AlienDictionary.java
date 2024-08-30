package DSA.Graph;

import java.util.*;

public class AlienDictionary {
    class Solution {
        public String alienOrder(String[] words) {
            ArrayList<ArrayList<Character>> arr = new ArrayList<>();
            Set<Character> setOfCharacter = new HashSet<>();
            for(int i =0; i<words.length-1; i++){
                String word1 = words[i];
                String word2 = words[i+1];
                getPreference(word1, word2, arr, setOfCharacter);
            }
            Map<Character, ArrayList<Character>> adj = getAdjList(arr);
            List<Character> topoList = getTopoSort(adj, setOfCharacter.stream().toList());
            if(topoList.size()== 0) return "";
            return listToString(topoList);
        }
        public void getPreference(String word1, String word2, ArrayList<ArrayList<Character>> arr, Set<Character> setOfCharacter){
            int sizeMin = Math.min(word1.length(), word2.length());
            for(int i =0; i< sizeMin; i++){
                setOfCharacter.add(word1.charAt(i));
                if(word1.charAt(i) == word2.charAt(i)) continue;
                else {
                    ArrayList<Character> chList = new ArrayList<>();
                    chList.add(word1.charAt(i));
                    chList.add(word2.charAt(i));
                    arr.add(chList);
                }
            }
        }

        public  Map<Character, ArrayList<Character>> getAdjList(ArrayList<ArrayList<Character>> arr){
            Map<Character, ArrayList<Character>> adjMap = new HashMap<>();
            for(ArrayList<Character> chArr: arr){
                ArrayList<Character> list;
                if(!adjMap.containsKey(chArr.get(0))){
                    list = new ArrayList<>();
                }else {
                    list = adjMap.get(chArr.get(0));
                }
                list.add(chArr.get(1));
                adjMap.put(chArr.get(0), list);
            }
            return adjMap;
        }
        public List<Character> getTopoSort(Map<Character, ArrayList<Character>> adj, List<Character> setOfCharacter){
            List<Character> ans = new ArrayList<>();
            Queue<Character> q = new LinkedList<>();
            Map<Character, Integer> inDegree = new HashMap<>();

            for(int i =0; i<setOfCharacter.size(); i++){
                Character ch = setOfCharacter.get(i);
                if(!adj.containsKey(setOfCharacter.get(i))) q.add(ch);
                else inDegree.put(ch, adj.get(ch).size());
            }
            while(!q.isEmpty()){
                Character ch = q.peek();
                ans.add(ch);
                q.remove();
                for(Character it: adj.get(ch)){
                    inDegree.put(it, inDegree.get(it)-1);
                    if(inDegree.get(it)==0) q.add(it);
                }
            }
            if(setOfCharacter.size() == ans.size()) return ans;
            else return new ArrayList<>();
        }
        public String listToString(List<Character> list){
            String str = "";
            for(Character ch: list){
                str+= ch.toString();
            }
            return str;
        }

    }
}