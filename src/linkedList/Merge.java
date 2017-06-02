package linkedList;

public class Merge {

	public static void main(String[] args) {

	}

	public Node merge(Node head1, Node head2) {
		if(head1 == null) {
			return head2;
		}
		if(head2 == null) {
			return head1;
		}
		Node head = (head1.value < head2.value) ? head1 : head2;
		Node cur1 = (head == head1) ? head1 : head2;
		Node cur2 = (head == head1) ? head2 : head1;
		Node prev = null;
		Node next = null;
		while(cur1 != null && cur2 != null) {
			if(cur1.value <= cur2.value) {
				prev = cur1;
				cur1 = cur1.next;
			} else {
				next = cur2.next;
				prev.next = cur2;
				cur2.next = cur1;
				prev = cur2;
				cur2 = next;
			}
		}
		return head;
	}
}
