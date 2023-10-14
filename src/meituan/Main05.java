package meituan;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取数组大小和查询次数
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = new int[n];

        // 读取数组元素
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 处理每次查询
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt() - 1; // 转换为 0-based 索引
            int r = scanner.nextInt() - 1; // 转换为 0-based 索引
            int x = scanner.nextInt();

            boolean found = false;
            for (int j = l; j <= r; j++) {
                if (isNotPerfectSquare(arr[j] * x)) {
                    System.out.println(arr[j]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println(-1);
            }
        }
    }

    // 判断一个数是否不是完全平方数
    public static boolean isNotPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt != num;
    }
}
