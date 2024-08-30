package DSA.Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class AddOperators {
    public List<String> addOperators(String num, int target){
        List<String> ans = new ArrayList<>();
        if(num==null || num.length()==0) return ans;
        addOperatorsRecur(ans, "", num, 0, 0, 0, target);
        return ans;
    }

    private void addOperatorsRecur(List<String> ans, String pathSoFar, String num, int index, long evaluationSoFar, long lastOperand, int target) {
        if(index==num.length()){
            if(evaluationSoFar==target) ans.add(pathSoFar);
            return;
        }
        for(int i = index; i<num.length(); i++){
            long ch = Long.parseLong(num.substring(index, i+1));
            if(num.charAt(index)== '0' && i!=index) break;
            if(index==0){
                addOperatorsRecur(ans, pathSoFar + ch, num, i+1, ch, ch, target);
            }else {
                addOperatorsRecur(ans, pathSoFar + "+" + ch, num, i+1, evaluationSoFar + ch, ch, target);
                addOperatorsRecur(ans, pathSoFar + "*" + ch, num, i+1, evaluationSoFar-lastOperand+ lastOperand * ch, lastOperand*ch, target);
                addOperatorsRecur(ans, pathSoFar + "-" + ch, num, i+1, evaluationSoFar - ch,  -ch, target);
            }
        }
    }
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long lastMult) {

        for(int i = pos; i< num.length(); i++){
            long cur = Long.parseLong(num.substring(pos, i+1));

            if(num.charAt(pos) == '0' && i!=pos) break;
            else {
                if (pos == 0) {
                    helper(rst, path + cur, num, target, i + 1, cur, cur);
                } else {
                    helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);

                    helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);

                    helper(rst, path + "*" + cur, num, target, i + 1, eval - lastMult + lastMult * cur, lastMult * cur);
                }
            }
        }
    }

}
