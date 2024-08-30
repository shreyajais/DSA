package DSA.Basic.Recursion;

public class Print {
    public void printNos(int N)
    {
        //Your code here
        int val = 1;
        printRecur(val, N);
    }

    private void printRecur(int val, int n) {
        if(val>n) return;
        System.out.print(val + " ");
        printRecur(++val, n);
    }

}
