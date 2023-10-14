package tongcheng;

import java.util.Arrays;

/**
 * @ClassName: Main02
 * @Package: tongcheng
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/21 18:41
 * @Version: 1.0
 */
public class Main02 {

    public static void main(String[] args) {
        System.out.println(minDays(10));
    }

    public static int minDays (int n) {
        // write code here

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[(i)/3] + 1);
            }
        }
        return dp[n];
    }
}
