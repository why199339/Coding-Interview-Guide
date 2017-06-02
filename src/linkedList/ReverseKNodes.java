package linkedList;

import java.util.Stack;

public class ReverseKNodes {

	public static void main(String[] args) {

	}

	public Node reverseKNodes_1(Node head, int k) {
		if(k < 2) {
			return head;
		}
		Stack<Node> stack = new Stack<>();
		Node newHead = head;
		Node cur = head;
		Node prev = null;
		Node next = null;
		while(cur != null) {
			next = cur.next;
			stack.push(cur);
			if(stack.size() == k) {
				prev = resign1(stack, prev, next);
				newHead = newHead == head ? cur : newHead;
			}
			cur = next;
		}
		return newHead;
	}

	private Node resign1(Stack<Node> stack, Node left, Node right) {
		Node cur = stack.pop();
		if(left != null) {
			left.next = cur;
		}
		Node next = null;
		while(!stack.isEmpty()) {
			next = stack.pop();
			cur.next = next;
			cur = next;
		}
		cur.next = right;
		return cur;
	}
	
	public Node reverseKNodes_2(Node head, int k) {
		if (k < 2) {
			return head;
		}
		Node cur = head;
		Node start = null;
		Node prev = null;
		Node next = null;
		int count = 1;
		while(cur != null) {
			next = cur.next;
			if(k == count) {
				start = prev == null ? head : prev.next;
				head = prev == null ? cur : head;
				resign2(prev, start, cur ,next);
				prev = start;
				count = 0;
			}
			count ++;
			cur = next;
		}
		return head;
	}

	private void resign2(Node left, Node start, Node end, Node right) {
		Node prev = start;
		Node cur = start.next;
		Node next = null;
		while(cur != right) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		if(left != null) {
			left.next = end;
		}
		start.next = right;
	}
}
