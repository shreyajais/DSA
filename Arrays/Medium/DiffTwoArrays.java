package DSA.Arrays.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiffTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        for(int i =0; i<n1; i++) s.add(nums1[i]);
        for(int i =0; i<n2; i++) s.add(nums2[i]);
    }
}


// Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where.
// answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
// answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
// Note: that the integers in the lists may be returned in any order.