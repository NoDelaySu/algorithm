package meituan;
import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 输入数组长度
        int[] a = new int[n]; // 数组a
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] dp = new int[n]; // dp数组，用于记录以a[i]为结尾的最长好序列的长度
        dp[0] = 0; // 第一个元素本身就是一个好序列
        dp[1] = 0; // 第一个元素本身就是一个好序列
        int maxLength = 0; // 最长好序列的长度，初始化为1

        for (int i = 2; i < n; i++) {
            dp[i] = 3; // 初始化为1，至少包含自身
            for (int j = 0; j < i - 1; j++) {
                if (a[i] == a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]); // 更新最长好序列的长度
        }

        System.out.println(maxLength);
    }
}
