package DSA.Recursion.Easy;

import java.util.Stack;

public class SortStack {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        mergeSort(s);
        return s;
    }
    public Stack<Integer> mergeSort(Stack<Integer> s){
        if(s.isEmpty()) return s;
        int val = s.pop();
        Stack<Integer> st = mergeSort(s);
        merge(st, val);
        return st;
    }
    public void merge(Stack<Integer> s, int val){
        if(s.isEmpty()){
            s.push(val);
            return;
        } else if(s.peek()>val){
            s.push(val); return;
        }else {
            int top = s.pop();
            merge(s, val);
            s.push(top);
            return;
        }
    }
}
