package linked_list;

public class DetectCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head.next;
        if(slow == null) return false;
        ListNode fast = head.next.next;
        while(slow != fast) {
            if(slow == null || fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
