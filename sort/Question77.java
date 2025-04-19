package sort;

/**
 * 归并排序在链表中的应用
 */
public class Question77 {


    public static void main(String[] args)
    {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(6);
        ListNode result = new Question77().sortList(head);
        System.out.println(result);
    } 

    public ListNode sortList(ListNode head)
    {

        //递归退出条件
        if( head == null || head.next == null){
            return head;
        }
        ListNode headLeft = head;
        ListNode headRight = split(head);

        //递归左半部分链表
        sortList(headLeft);

        //递归右半部分链表
        sortList(headRight);

        return mergetSort(headLeft,headRight);
    }


    public ListNode mergetSort(ListNode headLeft , ListNode headRight)
    {

        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while( headLeft != null && headRight != null)
        {
            if( headLeft.val < headRight.val){
                cur.next = headLeft;
                headLeft = headLeft.next;
                cur = cur.next;
                
            }else{
                cur.next = headRight;
                headRight = headRight.next;
                cur = cur.next;
            } 
        }
        cur.next = headLeft == null ? headRight : headLeft;
        return dummyNode;
    }

    public ListNode split(ListNode node)
    {
        ListNode slow = node;
        ListNode fast = node.next;

        while (fast != null && fast.next != null) {
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
            slow = slow.next;
        }
        ListNode temp = slow.next;

        //将链表从中间断开 分成两段，返回后半段的头节点
        slow.next = null;
        return temp;
    }
    
}
