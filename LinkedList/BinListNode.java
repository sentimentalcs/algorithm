package LinkedList;

public class BinListNode {
    public int val;
    public BinListNode next;
    public BinListNode prev;
    public BinListNode child;

    BinListNode(int value)
    {
        this.val = value;
        this.next = null;
        this.prev = null;
    }

    BinListNode(BinListNode prevNode,int value,BinListNode nextNode)
    {
        this.val = value;
        this.next = nextNode;
        this.prev = prevNode;
    }

}
