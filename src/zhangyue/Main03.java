package zhangyue;

import java.util.*;

/**
 * @ClassName: Main03
 * @Package: zhangyue
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/27 19:09
 * @Version: 1.0
 */
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main03 {
    static class Solution{
        public static int minCutNum(String s){
            int n = s.length();
            boolean[][] isPaddle = new boolean[n][n];
            int[] dp = new int[n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j <= i; j++){
                    if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || isPaddle[j+1][i-1])){
                        isPaddle[j][i] = true;
                    }
                }
            }

            for(int i = 0; i < n; i++){
                int minCutNum = i;
                for(int j = 0; j <= i; j++){
                    if(isPaddle[j][i]){
                        minCutNum = (j == 0) ? 0 : Math.min(minCutNum, dp[j-1] + 1);
                    }
                }
                dp[i] = minCutNum;
            }

            return dp[n-1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int minCutNum = solution.minCutNum(s);
        System.out.println(minCutNum);

    }
}
