package meituan;

import java.util.Scanner;

/**
 * @ClassName: Test01
 * @Package: meituan
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/16 18:52
 * @Version: 1.0
 */
public class Test01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int score = 0;
        boolean lastwin = false;
        for (int i = 0; i < n; i++) {
            int win = in.nextInt();
            if(win == 1){
                if(lastwin){
                    score += 2;
                }else{
                    score += 1;
                }
                lastwin = true;
            }else{
                lastwin = false;
            }
        }
        System.out.println(score);
    }
}
