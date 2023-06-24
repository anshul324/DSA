package linked_list;

public class RemoveNthFromLast {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
            ++length;
            temp = temp.next;
        }
        temp = head;
        int i = length - n;
        if(i == 0) return head.next;
        ListNode prev = temp;
        while(i-- > 0) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        return head;
    }
    public ListNode removeNthFromEndOneTraverse(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode slow = start;
        ListNode fast = start;
        while(n-- > 0) {
            fast = fast.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}
