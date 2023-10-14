package tencent;

/**
 * @ClassName: tencent.Tencent3
 * @Package: PACKAGE_NAME
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/10 20:30
 * @Version: 1.0
 */
public class Tencent3 {
    public static int maxCourage(int[] monsters) {
        int n = monsters.length;
        int maxStrength = 0;
        for (int monster : monsters) {
            maxStrength += monster; // 计算所有怪物的总战斗力
        }

        int[][] dp = new int[n + 1][maxStrength + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= maxStrength; j++) {
                // 不打败第i只怪物
                dp[i][j] = dp[i - 1][j];

                // 打败第i只怪物
                if (j >= monsters[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - monsters[i - 1]] + monsters[i - 1]);
                }
            }
        }

        return dp[n][maxStrength];
    }

    public static void main(String[] args) {
        int[] monsters = {2, 3, 1, 5, 10};
        int maxCourageValue = maxCourage(monsters);
        System.out.println("最大可能的勇气值提升为: " + maxCourageValue);
    }

}
