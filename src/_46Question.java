import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _46Question {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        int[] visit = new int[nums.length];
        dfs(resList, nums, numList, visit);

        return resList;
    }

    private static void dfs(List<List<Integer>> resList, int[] nums, List<Integer> numList, int[] visit) {
        if(nums.length == numList.size()){
            resList.add(new ArrayList<>(numList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visit[i] == 0){
                visit[i] = 1;
                numList.add(nums[i]);
                dfs(resList, nums, numList, visit);
                visit[i] = 0;
                numList.remove(numList.size() - 1);
            }
        }
    }
}
