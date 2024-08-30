package DSA.Strings.Easy;

import java.util.ArrayList;

public class Rotate {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        char ch = s.charAt(0);
        ArrayList<Integer> arr = listOfIndexes(ch, goal);
        if(arr.size()==0) return false;
        for(int i =0; i< arr.size(); i++){
            if(checkRotation(s, goal, arr.get(i))) return true;
        }
        return false;
    }

    private boolean checkRotation(String s1, String s2, Integer index) {
        String newStr = s2.substring(index) + s2.substring(0, index);
        return s1.equals(newStr);
    }

    private ArrayList<Integer> listOfIndexes(char ch, String goal) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i =0;i<goal.length(); i++){
            if(goal.charAt(i) == ch) arr.add(i);
        }
        return arr;
    }

    private String getDistinctString(String s) {
        int j = s.length()-1;
        char ch = s.charAt(0);
        while(s.charAt(j) == ch && j>0) j--;
        if(j == 0 || j == s.length()-1) return s;
        else {
            String newStart = s.substring(j+1) + s.substring(0, j);
            return newStart;
        }
    }
}
