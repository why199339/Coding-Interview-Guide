package linkedList;

public class Relocate {

	public static void main(String[] args) {

	}

	public void relocate(Node head) {
		if(head == null || head.next == null) {
			return ;
		}
		Node mid = head;
		Node right = head.next;
		while(right.next != null && right.next.next != null) {
			mid = mid.next;
			right = right.next.next;
		}
		right = mid.next;
		mergeLR(head, right);
	}

	private void mergeLR(Node left, Node right) {
		Node next = null;
		while(left.next != null) {
			next = right.next;
			right.next = left.next;
			left.next = right;
			right = next;
			left = left.next.next;
		}
		left.next = right;
	}
}
