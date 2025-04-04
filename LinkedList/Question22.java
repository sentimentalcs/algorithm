package LinkedList;

public class Question22 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        ListNode node = detetcycle(head);
    }

//     题目：如果一个链表中包含环，那么应该如何找出环的入口节点？从
// 链表的头节点开始顺着 next 指针方向进入环的第 1 个节点为环的入口节点。
// 例如，在如图 4.3 所示的链表中，环的入口节点是节点 3。
//       |---------------|
// 1->2->3 -> 4 ->  5 -> 6
         
    public static ListNode detetcycle(ListNode head)
    {
        //快慢指针法，快指针走两步，慢指针走一步，相遇的点一定是在环中
        ListNode fast = head.next.next;
        ListNode slow = head.next;

        ListNode meetNode = null;
        while (slow != null && fast != null) {
            if(slow == fast){
                meetNode = slow;
                break;
            }

            //慢指针每次只走一步
            slow = slow.next;
            fast = fast.next;
            
            //快指针多走一步
            if(fast != null){
                fast = fast.next;
            }
        }
        if(meetNode == null){
            return meetNode;
        }

        //用另一个指针从头节点开始
        ListNode startNode = head;
        while (startNode != meetNode) {
            startNode = startNode.next;
            meetNode = meetNode.next;
        }
        return startNode;
    }
}
