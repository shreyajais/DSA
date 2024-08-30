package DSA.Trie;

public class LongestStringAllPrefixes {
    public static String completeString(int n, String[] a) {
       Trie t = new Trie();
       for(int i =0; i<a.length; i++){
           t.insert(a[i]);
       }
       int maxLen = 0, maxIndex = 0;
       for(int i =0; i<a.length; i++){
           int len = 0;
           for(int j =0; j<a[i].length(); j++){
               String prefix = a[i].substring(0,j+1);
               if(t.search(prefix)) len++;
               else break;
           }
          if(len>maxLen){
              maxIndex = len;
              maxIndex = i;
          }
       }
       return a[maxIndex];
    }
}
