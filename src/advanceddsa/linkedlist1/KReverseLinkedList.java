package advanceddsa.linkedlist1;

/**
 * Problem Description
 * Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 103
 * <p>
 * B always divides A
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument of input contains a pointer to the head of the linked list.
 * <p>
 * The second argument of input contains the integer, B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a pointer to the head of the modified linked list.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5, 6]
 * B = 2
 * Input 2:
 * <p>
 * A = [1, 2, 3, 4, 5, 6]
 * B = 3
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [2, 1, 4, 3, 6, 5]
 * Output 2:
 * <p>
 * [3, 2, 1, 6, 5, 4]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * For the first example, the list can be reversed in groups of 2.
 * [[1, 2], [3, 4], [5, 6]]
 * After reversing the K-linked list
 * [[2, 1], [4, 3], [6, 5]]
 * Explanation 2:
 * <p>
 * For the second example, the list can be reversed in groups of 3.
 * [[1, 2, 3], [4, 5, 6]]
 * After reversing the K-linked list
 * [[3, 2, 1], [6, 5, 4]]
 */
public class KReverseLinkedList {

    public static ListNode reverseList(ListNode A, int B) {
        return null;
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

        int B = 2;

        ListNode head = reverseList(node1, B);
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
