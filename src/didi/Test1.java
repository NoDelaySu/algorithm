package didi;

/**
 * @ClassName: Test1
 * @Package: didi
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/16 9:21
 * @Version: 1.0
 */
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            // 注意 hasNext 和 hasNextLine 的区别
            String line = in.nextLine();
            String[] arrayLine = line.split(" ");
            System.out.println(Integer.parseInt(arrayLine[0]) + Integer.parseInt(arrayLine[1]));
        }

    }
}
