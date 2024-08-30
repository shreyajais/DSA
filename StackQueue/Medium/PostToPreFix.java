package DSA.StackQueue.Medium;

public class PostToPreFix {
    static String postToPre(String post_exp) {
        // code here
        int n = post_exp.length();
        String inExp = getPreToInfixWithBrackets(post_exp, n);
        return getInWithBrackets(inExp, n);
    }

    private static String getInWithBrackets(String inExp, int n) {
    }

    private static String getPreToInfixWithBrackets(String post_exp, int n) {
    }

}
