package linked_list;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newSecondLast = head.next;
        ListNode newHead = reverseList(head.next);
        newSecondLast.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode reverseListIterative(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode current = head;
        ListNode nextNode;
        while(current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
