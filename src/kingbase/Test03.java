package kingbase;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName: Test03
 * @Package: kingbase
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/24 18:32
 * @Version: 1.0
 */
public class Test03 {
    public static void main(String[] args) {
        Queue<String> fifoQueue = new LinkedList<>();
        fifoQueue.add("A");
        fifoQueue.add("B");
        fifoQueue.add("C");
        System.out.println(fifoQueue.poll());
        System.out.println(fifoQueue.poll());
        System.out.println(fifoQueue.poll());

        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack.pop());

        Queue<Integer> fifoQueue1 = new PriorityQueue<>();
        fifoQueue1.offer(3);
        fifoQueue1.offer(1);
        fifoQueue1.offer(2);
        System.out.println(fifoQueue1.poll());

        LinkedList<String> list = new LinkedList<>();
        list.add("X");
        list.add("Y");
        list.add("Z");
        System.out.println(list.poll());
        System.out.println(list.poll());
        System.out.println(list.poll());




    }
}
