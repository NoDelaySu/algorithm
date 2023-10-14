package meituan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.ConcurrentMap;

//3 4 5
//1 4 5
//3 4 5

// 1

/**
 * @ClassName: Test03
 * @Package: meituan
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/16 18:52
 * @Version: 1.0
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int H = in.nextInt();
        int A = in.nextInt();

        int[] hi = new int[n];
        int[] ai = new int[n];

        for (int i = 0; i < n; i++) {
            hi[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ai[i] = in.nextInt();
        }

        System.out.println(getDefeatedMonsters(n,H,A,hi,ai));

    }

    private static int getDefeatedMonsters(int n, int H, int A, int[] hi, int[] ai) {
        int defeatedMonsters = 0;
        int[][]dp = new int[n+1][H+A+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= H; j++) {
                for (int k = 1; k <= A; k++) {
                    if(j >= hi[i-1] && k >= ai[i-1]){
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-hi[i-1]]+1);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[n][H];
    }
}
