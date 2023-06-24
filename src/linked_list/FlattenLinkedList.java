package linked_list;

public class FlattenLinkedList {
    Node merge(Node root, Node nextRoot) {
        Node result = root.data >= nextRoot.data ? nextRoot : root;
        Node prev = null;
        while(root != null && nextRoot != null) {
            while(root != null && nextRoot != null && root.data < nextRoot.data) {
                prev = root;
                root = root.bottom;
            }
            if(prev != null) {
                prev.bottom = nextRoot;
            }
            while(root != null && nextRoot != null && root.data >= nextRoot.data) {
                prev = nextRoot;
                nextRoot = nextRoot.bottom;
            }
            if(prev != null) {
                prev.bottom = root;
            }
        }
        if(root != null) {
            prev.bottom = root;
        }
        if(nextRoot != null) {
            prev.bottom = nextRoot;
        }
        return result;
    }

    Node flatten(Node root)
    {
        // Your code here
        if(root == null || root.next == null) return root;
        root.next = flatten(root.next);
        return merge(root, root.next);
    }
}
