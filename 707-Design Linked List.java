class MyLinkedList {
    
    private ListNode head = null, tail = null;
    
    private int length = 0;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }
        
        ListNode node = head;
        for (int i = 0; i < index; ++i) {
            node = node.next;
        }
        return node.value;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val, head);
        if (length == 0) {
            tail = node;
        }
        head = node;
        length += 1;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val, null);
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        
        length += 1;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index >= 0 && index <= length) {
            ListNode node = head;
            for (int i = 0; i < index - 1; ++i) {
                node = node.next;
            }
            
            ListNode newNode = new ListNode(val, node == null ? null : node.next);
            if (index > 0) {
                node.next = newNode;
            }
            if (index == length) {
                tail = newNode;
            }
            if (index == 0) {
                newNode.next = head;
                head = newNode;
            }
            
            length += 1;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < length) {
            ListNode node = head;
            for (int i = 0; i < index - 1; ++i) {
                node = node.next;
            }
            
            if (index == 0) {
                head = head.next;
                node = node.next;
            }
            if (index > 0) {
                node.next = node.next.next;
            }
            if (index == length - 1) {
                tail = node;
            }
            
            length -= 1;
        }
    }
    
    private static class ListNode {
        int value;
        ListNode next;
        ListNode(int v, ListNode n) {
            value = v;
            next = n;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */