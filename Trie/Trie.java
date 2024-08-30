package DSA.Trie;

public class Trie {
        class Node {
            Node[] links;
            boolean flag;
            int prefixCount;
            int endWithCount;

            public Node() {
                this.links = new Node[26];
                this.flag = false;
                this.prefixCount=0;
                this.endWithCount = 0;
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

            public void incPrefix() { prefixCount++; }
            public void decPrefix() { prefixCount--; }
            public void incEndWith() { endWithCount++; }
            public void decEndWith() { endWithCount--; }
        }
        Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String s){
            int n = s.length();
            Node node = root;
            for(int i =0; i<s.length(); i++){
                char ch = s.charAt(i);
                if(!node.contains(ch)){
                    node.put(ch, new Node());
                }
                node.incPrefix();
                node = node.get(ch);
            }
        node.setEnd();
            node.incEndWith();
        }

        public boolean search(String s){
            int n = s.length();
            Node node = root;
            for(int i =0; i<s.length(); i++){
                char ch = s.charAt(i);
                if(!node.contains(ch)) return false;
                node = node.get(ch);
            }
            return node.isEnd();
        }

        public boolean prefix(String s){
            int n = s.length();
            Node node = root;
            for(int i =0; i<s.length(); i++){
                char ch = s.charAt(i);
                if(!node.contains(ch)) return false;
                node = node.get(ch);
            }
            return true;
        }
}
