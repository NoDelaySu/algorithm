/**
 * @ClassName: CiteValueExample
 * @Package: PACKAGE_NAME
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/02 17:35
 * @Version: 1.0
 */
public class CiteValueExample {


    public static void main(String[] args) {
//        Integer num = new Integer(10);
        IntegerWrapper num = new IntegerWrapper(10);
        System.out.println("原始方法地址：" + System.identityHashCode(num));
        changeValue(num);
        System.out.println("调用方法后的值：" + num);
    }

    public static void changeValue(IntegerWrapper value) {
        System.out.println("目标方法地址：" + System.identityHashCode(value));
        value.num = 20;
        System.out.println("方法内修改后的值：" + value);
    }

}

class IntegerWrapper{
    Integer num;

    public IntegerWrapper(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IntegerWrapper{");
        sb.append("num=").append(num);
        sb.append('}');
        return sb.toString();
    }
}
