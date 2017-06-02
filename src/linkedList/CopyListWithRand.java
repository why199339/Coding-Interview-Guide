package linkedList;

public class CopyListWithRand {

	public static void main(String[] args) {

	}

	public Node copyListWithRand(Node head) {
		if(head == null) {
			return head;
		}
		Node cur = head;
		Node next = null;
		while(cur != null) {
			next = cur.next;
			Node copy = new Node(cur.value);
			cur.next = copy;
			copy.next = next;
			cur = next;
		}
		Node copy = null;
		cur = head;
		while(cur != null) {
			next = cur.next.next;
			copy = cur.next;
			copy.rand = (cur.rand != null) ? cur.rand.next : null;
			cur = next;
		}
		Node copyHead = head.next;
		cur = head;
		while(cur != null) {
			next = cur.next.next;
			copy = cur.next;
			cur.next = next;
			copy.next = (next != null) ? next.next : next;
			cur = next;
		}
		return copyHead;
	}
}
