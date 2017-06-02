package linkedList;

public class GetIntersectNode {

	public static void main(String[] args) {

	}

	public Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if (loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null;
	}

	private Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		if(loop1 == loop2) {
			Node cur1 = head1;
			Node cur2 = head2;
			int len = 0;
			while(cur1 != loop1) {
				len ++;
				cur1 = cur1.next;
			}
			while(cur2 != loop1) {
				len --;
				cur2 = cur2.next;
			}
			cur1 = len > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			len = Math.abs(len);
			while(len > 0) {
				cur1 = cur1.next;
				len --;
			}
			while(cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {
			Node cur1 = loop1.next;
			while(cur1 != loop1) {
				if(cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}

	private Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		int len = 0;
		while (cur1 != null) {
			cur1 = cur1.next;
			len++;
		}
		while (cur2 != null) {
			cur2 = cur2.next;
			len--;
		}
		if (cur1 != cur2) {
			return null;
		}
		cur1 = len > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		len = Math.abs(len);
		while (len > 0) {
			cur1 = cur1.next;
			len--;
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	private Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node slow = head.next;
		Node fast = head.next.next;
		while (slow != fast) {
			if (fast.next == null || fast.next.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
