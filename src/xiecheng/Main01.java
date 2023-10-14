package xiecheng;

import java.util.Scanner;

/**
 * @ClassName: Main01
 * @Package: xiecheng
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/10/10 18:38
 * @Version: 1.0
 */
public class Main01 {

    public static int maxPalindromeSubstring(String str){
        int count = 0;
        int currMaxCount = 0;
        int n = str.length();
        for (int i = 0; i < n - 2; i++) {
            if(str.charAt(i) == str.charAt(i + 2)){
                currMaxCount++;
                System.out.println(i);
                if(currMaxCount == n - 2){
                    break;
                }
            }
            if(i - 2 >= 0 && str.charAt(i) != str.charAt(i - 2)){
                count = Math.max(count, 1);
            }
            if(i + 2 < n && str.charAt(i) != str.charAt(i + 2)){
                count = Math.max(count, 1);
            }
            if(i - 2 >= 0 && str.charAt(i) != str.charAt(i - 2)
                    && i + 2 < n && str.charAt(i) != str.charAt(i + 2)){
                count = Math.max(count, 2);
            }
        }

        return count + currMaxCount;
    }

    private static int countPalindromeSubstring(String str, int i) {
        int count = 0;
        int n = str.length();
        if(i - 2 >= 0 && str.charAt(i) == str.charAt(i - 2)){
            count = 1;
        }
        if(i + 2 < n && str.charAt(i) == str.charAt(i + 2)){
            count = 1;
        }
        if(i - 2 >= 0 && str.charAt(i) == str.charAt(i - 2)
                && i + 2 < n && str.charAt(i) == str.charAt(i + 2)){
            count = 2;
        }
        return count;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(maxPalindromeSubstring(str));

    }
}
