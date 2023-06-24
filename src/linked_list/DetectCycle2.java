package linked_list;

public class DetectCycle2 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow != fast) {
            if(fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow != head) {
            slow = slow.next;
            head = head.next;
        }
        return slow;
    }
}
