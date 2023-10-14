package algorithm.leetcode.greedy;

/**
 * @ClassName: Q_2591
 * @Package: algorithm.leetcode.greedy
 * @Description: 将钱分给最多的儿童
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/22 9:54
 * @Version: 1.0
 */
public class Q_2591 {
    /**
     * @Title: 贪心算法，每个子问题求最优，最后得到一定是最优答案
     * @Description: 思路先给每个孩子分1块，在将剩余的尽可能的分配给每个孩子到8块，最后剩余4快，且是最后一个孩子就需要破坏之前其中一个8快
     */
    static class Solution {
        public int distMoney(int money, int children) {
            int n = 0;
            if(money < children){
                return -1;
            }
            money -= children;
            for(int i = 0; i < children; i++){
                if(money >= 7){
                    if(i == children - 1 ){
                        if(money == 7){
                            n++;
                        }
                        money = 0; //必须分配完
                    }else{
                        n++;
                        money -=7;
                    }

                }else if(money == 3){
                    if(i == children - 1){
                        n--;
                        break;
                    }else{
                        money = 0;
                    }
                }
            }
            return n;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.distMoney(16, 2));
    }
}
