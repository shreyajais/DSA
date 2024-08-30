package DSA.Recursion.Easy;

import java.util.Stack;

public class ReverseStack {
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        func2(s);
    }

    static Stack<Integer> func2(Stack<Integer> s){
        if(s.isEmpty()) return s;
        int top = s.pop();
        Stack<Integer> st = func2(s);
        funcDestroy(st, top);
        return st;
    }
    static void funcDestroy(Stack<Integer> s, int val){
        if(s.isEmpty()){
            s.push(val); return;
        }
        int top = s.pop();
        funcDestroy(s, val);
        s.push(top);
    }
}
