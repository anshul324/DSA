package linked_list;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyList {
    class Solution {
        public RandomNode copyRandomList(RandomNode head) {
            Map<RandomNode, RandomNode> map = new HashMap<>();
            RandomNode curr = head;
            while(curr != null) {
                map.put(curr, new RandomNode(curr.val));
                curr = curr.next;
            }
            curr = head;
            while(curr != null) {
                map.get(curr).next = map.get(curr.next);
                map.get(curr).random = map.get(curr.random);
                curr = curr.next;
            }
            return map.get(head);
        }
    }
}
