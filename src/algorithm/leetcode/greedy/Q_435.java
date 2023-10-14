package algorithm.leetcode.greedy;

import java.util.*;

/**
 * @ClassName: Q_435
 * @Package: algorithm.leetcode.greedy
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/29 18:08
 * @Version: 1.0
 */
@SuppressWarnings("ALL")
public class Q_435 {

    /**
     * @Title: 区间贪心算法，画图比较
     * @Description:
     */
    static class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if(intervals.length == 0){
                return 0;
            }
            int n = intervals.length;
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
            for (int[] interval : intervals) {
                System.out.println(Arrays.toString(interval));
            }
            int removed = 0;
            int prev = intervals[0][1];
            for (int i = 1; i < n; i++) {
                if(intervals[i][0] < prev){
                    ++removed;
                }else{
                    prev = intervals[i][1];
                }
            }
            return removed;

        }
//        public int eraseOverlapIntervals(int[][] intervals) {
//            int minErase = 0;
//            LinkedList<Integer[]> integersList = new LinkedList<>();
//            for (int[] interval : intervals) {
//                integersList.add(new Integer[]{interval[0], interval[1]});
//            }
//            Collections.sort(integersList, (a, b) -> {
//                if(a[0] == b[0]){
//                    return a[1] - b[1];
//                }
//                return a[0] - b[0];
//            });
//            for (Integer[] integers : integersList) {
//                System.out.println(Arrays.toString(integers));
//            }
//            System.out.println("=====");
//
//            Iterator<Integer[]> iterator = integersList.iterator();
//            Integer key = Integer.MIN_VALUE;
//            while(iterator.hasNext()){
//                Integer[] next = iterator.next();
//                if(key.equals(next[0])){
//                    minErase++;
//                    iterator.remove();
//                    System.out.println("delete" +Arrays.toString(next));
//                    //integersList.remove(next);
//                }else{
//                    key = next[0];
//                }
//            }
//            System.out.println("=====");
//            for (Integer[] integers : integersList) {
//                System.out.println(Arrays.toString(integers));
//            }
//            Collections.sort(integersList, (a, b) -> {
//                if(a[1] == b[1]){
//                    return b[0] - a[0];
//                }
//                return a[1] - b[1];
//            });
//            System.out.println("=====");
//
//            for (Integer[] integers : integersList) {
//                System.out.println(Arrays.toString(integers));
//            }
//
//            Iterator<Integer[]> iteratorReverse = integersList.iterator();
//            Integer keyReverse = Integer.MIN_VALUE;
//            while(iteratorReverse.hasNext()){
//                Integer[] next = iteratorReverse.next();
//                if(keyReverse.equals(next[1])){
//                    minErase++;
//                    iteratorReverse.remove();
//                    System.out.println("delete" + Arrays.toString(next));
//                    //integersList.remove(next);
//                }else{
//                    keyReverse = next[1];
//                }
//            }
//            System.out.println("=====");
//            for (Integer[] integers : integersList) {
//                System.out.println(Arrays.toString(integers));
//            }
//            System.out.println("=====");
//            LinkedList<Integer[]> nonRepeatList = new LinkedList<>();
//
//            Iterator<Integer[]> iteratorRepeat = integersList.iterator();
//            while(iteratorRepeat.hasNext()){
//                Boolean repeat = false;
//                Integer[] next = iteratorRepeat.next();
//                for (Integer[] nonRepeat : nonRepeatList) {
//                    if((next[0] > nonRepeat[0] && next[0] < nonRepeat[1]) ||
//                            next[1] > nonRepeat[0] && next[1] < nonRepeat[1]){
//                        minErase++;
//                        repeat = true;
//                        iteratorRepeat.remove();
//                        System.out.println("delete" + Arrays.toString(next));
//                        break;
//                    }
//                }
//                if(!repeat){
//                    nonRepeatList.add(new Integer[]{next[0], next[1]});
//                }
//            }
//
//
//            return minErase;
//        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals =  {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }
}
