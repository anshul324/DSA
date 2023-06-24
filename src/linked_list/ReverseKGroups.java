package linked_list;

public class ReverseKGroups {
    public ListNode reverseKGroupSecondApproach(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
            ++length;
            temp = temp.next;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr;
        ListNode nextNode;
        while(length >= k) {
            curr = prev.next;
            nextNode = curr.next;
            for(int i = 1; i < k; ++i) {
                curr.next = nextNode.next;
                nextNode.next = prev.next;
                prev.next = nextNode;
                nextNode = curr.next;
            }
            prev = curr;
            length -= k;
        }
        return dummy.next;
    }

    public ListNode reverseKGroupFirstApproach(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
            ++length;
            temp = temp.next;
        }
        ListNode prev = null;
        ListNode newHead = null;
        ListNode current = head;
        ListNode nextNode;
        ListNode lastNode = null;
        ListNode firstNode = null;
        for(int i = 0; i < length / k; ++i) {
            int kVal = k;
            firstNode = current;
            while(kVal-- > 0) {
                nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }
            if(lastNode != null) {
                lastNode.next = prev;
            }
            lastNode = firstNode;
            if(newHead == null) {
                newHead = prev;
            }
            prev = null;
        }
        lastNode.next = current;
        return newHead;
    }
}
