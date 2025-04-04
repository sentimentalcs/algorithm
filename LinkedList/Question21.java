package LinkedList;

public class Question21 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode node = removeNthFromEnd(head,2);

    }


    // 题目：如果给定一个链表，请问如何删除链表中的倒数第 k 个节点？
    // 假设链表中节点的总数为 n，那么 1≤k≤n。要求只能遍历链表一次。
    // 例如，输入图 4.1（a）中的链表，删除倒数第 2 个节点之后的链表如
    // 图 4.1（b）所示。


//     但题目要求只能遍历链表一次。为了实现只遍历链表一次就能找到倒
// 数第 k+1 个节点，可以定义两个指针。第 1 个指针 P1从链表的头节点开始
// 向前走 k 步，第 2 个指针 P2保持不动；从第 k+1 步开始指针 P2 也从链表的
// 头节点开始和指针 P1 以相同的速度遍历。由于两个指针的距离始终保持为
// k，当指针 P1 指向链表的尾节点时指针 P2正好指向倒数第 k+1 个节点。
    public static ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode front = head; 
        ListNode back = head;
        for(int i = 0 ; i < n; i++)
        {
            front = front.next;
        }

        while (front.next != null) {
            front = front.next;
            back = back.next;
        }

        back.next = back.next.next;
        return head;
    }
    
}
