package xinye;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: Test02sss
 * @Package: xinye
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/19 21:27
 * @Version: 1.0
 */
public class Test02sss {
    private static int res = 0;
    private static List<Integer> path = new LinkedList();
    private static List<List<Integer>> resList = new LinkedList();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int count = in.nextInt();
        int[] nums = new int[count];
        for(int i=0;i<count;i++){
            nums[i] = in.nextInt();
        }
        dfs(M,nums,0);
        System.out.println(res);
    }

    private static void dfs(int m, int[] nums, int index) {
        if(0 == m){
            LinkedList<Integer> linkedList = new LinkedList<>(path);
            Collections.sort(linkedList);
            if(!resList.contains(linkedList)){
                res++;
                resList.add(linkedList);
                //System.out.println(path);
            }
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            if(m >= nums[i]){
                dfs(m - nums[i], nums, i + 1);
            }
            path.remove(path.size() - 1);

        }
    }
}
