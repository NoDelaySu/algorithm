package algorithm.leetcode.dp;

/**
 * @ClassName: Q_70
 * @Package: algorithm.leetcode.dp
 * @Description: 爬楼梯（斐波那契变形）
 * @CreateDate: 2023/09/21 21:36
 * @Version: 1.0
 */
public class Q_70 {
    /**
     * @Title: 递推公式dp[n] = dp[n-1] + dp[n-2],在n-1和n-2台阶可以直接到达n台阶，所以到达n台阶方案等于他两之和
     * @Description: 动态规划基础，找出递推公式，从结束状态开始往回推，动态规划重叠子问题，每个子问题求出最优解
     */
    static class Solution {
        public int climbStairs(int n) {
            if(n == 1) return 1;
            if(n == 2) return 2;
            int[] dp = new int[n + 1];
            dp[1] = 1; dp[2]= 2;
            for(int i = 3; i <= n; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(4));
    }

}
