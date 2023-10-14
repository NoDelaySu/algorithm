package algorithm.leetcode.dp;

/**
 * @ClassName: Q_198
 * @Package: algorithm.leetcode.dp
 * @Description: 打家劫舍
 * @CreateDate: 2023/09/21 21:39
 * @Version: 1.0
 */
public class Q_198 {
    /**
     * @Title: 递推公式dp[i]=max(dp[i−2]+nums[i],dp[i−1])，
     * 边界dp[0]=nums[0]只有一间房屋，则偷窃该房屋，
     * 边界dp[1]=Math.max(nums[0], nums[1])则偷窃该房屋只有两间房屋，选择其中金额较高的房屋进行偷窃
     * @Description: 递推公式从元素个数1-N开始推导，如果是数组就从数字1-N开始推导
     */
    static class Solution {
        public int rob(int[] nums) {
            if(nums.length == 1) return nums[0];
            if(nums.length == 2) return Math.max(nums[0], nums[1]);
            if(nums.length == 3) return Math.max(nums[0]+nums[2], nums[1]);
            nums[1] = Math.max(nums[0], nums[1]);
            nums[2] = nums[0] + nums[2];
            for(int i = 3; i < nums.length; i++){
                nums[i] = Math.max(nums[i-3] + nums[i], nums[i-2] + nums[i]);
                nums[i] = Math.max(nums[i-1], nums[i]);
            }
            return nums[nums.length-1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{2,3,2}));
    }
}
