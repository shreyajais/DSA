package DSA.Arrays.Medium;

import DSA.BinaryTrees.TreeNode;

import java.util.*;

public class LongestSubArraySumK {
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        Deque<Integer> dq = new LinkedList<>();
        int maxLen = 0;
        int sumSoFar = 0, i = 0;
        while(i<N){
            if(sumSoFar < K){
                dq.addFirst(A[i]);
                sumSoFar+=A[i];
            }
            if(sumSoFar > K) { sumSoFar -= dq.getLast(); dq.removeLast(); }
            if(sumSoFar == K) maxLen = Math.max(maxLen, dq.size());
            i++;
        }
        return maxLen;
    }
    // both positive ans negative
    public static int lenOfLongSubArrPosNeg (int A[], int N, int K) {
        Map<Integer, Integer> mp = new HashMap<>();
        int sumSoFar = 0;
        int maxLen = 0;
        for(int i =0; i<N; i++){
            sumSoFar+= A[i];
            if(sumSoFar== K) return i+1;
            else if(mp.containsKey(K-sumSoFar)) maxLen = Math.max(i-mp.get(K-sumSoFar), maxLen);
            if(!mp.containsKey(sumSoFar)) mp.put(i, sumSoFar);
        }
        return maxLen;
    }

    }
