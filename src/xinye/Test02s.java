package xinye;

import java.util.Scanner;

/**
 * @ClassName: Test02s
 * @Package: xinye
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/19 20:13
 * @Version: 1.0
 */
public class Test02s {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int n = scanner.nextInt();
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        int ways = countWaysToFillKnapsack(M, n, weights);
        System.out.println(ways);
    }

    public static int countWaysToFillKnapsack(int M, int n, int[] weights) {
        return countWays(M, n, weights, 0);
    }

    public static int countWays(int M, int n, int[] weights, int currentIndex) {
        if (M == 0) {
            return 1; // 找到一种选择方式
        }

        if (M < 0 || currentIndex >= n) {
            return 0; // 超出背包容量或者物品已经遍历完，无法选择
        }

        // 选择当前物品或者不选择当前物品
        int waysWithCurrentItem = countWays(M - weights[currentIndex], n, weights, currentIndex + 1);
        int waysWithoutCurrentItem = countWays(M, n, weights, currentIndex + 1);

        return waysWithCurrentItem + waysWithoutCurrentItem;
    }
}
