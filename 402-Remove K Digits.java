class Solution {

    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == 0) return "0";

        Node head = new Node('a', null);
        Node temp = head;
        for (char c : num.toCharArray()) {
            Node n = new Node(c, null);
            temp.next = n;
            temp = n;
        }

        for (int i = 0; i < k; ++i) {
            while (head.next != null && head.next.c == '0') {
                head.removeNext();
            }

            Node current = head.next;
            Node pre = head;
            if (current == null) return "0";

            while (current.next != null && current.c <= current.next.c) {
                pre = current;
                current = current.next;
            }
            pre.removeNext();
        }

        while (head.next != null && head.next.c == '0') {
            head.removeNext();
        }
        StringBuilder builder = new StringBuilder();
        while (head.next != null) {
            builder.append(head.next.c);
            head = head.next;
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }

    private class Node {
        char c;
        Node next;
        Node(char c, Node n) {
            this.c = c;
            this.next = n;
        }

        void removeNext() {
            if (this.next != null) {
                this.next = this.next.next;
            }
        }
    }

}
