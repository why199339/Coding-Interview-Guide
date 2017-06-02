package linkedList;

public class ReveerseList {

	public static void main(String[] args) {

	}

	public Node reverseList(Node head) {
		Node reversedHead = null;
		Node prev = null;
		Node cur = head;
		while (cur != null) {
			Node next = cur.next;
			if (next == null) {
				reversedHead = cur;
			}
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return reversedHead;
	}

	public DoubleNode reverseList(DoubleNode head) {
		DoubleNode reversedHead = null;
		DoubleNode prev = null;
		DoubleNode cur = head;
		while (cur != null) {
			DoubleNode next = cur.next;
			if (next == null) {
				reversedHead = cur;
			}
			if (prev != null) {
				prev.prev = cur;
			}
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return reversedHead;
	}
}
