package DSA.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class WithoutConsecutiveOne {
    static List<String> fun(int k){
        List<String> ans = new ArrayList<>();
        if(k==0) return ans;
        List<ArrayList<Integer>> pathAns = new ArrayList<>();
        generateNonConsecutive(k, pathAns);
        construct(pathAns, ans);
        return ans;
    }

    private static void construct(List<ArrayList<Integer>> pathAns, List<String> ans) {
        for(ArrayList<Integer> arr: pathAns){
            String s = "";
            for(int i: arr){
                s+= Integer.toString(i);
            }
            ans.add(s);
        }
    }

    private static void generateNonConsecutive(int k, List<ArrayList<Integer>> pathAns) {
        ArrayList<Integer> firstOne = new ArrayList<>();
        firstOne.add(1);
        addNew(k, 1, firstOne, pathAns);
        ArrayList<Integer> firstZero = new ArrayList<>();
        firstOne.add(0);
        addNew(k, 0, firstZero, pathAns);
    }
    private static void addNew(int k, int lastValue, ArrayList<Integer> valueList, List<ArrayList<Integer>> pathAns){
        if(k == valueList.size()){
            pathAns.add(new ArrayList<>(valueList));
            return;
        }
        if(lastValue==0){
            valueList.add(1);
            addNew(k, 1, valueList, pathAns);
            valueList.remove(valueList.size()-1);
        }
        valueList.add(0);
        addNew(k, 0, valueList, pathAns);
    }

}
