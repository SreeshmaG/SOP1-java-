import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class LinkedListAddition {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public static ListNode createListFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers in reverse order (end with -1):");
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (true) {
            int value = scanner.nextInt();
            if (value == -1) break;
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummyHead.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Enter first list:");
        ListNode l1 = createListFromUserInput();

        System.out.println("Enter second list:");
        ListNode l2 = createListFromUserInput();

        LinkedListAddition solution = new LinkedListAddition();
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.print("Result: ");
        printList(result);
    }
}
