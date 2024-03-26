class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class RemoveNFirstNodes {

    public static ListNode removeNFirstNodes(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null; 
        }

        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        if (n >= length) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < n; i++) {
            prev = prev.next;
        }
        prev.next = null;

        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Lista original:");
        printList(head);

        int n = 3;
        ListNode result = removeNFirstNodes(head, n);

        System.out.println("Lista depois de remover os " + n + " primeiro: ");
        printList(result);
    }

}
