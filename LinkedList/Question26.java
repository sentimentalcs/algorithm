package LinkedList;

public class Question26 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        headA.next.next.next.next.next = new ListNode(6);
        ListNode node =  reorderList(headA);
    }


    //     问题：给定一个链表，链表中节点的顺序是 L0→ L1→ L2→…→ Ln1→
    // Ln，请问如何重排链表使节点的顺序变成 L0→ Ln→ L1→ Ln1→ L2→
    // Ln2→…？例如，输入图 4.12（a）中的链表，重排之后的链表如图 4.12（b）
    // 所示
    public static ListNode reorderList(ListNode headA)
    {
       // 双指针找出中间节点
       ListNode dummy = new ListNode(0);
       dummy.next = headA;
       ListNode slow = dummy;
       ListNode fast = dummy;

       while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next;
        if(fast != null){
            fast = fast.next;
        }
       }
       ListNode reverListB = Question24.reverseList(slow.next);

       //将链表从中间断开
       slow.next = null;
       ListNode node = link(headA,reverListB);
       return node;
    }

    public static ListNode link(ListNode node1, ListNode node2)
    {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (node1 != null && node2 != null){
            prev.next = node1;
            ListNode tmp = node1.next;
            node1.next = node2;
            prev = node2;
            if(tmp != null){
                node1 = tmp;
            }
            
            if(node2 != null){
                node2 = node2.next;
            }
        } 

        //如果是奇数个节点，node1会剩下最后一个节点没有处理，需要在新链表中添加这个最后的节点。
        if( node1 != null){
            prev.next = node1;
        }
        return dummy;
    }

}
