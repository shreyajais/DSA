package DSA.StackQueue.Medium;

import java.util.Stack;

public class OnlineStockSpan {
    class StockSpanner {
        class Pair{
            int value; int index; int span;
            Pair(int value, int span){
                this.value = value;
                this.span = span;
            }
        }
        Stack<Pair> st1; Stack<Pair> st2;
        public StockSpanner() {
            st1 = new Stack<>();
            st2 = new Stack<>();
        }

        public int next(int price) {
            while(st1.size()>0 && st1.peek().value>price) st2.push(st1.pop());
            int val = st1.size()==0 ? 1: st1.peek().span +1;
            while(st2.size()>0) st1.push(st2.pop());
            st1.push(new Pair(price, val));
            return val;
        }
        private void onlineStock(int[] nums){
            int n = nums.length;
            int[] sp = new int[n];
            Stack<Integer> st = new Stack<>();
            for(int i =0; i<n; i++){
                while(!st.isEmpty()){
                    if(nums[st.peek()]>nums[i]){
                        sp[i] = st.peek();
                        st.push(i);
                        break;
                    } else st.pop();
                }
            }
        }
    }

}
