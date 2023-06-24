package linked_list;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode result = list1.val > list2.val ? list2 : list1;
        ListNode prev = null;
        while(list1 != null && list2 != null) {
            while(list1 != null && list2 != null && list1.val <= list2.val) {
                prev = list1;
                list1 = list1.next;
            }
            if(prev != null) prev.next = list2;
            while(list1 != null && list2 != null && list1.val > list2.val) {
                prev = list2;
                list2 = list2.next;
            }
            if(prev != null) prev.next = list1;
        }
        if(list1 != null) {
            prev.next = list1;
        }
        if(list2 != null) {
            prev.next = list2;
        }
        return result;
    }
}
