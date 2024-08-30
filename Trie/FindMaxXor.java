package DSA.Trie;

public class FindMaxXor {
    class Node {
        Node[] links;

        public Node() {
            this.links = new Node[2];
        }
        public boolean contains(int bit){
            return links[bit] != null;
        }
        Node get(int bit) {
            return links[bit];
        }

        void put(int bit, Node node) {
            links[bit] = node;
        }
    }
    Node root;

    public FindMaxXor(Node root) {
        this.root = root;
    }

    public int findMaximumXOR(int[] nums) {
        int maxXor = 0;
        Node n = root;
        for(int i =0; i< nums.length; i++){
            int maxXorSoFar = 0;
            for(int b = 31; b>=0; i--){
                int bit = (nums[i]>>b)&1;
                if(!n.contains(bit)){
                    n.put(bit, new Node());}
                    if(n.contains(1-bit)){
                        maxXorSoFar |= (1<<b);
                    }
                n = n.get(bit);
                }
            maxXor = Math.max(maxXor, maxXorSoFar);
            }
        return maxXor;
        }
}
