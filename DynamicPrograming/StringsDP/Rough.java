package DSA.DynamicPrograming.StringsDP;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Rough {
        // Helper function to check if all characters from index 1 to i in S1 are '*'
        static boolean isAllStars(String S1, int i) {
            for (int j = 1; j <= i; j++) {
                if (S1.charAt(j - 1) != '*')
                    return false;
            }
            return true;
        }


}
