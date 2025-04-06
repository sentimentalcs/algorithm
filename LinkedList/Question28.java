package LinkedList;


public class Question28 {
    public static void main(String[] args) {
      BinListNode node1 = new BinListNode(1);
      BinListNode node2 = new BinListNode(2);
      BinListNode node3 = new BinListNode(3);
      BinListNode node4 = new BinListNode(4);
      BinListNode node5 = new BinListNode(5);
      BinListNode node6 = new BinListNode(6);
      BinListNode node7 = new BinListNode(7);
      BinListNode node8 = new BinListNode(8);
      BinListNode node9 = new BinListNode(9);

      node1.next = node2;

      node2.prev = node1;
      node2.next = node3;
      node2.child = node5;

      node3.prev = node2;
      node3.next = node4;

      node4.prev = node3;

      node5.next = node6;
      
      node6.prev = node5;
      node6.next = node7;
      node6.child = node8;

      node7.prev = node6;
      
      node8.next = node9;
      node9.prev = node8;

      BinListNode head = flattern(node1);
    }


    // 问题：在一个循环链表中节点的值递增排序，请设计一个算法在该循
    // 环链表中插入节点，并保证插入节点之后的循环链表仍然是排序的。例如，
    // 图 4.15（a）所示是一个排序的循环链表，插入一个值为 4 的节点之后的链
    // 表如图 4.15（b）所示。
    public static BinListNode flattern(BinListNode head)
    {
       flatternCore(head);
       return head;
    }

    public static BinListNode flatternCore(BinListNode node)
    {
       BinListNode tail = null;
        while( node!= null)
        {
            BinListNode next = node.next;
            if( node.child != null)
            {
                node.next = node.child;

                BinListNode lastTailNode = flatternCore(node.child);
                lastTailNode.next = next;
                node.child = null;
                tail = lastTailNode;
            }else {
              tail = node;
            }
            node = next;
        }

        return tail;
    }

}
