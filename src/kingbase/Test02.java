package kingbase;

/**
 * @ClassName: Test02
 * @Package: kingbase
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/24 18:28
 * @Version: 1.0
 */
public class Test02 {

    public static void main(String[]args) {
        int[] numbers = new int[3];
        String name = null;
        try{
            int result = numbers[4] / name.length();
            System.out.println("结果：" + result);
        }catch(ArithmeticException ae){
            System.out.println("捕获算术异常："+ae.getClass().getName());
        }catch (NullPointerException npe){
            System.out.println("捕获空指针异常："+npe.getClass().getName());
        }catch(Exception e){
            System.out.println("捕获异常："+e.getClass().getName());
        }
    }
}
