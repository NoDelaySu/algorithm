public class IntegerParameterExample {

    public static void main(String[] args) {
        Integer[] numContainer = { 10 };
        System.out.println("Before: " + numContainer[0]);
        modifyInteger(numContainer);
        System.out.println("After: " + numContainer[0]);
    }

    public static void modifyInteger(Integer[] container) {
        container[0] = container[0] + 5;
        System.out.println("Inside the function: " + container[0]);
    }
}
