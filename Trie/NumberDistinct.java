package DSA.Trie;

public class NumberDistinct {
    static class Node {
        Node[] links;
        boolean flag;

        public Node() {
            this.links = new Node[26];
            this.flag = false;
        }

        public boolean contains(char c){
            return links[c-'a'] != null;
        }

        public void put(char c, Node newNode){
            links[c-'a'] = newNode;
        }
        public Node get(char c){
            return links[c-'a'];
        }
        public void setEnd(){ flag = true; }

        public boolean isEnd() { return flag; }
    }
    public static int countDistinctSubstrings(String s)
    {
        int count = 0;
        Node root = new Node();
        for(int i =0; i<s.length(); i++){
            String strSoFar = "";
            for(int j =i; j<s.length(); j++){
                strSoFar += s.charAt(j);
                if(isInserted(strSoFar, root)) count++;
            }
        }
        return count;
    }

    private static boolean isInserted(String strSoFar, Node root) {
        boolean isInserted = false;
        Node n = root;
        for(int i =0; i<strSoFar.length(); i++){
            char ch = strSoFar.charAt(i);
            if(!n.contains(ch)){
                isInserted = true;
                n.put(ch, new Node());
            }
            n = n.get(ch);
        }
        n.setEnd();
        return isInserted;
    }
}
