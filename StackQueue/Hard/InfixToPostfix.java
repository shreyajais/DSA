package DSA.StackQueue.Hard;

import java.util.Stack;

public class InfixToPostfix {
    private static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        else if (ch == '*' || ch == '/') return 2;
        else if (ch == '^') return 3;
        else return -1;
    }

    public static String infixToPostfix(String exp) {
        // Your code here
        String ans = "";
        int n = exp.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) ans += ch;
            else if (ch == '(') st.push(ch);
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans += st.peek();
                    st.pop();
                }
                st.pop();
            } else {
                // badi peference wale pehele le leein to jo stack ka prefernce bada ho vo pehle nikal jaaye.
                while (!st.isEmpty() && precedence(ch) <= precedence(st.peek())) { // jo bade hein unko pehle chipkaa do
                    ans += st.peek();
                    st.pop();
                }
                st.push(ch);
            }
        }
        while (!st.isEmpty()) {
            if (st.peek() == '(') return "Invaild exp";
            else ans += st.pop();
        }
        return ans;
    }

    public static String infixToPrefix(String exp) {
        StringBuilder stb = new StringBuilder(exp);
        stb.reverse();
        String newExp = stb.toString();
        int len = newExp.length();
        for (int i = 0; i < len; i++) {
            char ch = newExp.charAt(i);
            if (ch == '(') newExp = newExp.substring(0, i) + ')' + newExp.substring(i + 1, len);
            else if (ch == ')') newExp = newExp.substring(0, i) + '(' + newExp.substring(i + 1, len);
        }
        return infixToPostfix(newExp);
    }
}