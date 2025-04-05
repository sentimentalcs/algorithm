package LinkedList;

public class Question25 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(9);
        headA.next = new ListNode(8);
        headA.next.next = new ListNode(4);


        ListNode headB = new ListNode(1);
        headB.next = new ListNode(8);
        ListNode node =  addTwoNumbers(headA,headB);
    }


    // 题目：给定两个表示非负整数的单向链表，请问如何实现这两个整数
    // 的相加并且把它们的和仍然用单向链表表示？链表中的每个节点表示整数
    // 十进制的一位，并且头节点对应整数的最高位数而尾节点对应整数的个位
    // 数。例如，在图 4.10（a）和图 4.10（b）中，两个链表分别表示整数 123
    // 和 531，它们的和为 654，对应的链表如图 4.10（c）所示
    public static ListNode addTwoNumbers(ListNode head1, ListNode head2)
    {
        ListNode reverseHead1 = reverseList(head1);
        ListNode reverseHead2 = reverseList(head2);
        ListNode sumListCurrent = null;
        ListNode sumListHead = null;
        int putNextVal = 0;
        while (reverseHead1 != null || reverseHead2 != null) {
            int head2Val = 0;
            int head1Val = 0;
            head1Val = reverseHead1 == null ? 0 : reverseHead1.val;
            head2Val = reverseHead2 == null ? 0 : reverseHead2.val;
            int sum = head1Val + head2Val + putNextVal;
            if(sum >= 10){
                putNextVal = 1;
                sum = sum - 10;
            }
            if(sumListCurrent == null){
                sumListCurrent = new ListNode(sum);
                sumListHead = sumListCurrent;
            }else{
                sumListCurrent.next = new ListNode(sum);
                sumListCurrent = sumListCurrent.next;
            }
            


            if(reverseHead1 != null){
                reverseHead1 = reverseHead1.next;
            }
            
            if(reverseHead2 != null){
                reverseHead2 = reverseHead2.next;   
            }
        }
        if(putNextVal > 0){
            sumListCurrent.next = new ListNode(putNextVal);
        }
        return sumListHead;
    }


    public static ListNode reverseList(ListNode head)
    {
        ListNode next = null;
        ListNode prev = null;
        ListNode current = head;
        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
