public class makeLinkedList {
    interface LinkedList {
        ListNode add(ListNode head, ListNode nodeToAdd, int position);
        ListNode remove(ListNode head, int positionToRemove);
        boolean contains(ListNode head, ListNode nodeTocheck);
        void printList(ListNode head);
    }

    static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int input) {
            this.data = input;
            this.next = null;
        }
    }

    static class LinkedListImpl implements LinkedList {

        public void printList(ListNode head) {
            while (head != null) {
                System.out.println(head.data);
                head = head.next;
            }
        }

        public int size(ListNode head) {
            ListNode node = head;
            int size = 1;
            while (node.next != null) {
                node = node.next;
                size++;
            }
            return size;
        }

        public ListNode add(ListNode head, ListNode nodeToAdd, int position) {

            ListNode node = head;
            if (position == 0) {
                if (head == null) {
                    return nodeToAdd;
                }
                ListNode add = nodeToAdd;
                add.next = head;
                head = add;
                return head;
            }

            for (int i = 0; i < position - 1; i++) {
                node = node.next;
            }
            nodeToAdd.next = node.next;
            node.next = nodeToAdd;
            return head;
        }

        public boolean contains(ListNode head, ListNode nodeTocheck) {
            while (head != null) {

                if (head.data == nodeTocheck.data) {
                    return true;
                }
                head = head.next;
            }
            return false;
        }

        public ListNode remove(ListNode head, int positionToRemove) {
            ListNode node = head;
            if (positionToRemove == 0) {
                head = head.next;
            } else {
                for (int i = 0; i < positionToRemove - 1; i++) {
                    node = node.next;
                }
                ListNode delNode = node.next;
                node.next = node.next.next;
            }
            return head;
        }
    }
}