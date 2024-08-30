package DSA.Recursion.Hard;

import java.util.List;
// 35/47 ----> TLE ------> DP
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return createWord(0,  s, wordDict, "");
    }

    private boolean createWord(int index, String s, List<String> wordDict, String strSoFar) {
        if(index== s.length()){
            if(strSoFar.length()==0 || wordDict.contains(strSoFar)) return true;
            else return false;
        }
            strSoFar = strSoFar + s.charAt(index);
            if(wordDict.contains(strSoFar)){
                // start with new letter
                if(createWord(index+1, s, wordDict, "")==  true) return true;
            }
            return createWord(index+1, s, wordDict, strSoFar);
    }
}
