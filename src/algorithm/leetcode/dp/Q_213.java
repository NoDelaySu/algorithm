package algorithm.leetcode.dp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: Q_213
 * @Package: algorithm.leetcode.dp
 * @Description: 打家劫舍II
 * @CreateDate: 2023/09/21 21:39
 * @Version: 1.0
 */
public class Q_213 {
    /**
     * @Title: 递推公式dp[i]=max(dp[i−2]+nums[i],dp[i−1])，
     * 边界dp[0]=nums[0]只有一间房屋，则偷窃该房屋，
     * 边界dp[1]=Math.max(nums[0], nums[1])则偷窃该房屋只有两间房屋，选择其中金额较高的房屋进行偷窃
     * @Description: 递推公式从元素个数1-N开始推导，如果是数组就从数字1-N开始推导
     */
    static class Solution {
        public int rob(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 0);
            if(nums.length == 1) return nums[0];
            if(nums.length == 2) return Math.max(nums[0], nums[1]);
            dp[0] = 1;
            if(nums[0] > nums[1]){
                dp[1] = 1;
            }
            nums[1] = Math.max(nums[0], nums[1]);
            for(int i = 2; i < nums.length; i++){
                if(i != nums.length - 1){
                    int n = nums[i-2] + nums[i];
                    int n_1 = nums[i-1];
                    if(n > n_1){
                        nums[i] = n;
                        dp[i] = dp[i-2] + dp[i];

                    }else{
                        nums[i] = n_1;
                        dp[i] = dp[i-1];
                    }

                }else{
                    if(dp[i-2] == 0){
                        nums[i] = Math.max(nums[i-2] + nums[i], nums[i-1]);
                    }else{
                        nums[i] = Math.max(nums[i], nums[i-1]);
                    }
                }

            }
            return nums[nums.length-1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {1,7,9,2};
        LinkedList<Integer> intLinkedList = new LinkedList<>();
        for (int anInt : ints) {
            intLinkedList.add(anInt);
        }
        if(intLinkedList.getFirst() < intLinkedList.getLast()){
            intLinkedList.addFirst(intLinkedList.getLast());
            intLinkedList.removeLast();
        }
        for (int i = 0; i < intLinkedList.size(); i++) {
            ints[i] = intLinkedList.get(i);
        }
        System.out.println(solution.rob(ints));
    }
}
