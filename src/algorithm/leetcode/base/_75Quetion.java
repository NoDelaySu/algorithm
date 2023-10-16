import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _75Quetion
 * @Package: PACKAGE_NAME
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/15 17:19
 * @Version: 1.0
 */
class Solution {
    public void sortColors(int[] nums) {
        int[] nums2 = new int[nums.length];
        int p = 0, q = nums2.length - 1;
        for(int i = 0; i < nums2.length; i++){
            nums2[i] = 1;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                nums2[p++] = 0;
            }else if(nums[i] == 2){
                nums2[q--] = 2;
            }
        }
        nums = nums2;
        List<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            arrayList.add(nums[i]);
        }
        System.out.println(arrayList);
    }
}
public class _75Quetion {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        new Solution().sortColors(nums);
    }
}
