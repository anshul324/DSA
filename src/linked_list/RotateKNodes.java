package linked_list;

public class RotateKNodes {
    ListNode reverseKNodes(ListNode head, boolean tillEnd, int k, ListNode prev) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode nextNode;
        ListNode x = prev;
        while(curr != null && (tillEnd || k-- > 0)) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        head.next = curr;
        if(x != null) {
            x.next = prev;
        }
        return prev;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        ListNode temp = head;
        int length = 0;
        while(temp != null) {
            temp = temp.next;
            ++length;
        }
        k = k % length;
        if(k == 0) return head;
        ListNode reverseList = reverseKNodes(head, true, 0, null);
        ListNode a = reverseKNodes(reverseList, false, k, null);
        ListNode prev = null;
        temp = a;
        for(int i = 0; i < k; ++i) {
            prev = temp;
            temp = temp.next;
        }
        reverseKNodes(temp, true, 0, prev);
        return a;
    }
}
