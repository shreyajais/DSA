package DSA.Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans  = new ArrayList<>();
        partitionRecur(0, s, new ArrayList<>(), ans);
        return ans;
    }
    public void partitionRecur(int index, String s, List<String> listSoFar, List<List<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<>(listSoFar));
            return;
        }
        for(int i = index; i<s.length(); i++){
            if(isPalindrome(index, i, s)){
                listSoFar.add(s.substring(index, i+1));
                partitionRecur(i+1, s, listSoFar, ans);
                listSoFar.remove(listSoFar.size()-1);
            }
        }
    }

    private boolean isPalindrome(int start, int end, String s){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
}
