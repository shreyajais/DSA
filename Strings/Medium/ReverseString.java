package DSA.Strings.Medium;

public class ReverseString {
    public String reverseWords(String s) {
        String ans = "";
        int i =0;
        while(s.charAt(i)==' '){
            i++;
        }
        s = s.substring(i);
        i = s.length()-1;
        while(s.charAt(i)== ' '){
            i--;
        }
        s = s.substring(0, i+1);
        String[]  strArr= s.split(" ");
        for(int k = strArr.length-1; k>=0; k--){
            if(strArr[k].equals("")) continue;
            ans = ans + strArr[k] + " ";
        }
        return ans.substring(0, ans.length()-1);
    }
}
