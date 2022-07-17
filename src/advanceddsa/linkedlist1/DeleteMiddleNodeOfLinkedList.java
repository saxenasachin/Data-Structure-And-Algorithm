package advanceddsa.linkedlist1;

/**
 * Given a singly linked list, delete middle of the linked list.
 * <p>
 * For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5
 * <p>
 * If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.
 * <p>
 * For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.
 * <p>
 * Return the head of the linked list after removing the middle node.
 * <p>
 * If the input linked list has 1 node, then this node should be deleted and a null node should be returned.
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is the node pointing to the head node of the linked list
 */
public class DeleteMiddleNodeOfLinkedList {

    /**
     * use slow and fast pointer approach to find middle element.
     * keep track of previous node to slow pointer
     *
     * @param A - head of linked list
     * @return - return head after deleting middle node
     */
    public static ListNode solve(ListNode A) {
        if (A == null) return null;
        if (A.next == null) return null;
        ListNode slowPtr = A;
        ListNode fastPtr = A;
        ListNode prevPtr = null;
        while (fastPtr != null && fastPtr.next != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        prevPtr.next = slowPtr.next;
        return A;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode head = solve(node1);
        printList(head);
        System.out.println(head);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}