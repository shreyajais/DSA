package DSA.Strings.Easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int i =0;
        String common = strs[0];
        String st1 = "", st2 = "";
        while(i<strs.length-1){
            st1 = strs[i]; st2 = strs[i+1];
            int j=0;
            while(j<st1.length() && j<st2.length() && j<common.length()){
                if(st1.charAt(j) == st2.charAt(j)){
                    j++;
                } else break;
            }
            common=  st1.substring(0, j);
            i++;
        }
        return common;
    }
}
