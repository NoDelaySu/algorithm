package kingbase;

/**
 * @ClassName: Test
 * @Package: kingbase
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/24 18:21
 * @Version: 1.0
 */
public class Test{
        public static void main(String[]args){
            try{
                int i=100/0;
                System.out.print(i);
            }catch(Exception e){
                System.out.print(1);
                e.printStackTrace();
                throw new RuntimeException();
            }finally{
                System.out.print(2);
            }
            System.out.print(3);

        }
}