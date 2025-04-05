package LinkedList;

public class Question24 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        headA.next.next.next.next.next = new ListNode(6);

        ListNode node =  reverseList(headA);
    }


//     题目：定义一个函数，输入一个链表的头节点，反转该链表并输出反
// 转后链表的头节点。例如，把图 4.8（a）中的链表反转之后得到的链表如
    public static ListNode  reverseList(ListNode head)
    {
        ListNode prev = null;
        ListNode next = null;
        ListNode current = head;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current; 
            current = next;
        }
        return prev;
    }
}
