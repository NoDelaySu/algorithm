package zhangyue;

/**
 * @ClassName: Main02
 * @Package: zhangyue
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/27 19:09
 * @Version: 1.0
 */
import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main02 {
    static class Solution{
        public static int findMinAbs(int[] array1, int[] array2){
            Arrays.sort(array1);
            Arrays.sort(array2);
            int minAbs = Integer.MAX_VALUE;
            int i = 0;
            int j = 0;
            while(i < array1.length & j < array2.length){
                int currAbs = Math.abs(array1[i] - array2[j]);
                minAbs = Math.min(minAbs, currAbs);
                if(array1[i] < array2[j]){
                    i++;
                }else{
                    j++;
                }
            }

            return minAbs;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        String inputStr1 = scanner.nextLine();
        String[] arrayStr1 = inputStr1.split(",");
        int[] array1 = new int[arrayStr1.length];
        for(int i = 0; i < array1.length; i++){
            array1[i] = Integer.parseInt(arrayStr1[i].trim());
        }
        String inputStr2 = scanner.nextLine();
        String[] arrayStr2 = inputStr2.split(",");
        int[] array2 = new int[arrayStr2.length];

        for(int i = 0; i < array2.length; i++){
            array2[i] = Integer.parseInt(arrayStr2[i].trim());
        }

        int minAbs = solution.findMinAbs(array1, array2);
        System.out.println(minAbs);

    }
}
