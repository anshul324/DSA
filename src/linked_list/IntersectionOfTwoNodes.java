package linked_list;

public class IntersectionOfTwoNodes {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != tempB) {
            tempA = tempA != null ? tempA.next : headA;
            tempB = tempB != null ? tempB.next : headB;
        }
        return tempA;
    }
}
