public class SM3_DZ {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static class LinkedListReversal {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;

            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }

            return prev;
        }

        public static void main(String[] args) {

            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(3);
            ListNode node4 = new ListNode(4);

            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = null;

            LinkedListReversal reversal = new LinkedListReversal();

            ListNode reversedHead = reversal.reverseList(node1);

            while (reversedHead != null) {
                System.out.print(reversedHead.val + " ");
                reversedHead = reversedHead.next;
            }
        }
    }
}