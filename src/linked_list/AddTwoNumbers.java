package linked_list;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode temp = null;
        ListNode prev = null;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int digit = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            temp = new ListNode(digit);
            if(result == null) result = temp;
            else {
                prev.next = temp;
            }
            prev = temp;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            int digit = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            temp = new ListNode(digit);
            if(result == null) result = temp;
            else {
                prev.next = temp;
            }
            prev = temp;
            l1 = l1.next;
        }
        while(l2 != null) {
            int digit = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            temp = new ListNode(digit);
            if(result == null) result = temp;
            else {
                prev.next = temp;
            }
            prev = temp;
            l2 = l2.next;
        }
        if(carry != 0) {
            temp = new ListNode(carry);
            prev.next = temp;
        }
        return result;
    }
}
