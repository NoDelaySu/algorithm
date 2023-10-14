import java.util.Arrays;

public class _142Question {
    private static ListNode node1 = new ListNode(1);
    private static ListNode node2 = new ListNode(2);
    private static ListNode node3 = new ListNode(0);
    private static ListNode node4 = new ListNode(-4);
    static{

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;
    }

    public static void main(String[] args) {
        ListNode listNode = detectCycle(node1);
        System.out.println(listNode);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        if(fast == null){
            return null;
        }
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
//        ListNode slow = head, fast = head.next;
//        while(slow != null && fast != null && slow != fast){
//            ListNode beforeFast = fast;
//            while(fast != null && fast != fast.next){
//                fast = fast.next;
//                fast = fast.next;
//                if(slow == fast || beforeFast == fast){
//                    break;
//                }
//            }
//            if(slow != null && fast != null && slow != fast){
//                slow = slow.next;
//
//            }else{
//                break;
//            }
//        }

//        return fast;
    }
}


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next.hashCode() +
                '}';
    }
}