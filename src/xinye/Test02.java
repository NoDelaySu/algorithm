package xinye;

//40
//3
//20
//20
//20

//3

/**
 * @ClassName: Test02
 * @Package: xinye
 * @Version: 1.0
 */
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt(); // 背包总的承重
        int n = scanner.nextInt(); // 不同的物品的数目
        int[] weights = new int[n]; // 物品重量数组

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        int ways = countWaysToFillBackpack(M, weights);
        System.out.println(ways);
    }

    public static int countWaysToFillBackpack(int M, int[] weights) {
        int n = weights.length;
        int[][] dp = new int[n + 1][M + 1];

        // 初始化dp数组
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j]; // 不选择第i个物品

                if (j >= weights[i - 1]) {
                    dp[i][j] += dp[i - 1][j - weights[i - 1]]; // 选择第i个物品
                }
            }
        }

        return dp[n][M];
    }
}

