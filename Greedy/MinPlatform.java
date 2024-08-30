package DSA.Greedy;

import java.util.Arrays;

public class MinPlatform {
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr); Arrays.sort(dep);
        int arrI = 0, depI = 0, maxPlatformSoFar = 0, platformCount = 0;
        while(arrI<n && depI<n){
            if(arr[arrI]< dep[depI]){
                platformCount++; maxPlatformSoFar = Math.max(maxPlatformSoFar, platformCount);
                arrI++;
            } else {
                platformCount--;
                depI++;
            }
        }
        return maxPlatformSoFar;
    }
}
