package DSA;

public class Revision {
    boolean isChar = Character.isLetterOrDigit('c');
    char[] arr ={1, 2};
    String str = String.valueOf(arr);
    // if answer giving stack overflow try converting to long or double from integer.
    // Prefix to infix : n-1 to 0 ===> move operator from left to right
    /*while (!stack.isEmpty() && Prec(c) <=Prec(stack.peek())) {result += stack.pop();}  stack.push(c); * */
    // Infix to post: 0 to n-1
    // postfix to infix: 0 to n
    // number of subarray that can be generated len = x ==> x(x+1)/2 sum of n natural numbers.


    // vvimp
    // end- start +1  => including start and end
    // end - start => excluding start or end
    // end - start-1 => excluding start and end



    // start and finish and index orientation and less tha or equal to.


    /*
    for(int i = 2*n-1; i>=0; i++){
            while(!st.isEmpty() && st.peek()< nums[i%n]) st.push(nums[i%n]);
            if(st.isEmpty()) ans[i%n] = -1;
            else ans[i%n] = st.peek();
        }
    * */



    /*
    * List of classes
    * */
}
