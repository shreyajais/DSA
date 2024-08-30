package DSA.Basic.Recursion;

public class PrintNto1 {
    void printNos(int N) {
        // code here
        if(N==0) return;
        System.out.print(N + " ");
        printNos(--N);
    }
}
