package DSA.Graph.DisjointSet;

import java.util.HashMap;
import java.util.List;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> mp = new HashMap<>();
        for(int i =0; i<accounts.size(); i++){
            String u = accounts.get(i).get(0);
            for(int j = 1; j<accounts.get(i).size(); j++){
                if(!mp.containsKey(accounts.get(i).get(j)))
            }
        }
    }
}
