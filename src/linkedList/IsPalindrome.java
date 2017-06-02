package linkedList;

import java.util.Stack;

public class IsPalindrome {

	public static void main(String[] args) {

	}

	public boolean isPalindrome_1(Node head) {
		Stack<Node> stack = new Stack<>();
		Node node = head;
		while (node != null) {
			stack.push(node);
			node = node.next;
		}
		while (head != null) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	
	public boolean isPalindrome_2(Node head) {
		if(head == null || head.next == null) {
			return true;
		}
		Node slow = head;
		Node fast = head.next;
		while(fast != null || fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow = slow.next;
		Stack<Node> stack = new Stack<>();
		while(slow != null) {
			stack.push(slow);
			slow = slow.next;
		}
		while(!stack.isEmpty()) {
			if(head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	public boolean isPalindrome_3(Node head) {
		if(head == null || head.next == null) {
			return true;
		}
		Node slow = head;
		Node fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node prev = slow;
		Node cur = slow.next;
		slow.next = null;
		while(cur != null) {
			Node next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		Node left = head;
		Node right = prev;
		boolean result = true;
		while(left != null && right != null) {
			if(left.value != right.value) {
				result = false;
			}
			left = left.next;
			right = right.next;
		}
		cur = prev.next;
		prev.next = null;
		while(cur != null) {
			Node next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return result;
	}
}
