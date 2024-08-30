package DSA.HeapAndHashMap;

import java.util.ArrayList;

public class ConvertMinToMaxHeap {
    static void convertMinToMaxHeap(int N, int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i= N-1; i>=0; i--){
            ans.add(arr[i]);
            upheapify(ans.size()-1, ans);
        }
        for(int i = 0; i<N; i++) arr[i] = ans.get(i);
    }
    static private void upheapify(int index, ArrayList<Integer> ans) {
        if(index==0) return;
        int pIndex = getParent(index);
        if(ans.get(pIndex)< ans.get(index)){ // bigger element at top
            swapValues(pIndex, index, ans);
            upheapify(pIndex, ans);
        }
    }
    static private int getParent(int i){
        return (i-1)/2;
    }
    static private void swapValues(int pIndex, int index, ArrayList<Integer> ans) {
        int temp = ans.get(pIndex);
        ans.set(pIndex, ans.get(index));
        ans.set(index, temp);
    }

}
