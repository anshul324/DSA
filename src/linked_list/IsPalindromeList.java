package linked_list;

public class IsPalindromeList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode last = null;
        while(fast != null && fast.next != null) {
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null) {
            last = slow;
            slow = slow.next;
        }
        ListNode curr = slow;
        ListNode prev = null;
        ListNode nextNode;
        while(curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        last.next = prev;
        while(prev != null) {
            if(prev.val != head.val) return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}
