import java.util.*;

/**
 * @ClassName: _179Question
 * @Package: PACKAGE_NAME
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/12 21:48
 * @Version: 1.0
 */
public class _179Question {
    public static void main(String[] args) {
        int[] nums = {34323, 3432}; //没有考虑到322 ，32 还有 34323， 3432这种
        System.out.println(largestNumber2(nums));
    }

    public static String largestNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (y + x).compareTo(x + y));
        if (strs[0].equals("0"))
            return "0";
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }

    public static String largestNumber(int[] nums) {
        String res = "";
        int maxNumLength = 0;
        for (int num : nums) {
            maxNumLength = Math.max(String.valueOf(num).length(), maxNumLength);
        }
        HashMap<Integer, Integer> numScoreMap = new HashMap<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            int[] num = num2array(nums[i]);
            int[] score = new int[maxNumLength];
            for(int j = score.length - 1; j >= 0; j--){
                if(j >= score.length - num.length){
                    score[j] = num[j - score.length + num.length];
                }else{
                    score[j] = score[j + 1];
                }
            }
            numScoreMap.put(array2num(score), nums[i]); //没有考虑key相同的情况
        }


        List<Integer> keyList = new ArrayList<>(numScoreMap.keySet());


        Collections.sort(keyList, Collections.reverseOrder());

        for (Integer score : keyList) {
            res += numScoreMap.get(score);
        }

        return res;
    }

    public static int[] num2array(int num){
        String s = String.valueOf(num);
        int length = s.length();
        int[] array = new int[length];
        for (int i = 0; i <= array.length - 1; i++) {
            char c = s.charAt(i);
            array[length - 1 - i] = Integer.parseInt(Character.toString(c));
        }
        return array;
    }

    public static int array2num(int[] array){
        int decimal = 0;
        int base = 1;

        for (int i = 0; i <= array.length - 1; i++) {
            decimal += array[i] * base;
            base *= 10;
        }

        return decimal;
    }
}
