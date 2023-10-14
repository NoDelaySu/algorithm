public class _540Question {
    public static int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int res = 0;
        int low = 0, high = nums.length - 1, mid = 0;
        while (low < high){
            mid = (low + high) / 2;
            if(nums[mid] == nums[mid ^ 1]){
                low = mid + 1;
            }else{
                high = mid;
            }
//            if(mid % 2 == 0 && nums[mid] == nums[mid+1] || mid % 2 == 1 && nums[mid] == nums[mid-1]){
//                low = mid + 1;
//            }else{
//                high = mid - 1;
//            }
        }
        res = nums[low];

        return res;
    }

    public static void main(String[] args) {
        int [] nums = {1,1,2,3,3};
        System.out.println(singleNonDuplicate(nums));
    }
}
