package DSA.Basic.Recursion;

public class PrintGFG {
    void printGfg(int N) {
        // code here
        int val = 1;
        printRecur(val, N);
    }
    private void printRecur(int val, int n) {
        if(val>n) return;
        System.out.print("GFG ");
        printRecur(++val, n);
    }
}
