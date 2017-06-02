package linkedList;

import java.util.Stack;

public class AddLists {

	public static void main(String[] args) {

	}

	public Node addList_1(Node head1, Node head2) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		Node cur1 = head1;
		Node cur2 = head2;
		while (cur1 != null) {
			stack1.push(cur1.value);
			cur1 = cur1.next;
		}
		while (cur2 != null) {
			stack2.push(cur2.value);
			cur2 = cur2.next;
		}
		int carry = 0;
		int n1 = 0;
		int n2 = 0;
		int n = 0;
		Node prev = null;
		Node cur = null;
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			n1 = stack1.isEmpty() ? 0 : stack1.pop();
			n2 = stack2.isEmpty() ? 0 : stack2.pop();
			n = n1 + n2 + carry;
			prev = cur;
			cur = new Node(n % 10);
			cur.next = prev;
			carry = n / 10;
		}
		if (carry == 1) {
			prev = cur;
			cur = new Node(1);
			cur.next = prev;
		}
		return cur;
	}
	
	public Node addList_2(Node head1, Node head2) {
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		Node cur1 = head1;
		Node cur2 = head2;
		int n1 = 0;
		int n2 = 0;
		int n = 0;
		int carry = 0;
		Node prev = null;
		Node cur = null;
		while(cur1 != null || cur2 != null) {
			n1 = cur1 != null ? cur1.value : 0;
			n2 = cur2 != null ? cur2.value : 0;
			n = n1 + n2 + carry;
			prev = cur;
			cur = new Node(n % 10);
			cur.next = prev;
			carry = n / 10;
			cur1 = cur1 != null ? cur1.next : null;
			cur2 = cur2 != null ? cur2.next : null;
		}
		if(carry == 1) {
			prev = cur;
			cur = new Node(1);
			cur.next = prev;
		}
		reverseList(head1);
		reverseList(head2);
		return cur;
	}

	private Node reverseList(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node p = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}
}
