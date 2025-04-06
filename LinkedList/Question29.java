package LinkedList;


public class Question29 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(6);

        //最后一个节点指向第一个节点，形成循环链表
        headA.next.next.next.next.next = headA;
        ListNode node =  insert(headA,0);
    }


    // 问题：在一个循环链表中节点的值递增排序，请设计一个算法在该循
    // 环链表中插入节点，并保证插入节点之后的循环链表仍然是排序的。例如，
    // 图 4.15（a）所示是一个排序的循环链表，插入一个值为 4 的节点之后的链
    // 表如图 4.15（b）所示。
    public static ListNode insert(ListNode head, int insertVal)
    {
       //没有节点
       if(head == null){
         ListNode node = new ListNode(insertVal);
         node.next = node;
         return node;
       }else if(head.next == head){
         //只有一个节点
         ListNode node = new ListNode(insertVal);
         head.next = node;
         node.next = head;
       }else{
         ListNode node = new ListNode(insertVal);
         return insertCore(head,node);
       }
       return head;
    }

    public static ListNode insertCore(ListNode head, ListNode node)
    {
        ListNode cur = head;
        ListNode next = head.next;

        //循环节点遍历的时候要防止死循环，所以判断条件是当前节点和下一个节点都不等于头节点
        while( next != head )
        {
            if( cur.val <= node.val && next.val >= node.val){
                //在中间插入
                cur.next = node;
                node.next = next;
                return head;
            }
            cur = next;
            next = next.next;
        }


        //如果没有找到合适的插入位置，说明当前节点是最大值或者最小值，插入到头节点和目前最大值的节点之间。
        node.next = head;
        cur.next = node;

        //如果当前节点是最小值，则返回当前节点
        if( next.val >= node.val){
          return node;
        }
        
        //如果当前节点是最大值，则返回头节点
        return head;
    }

}
