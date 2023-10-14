package algorithm.leetcode.tree;

import java.util.Stack;

/**
 * @ClassName: FreTreeOrder
 * @Package: algorithm.leetcode.tree
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/27 14:42
 * @Version: 1.0
 */
public class FreTreeOrder {
    public static void main(String[] args) {
        Node node4 = new Node(4, null, null);
        Node node5 = new Node(5, null, null);
        Node node2 = new Node(2, node4, node5);
        Node node6 = new Node(6, null, null);
        Node node3 = new Node(3, null, node6);
        Node node1 = new Node(1, node2, node3);

        postOrderNot(node1);

    }

    private static void postOrder(Node node) {

        if(node != null && node.left != null){
            postOrder(node.left);
        }
        if(node != null && node.right != null){
            postOrder(node.right);
        }
        if(node != null){
            System.out.println(node.value);
        }
    }

    private static void postOrderNot(Node node) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node p = null;
        stack1.push(node);
        while(!stack1.empty() && (p = stack1.peek()) != null){
            if(p.right != null && !stack2.contains(p.right)){
                stack1.push(p.right);
            }
            if(p.left != null && !stack2.contains(p.left)){
                stack1.push(p.left);
            }
            if((p.left == null || stack2.contains(p.left))
                    && (p.right == null || stack2.contains(p.right))){
                stack2.push(stack1.pop());
            }
        }
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }

        while(!stack1.empty()){
            System.out.println(stack1.pop().value);
        }
    }

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
