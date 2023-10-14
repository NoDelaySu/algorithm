package xiecheng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: Main03
 * @Package: xiecheng
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/10/10 18:38
 * @Version: 1.0
 */
public class Main03 {

    public static int findMinOpeartion(String str){
        int n = str.length();
        int[][] dp = new int[n][26];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < 26; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                char currChar = (char)('a' + j);
                int cost = str.charAt(i-1) == currChar ? 0 : 1;
                for (int k = 0; k < 26; k++) {
                    char prevChar = (char)('a' + k);
                    if(str.charAt(i) != prevChar){
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + cost);
                    }
                }
            }
        }
        int minModifications = Integer.MAX_VALUE;
        int lastCHar = -1;
        for (int i = 0; i < 26; i++) {
            if(dp[n-1][i] < minModifications){
                minModifications = dp[n-1][i];
            }
        }

        return minModifications;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(findMinOpeartion(str));
    }
}
