package meituan;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 输入考试场次
        int[] scores = new int[n]; // 存储每场考试的成绩
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt(); // 输入每场考试的成绩
        }

        int minScore = scores[0]; // 最低分初始化为第一场考试的成绩
        int maxScore = scores[0]; // 最高分初始化为第一场考试的成绩
        int count = 0; // 记录满足条件的考试场次数量

        for (int i = 1; i < n; i++) {
            if (scores[i] < minScore || scores[i] > maxScore) {
                count++;
            }
            // 更新最低分和最高分
            minScore = Math.min(minScore, scores[i]);
            maxScore = Math.max(maxScore, scores[i]);
        }

        System.out.println(count);
    }
}

