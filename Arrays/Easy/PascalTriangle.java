package DSA.Arrays.Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ansBig = new ArrayList<>();
        List<Integer> zeroTh = new ArrayList<>();
        zeroTh.add(1);
        ansBig.add(zeroTh);
        if(numRows==1) return ansBig;
        for(int i =1; i<numRows; i++){
            List<Integer> ans = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0) ans.add(1);
                else if(j==i) ans.add(1);
                else ans.add(ansBig.get(i-1).get(j-1) + ansBig.get(i-1).get(j));
            }
            ansBig.add(ans);
        }
        return ansBig;
    }
}
