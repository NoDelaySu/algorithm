package jindie;

/**
 * @ClassName: Test
 * @Package: jindie
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/10/07 21:40
 * @Version: 1.0
 */



public class Test {

    public static void test2(int i){
        try{
            if(i == 1){
                System.out.println("2");
                throw new RuntimeException("123");
            }
        }catch (Exception e){
            System.out.println("3");
            return ;
        }finally {
            System.out.println("4");
        }
        System.out.println("5");
        return ;
    }

    public static void main(String[] args) {
        test2(0);
        test2(1);

    }

}
