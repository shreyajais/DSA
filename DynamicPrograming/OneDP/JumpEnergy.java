package DSA.DynamicPrograming.OneDP;

public class JumpEnergy {
    public int minimumEnergy(int arr[],int N){
        int[] dp = new int[N];
        dp[0] = 0;
        dp[1] = Math.abs(arr[1] - arr[0]);
        for(int i =2; i<N; i++){
            int oneStep = Math.abs(arr[i] - arr[i-1]) + dp[i-1];
            int twoStep = Math.abs(arr[i] -arr[i-2]) + dp[i-2];
            dp[i] = Math.min(oneStep, twoStep);
        }
        return dp[N-1];
    }
}
