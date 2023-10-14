package didi;

import java.util.*;

class Solution01{
    public int maxMinDistance(int[] position, int k){
        Arrays.sort(position);
        int n = position.length;
        int maxDistance = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++){
            int distance = position[i] - position[i-1];
            maxDistance = Math.max(maxDistance, distance);
        }
        maxDistance = Math.max(maxDistance, position[0]);
        maxDistance = Math.max(maxDistance, k - position[n - 1]);

        return maxDistance;
    }
}

public class Didi01{
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//
//        int[] position = new int[n];
//        for(int i = 0; i < n; i++){
//            int num = sc.nextInt();
//            position[i] = num;
//        }
        int n = 5;
        int k = 3;
        int [] position = {1, 3, 4, 7, 9};
        Solution01 solution = new Solution01();
        System.out.println(solution.maxMinDistance(position, k));
    }
}