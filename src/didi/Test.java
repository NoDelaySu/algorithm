package didi;

/**
 * @ClassName: Test
 * @Package: didi
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/16 9:11
 * @Version: 1.0
 */
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Integer i = Integer.valueOf(1);
        list.add(i);
        list.add(i);
        list.add(i);
        list.remove(i);
        System.out.println(list);
    }
}
