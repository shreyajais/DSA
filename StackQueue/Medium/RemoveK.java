package DSA.StackQueue.Medium;

import java.util.Stack;

public class RemoveK {
    public String removeKdigits(String num, int k) {
        int count = 0;
        int val = Integer.parseInt(num);
        Stack<Integer> st = new Stack<>();
        for(int i =0; i<num.length(); i++){
            int val = num.charAt(i);
            while(!st.isEmpty() && st.peek()>= val){
                st.pop();
                count++;
                if(count == k) break;
            }
            st.push(val);
        }
        while(count<k){
            st.pop();
            count++;
        }
        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop().toString() + ans;
        }
        while(ans.charAt(0) == '0'){
            ans = ans.substring(1);
        }
        return ans;
    }
}
