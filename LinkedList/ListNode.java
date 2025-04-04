package LinkedList;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int value)
    {
        this.val = value;
        this.next = null;
    }

    ListNode(int value,ListNode nextNode)
    {
        this.val = value;
        this.next = nextNode;
    }

}
