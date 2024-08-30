package DSA.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximizeXor {
    class Trie {
        class Node{
            Node[] links;

            public Node() {
                this.links = new Node[2];
            }

            public boolean contains(int bit){
                return links[bit] !=null;
            }
            public void put(int bit, Node n){
                links[bit] = n;
            }
            public Node get(int bit){
                return links[bit];
            }
        }

        Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(int num){
            Node n = root;
            for(int i =31; i>=0; i--){
                int bit = (num>>i)&1;
                if(!n.contains(bit)) n.put(bit, new Node());
                n = n.get(bit);
            }
        }

        public int getMaxXor(int num){
            Node n = root;
            int maxXor = 0;
            for(int i = 31; i>=0; i++){
                int bit = (num>>i)&1;
                if(n.contains(1-bit)){
                    maxXor = maxXor | (1<<bit);
                }
                n =n.get(bit);
            }
            return maxXor;
        }
    }
    class Queries implements Comparable<Queries>{
        int index; int value; int maxIValue;

        public Queries(int index, int value, int maxIValue) {
            this.index = index;
            this.value = value;
            this.maxIValue = maxIValue;
        }

        @Override
        public int compareTo(Queries o) {
            return this.maxIValue - o.maxIValue;
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie trie = new Trie();
        Arrays.sort(nums);
        // for queries sorting
        int queriesLen = queries.length;;
        ArrayList<Queries> q = new ArrayList<>();
        int[] ans = new int[queriesLen];
        for(int i =0; i< queriesLen; i++){
            q.add(new Queries(i, queries[i][0], queries[i][1]));
        }
        Collections.sort(q);
        // now comparison
        int i =0, j = 0;
        while(j<queriesLen){
            while(i< nums.length && nums[i]<=q.get(j).maxIValue) i++;
            for(int b =0; b<i; b++){
                trie.insert(nums[i]);
                int maxXor = trie.getMaxXor(q.get(j).value);
                ans[q.get(j).index] = maxXor;
            }
            j++;
        }
        return ans;
    }

}
