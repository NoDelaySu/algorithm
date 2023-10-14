package shenxinfu;

import java.util.*;
//9,10,12
//100,300,200
//20

// 400
/**
 * @ClassName: Shenxinfu02
 * @Package: Shenxinfu
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/16 14:35
 * @Version: 1.0
 */
public class Shenxinfu02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] times = in.nextLine().split(",");
        String[] scores = in.nextLine().split(",");
        int[] timesList = new int[times.length];
        int[] scoresList = new int[scores.length];
        for (int i = 0; i < times.length; i++) {
            timesList[i] = Integer.parseInt(times[i]);
        }
        for (int i = 0; i < scores.length; i++) {
            scoresList[i] = Integer.parseInt(scores[i]);
        }

        int totalTime = Integer.parseInt(in.nextLine());

        System.out.println(getMaxScore(timesList, scoresList, totalTime));
    }

    private static int greedyAlgorithm(List<Integer> times, List<Integer> scores, int totalTime) {
        int maxScore = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < times.size(); i++) {
            Integer time = map.get(scores.get(i));
            if(time == null){
                map.put(scores.get(i), times.get(i));
            }else if(time > times.get(i)){
                map.put(scores.get(i), times.get(i));
            }
        }
        Collections.sort(scores);
        for (Integer score : scores) {
            if(totalTime > map.get(score)){
                totalTime -= map.get(score);
                maxScore += score;
            }
        }

        return maxScore;

    }

    public static int getMaxScore(int[] attackTimes, int[] scores, int totalTime) {
        int n = attackTimes.length;
        int[][] dp = new int[n + 1][totalTime + 1];

        for (int i = 1; i <= n; i++) {
            for (int t = 1; t <= totalTime; t++) {
                // 如果当前节点攻下所需时间小于等于剩余时间t
                if (attackTimes[i - 1] <= t) {
                    // 考虑攻下当前节点和不攻下当前节点两种情况，取分数最大值
                    dp[i][t] = Math.max(dp[i - 1][t], dp[i - 1][t - attackTimes[i - 1]] + scores[i - 1]);
                } else {
                    // 当前节点攻下所需时间大于剩余时间，无法攻下
                    dp[i][t] = dp[i - 1][t];
                }
            }
        }

        return dp[n][totalTime];
    }
}
