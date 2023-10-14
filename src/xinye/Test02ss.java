package xinye;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName: Test02ss
 * @Package: xinye
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/19 20:19
 * @Version: 1.0
 */
public class Test02ss {

    public static LinkedList<Integer> path = new LinkedList<>();
    public static int res = 0;

    public static int process(int M , int[] nums){
        handle(M,nums,0);
        return res;
    }

    public static void handle(int M , int[] nums , int index){
        if(index == nums.length){
            int sum = 0;
            for (int i=0;i<path.size();i++){
                sum += path.get(i);
            }
            if(sum==M){
                res++;
            }
            return;
        }

        // 选择index位置的元素
        path.add(nums[index]);
        handle(M,nums,index+1);

        //不选择index位置的元素
        path.removeLast();
        handle(M,nums,index+1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int count = in.nextInt();
        int[] nums = new int[count];
        for(int i=0;i<count;i++){
            nums[i] = in.nextInt();
        }
        System.out.println(process(M,nums));
    }
}
