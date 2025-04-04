package LinkedList;

public class Question23 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        headA.next.next.next.next.next = new ListNode(6);

        ListNode headB = new ListNode(7);
        headB.next = new ListNode(8);
        headB.next.next = headA.next.next.next;

        ListNode node = getFirstIntersectionNode(headA,headB);
    }


//     题目：输入两个单向链表，请问如何找出它们的第 1 个重合节点。例
// 如，图 4.5 中的两个链表的第 1 个重合节点的值是 4。
// 1 -> 2 -> 3 -> 4 -> 5 -> 6
//      7 -> 8 |
    public static ListNode getFirstIntersectionNode(ListNode headA,ListNode headB)
    {

        int headASize = countLinkedList(headA);
        int headBSize = countLinkedList(headB);
        int delta = Math.abs(headASize - headBSize);

        ListNode longerNode = headASize > headBSize ? headA : headB;
        ListNode shorterNode = headASize > headBSize ? headB : headA;
        ListNode longerNodePoint = null;
        for(int i = 0 ; i < delta ; i++){
            longerNodePoint = longerNode.next;
        }

        while (shorterNode != longerNodePoint) {
            shorterNode = shorterNode.next;
            longerNodePoint = longerNodePoint.next;
        }
        return shorterNode;
    }

    public static int countLinkedList(ListNode node)
    {
        int i = 1;
        while (node.next != null) {
           i++;
           node = node.next; 
        }
        return i;
    }
}
