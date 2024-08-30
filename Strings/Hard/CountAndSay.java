package DSA.Strings.Hard;

import java.util.ArrayList;

public class CountAndSay {
    public String countAndSay(int n){
        if(n==1) return "1";
        ArrayList<String> arr = new ArrayList<>();
        arr.add("1");
        while(arr.size()<n){
            String countAndSayString = countAndSaySolver(arr.get(arr.size()-1));
            arr.add(countAndSayString);
        }
        return arr.get(n-1);
    }

    public String countAndSaySolver(String str) {
        String strSoFar = "";
        char lastCh = str.charAt(0);
        int count = 1;
        for(int i = 1; i<str.length(); i++){
            if(str.charAt(i)==lastCh){
                count++;
            } else {
                strSoFar = strSoFar + String.valueOf(count) + lastCh;
                count = 1;
                lastCh = str.charAt(i);
            }
        }
        strSoFar = strSoFar + String.valueOf(count) + lastCh;
        return strSoFar;
    }
}
