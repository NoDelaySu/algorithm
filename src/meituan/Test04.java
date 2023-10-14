package meituan;

import java.util.Scanner;
//5
//1 2 3 20 28

//1
/**
 * @ClassName: Test04
 * @Package: meituan
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/16 18:52
 * @Version: 1.0
 */
public class Test04 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int maxPower = getMaxPower(nums);
        System.out.println(maxPower);

    }

    private static int getMaxPower(int[] nums) {
        int n = nums.length;
        int maxM = 0;
        for (int num : nums) {
            int m = getM(num);
            maxM = Math.max(maxM, m);
        }
        boolean[][] dp = new boolean[n+1][maxM+1];
        dp[0][0] = true;
        for (int i = 1; i <= n ; i++) {
            int num = nums[i-1];
            int m = getM(num);
            for (int j = 0; j <= maxM; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= m && dp[i-1][j-m]){
                    dp[i][j] = true;
                }
            }
        }
        for (int i = maxM; i >= 0 ; i--) {
            if(dp[n][i]){
                return i;
            }
        }
        return 0;
    }

    private static int getM(int num) {
        int m = 0;
        while(num % 2 == 0){
            num /= 2;
            m++;
        }
        return m;
    }
}
