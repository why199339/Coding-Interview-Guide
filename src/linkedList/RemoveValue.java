package linkedList;

public class RemoveValue {

	public static void main(String[] args) {

	}

	public Node removeValue(Node head, int num) {
		if(head == null) {
			return head;
		}
		while(head != null && head.value == num) {
			head = head.next;
		}
		Node prev = head;
		Node cur = head;
		while(cur != null) {
			if(cur.value == num) {
				prev.next = cur.next;
			} else {
				prev = cur;
			}
			cur = cur.next;
		}
		return head;
	}
}
