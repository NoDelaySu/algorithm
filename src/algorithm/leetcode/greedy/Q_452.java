package algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: Q_452
 * @Package: algorithm.leetcode.greedy
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/10/08 20:12
 * @Version: 1.0
 */
public class Q_452 {

    static class Solution{
        public int findMinArrowShots(int[][] points) {

            if(points.length == 0){
                return 0;
            }
            int n = points.length;
            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] > o2[1]) {
                        return 1;
                    } else if (o1[1] < o2[1]) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
            for (int[] interval : points) {
                System.out.println(Arrays.toString(interval));
            }

            int shots = 1;
            int right = points[0][1];

            for (int i = 0; i < n; i++) {
                if(points[i][0] > right){
                    right = points[i][1];
                    shots++;
                }
            }
//            boolean[] bombs = new boolean[n];
//            for (int i = 0; i < n; i++) {
//                if(!bombs[i]){
//                    ++shots;
//                    bombs[i] = true;
//                }else{
//                    continue;
//                }
//                int right = points[i][1];
//                for (int j = i + 1; j < n; j++) {
//                    if(!bombs[j]){
//                        if(points[j][0] <= right){
//                            bombs[j] = true;
//                        }else{
//                            break;
//                        }
//                    }
//                }
//            }
            return shots;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        {{-2147483646,-2147483645},{2147483646,2147483647}}
        int[][] points =  {{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(solution.findMinArrowShots(points));
    }
}
